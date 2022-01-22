(ns sscait-find-non-start.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [clojure.java.io :as io]
            [clojure.java.shell :as shell]
            [clojure.string :as string]))

(def sscait-api-url "https://sscaitournament.com/api/")
(def sscait-replays-url "https://sscaitournament.com/Replays/")

(def fetch-url
  "Fetch URL with delay and caching."
  (memoize (fn [url]
             (println "Fetched" url)
             (Thread/sleep 200)
             (:body (client/get url)))))

(defn get-vs
  "Get name of opponent from replay name."
  [bot text]
  (let [bot (string/upper-case bot)
        text (string/upper-case text)
        a (subs text 5 9)
        b (subs text 10 14)]
    (if (string/starts-with? bot a) b a)))

(def analyze-with-screp
  "Download and run SCREP on replay."
  (memoize
   (fn [url]
     (let [filename (str "replays/" (last (string/split url #"/")))]
       (io/make-parents filename)
       (when-not (.exists (io/file filename))
         (doall
          (println "Downloading" filename)
          (some->
           (client/get url {:as :byte-array})
           :body
           (io/copy (io/file filename)))))
       (->> filename
            (shell/sh "replays/screp")
            :out
            json/read-str)))))

(defn get-games-for
  "Get list of games by bot."
  [bot]
  (let [url  (->> (string/escape (java.net.URLEncoder/encode bot) {\+ "%20"})
                  string/upper-case
                  (str sscait-replays-url))]
    (->> url
         fetch-url
         (re-seq #"(?i)<td><a href=\"(\S+\.rep)\">(.*)</a>")
         (map #(into {} {:id (Integer/parseInt (re-find #"\d+" (last %)))
                         :text (last %)
                         :url (str url "/" (second %))
                         :vs (get-vs bot (last %))}))
         (filter #(< (:id %) 2971))
         (map #(assoc % :screp (analyze-with-screp (:url %))))
         (map #(assoc % :min_cmds (as-> % x
                                    (:screp x)
                                    (get-in x ["Computed" "PlayerDescs"])
                                    (map (fn [_] (_ "CmdCount")) x)
                                    (reduce min x)))))))

(let [bots (->> (str sscait-api-url "bots.php")
                fetch-url
                json/read-str
                (filter #(= (get % "status") "Enabled"))
                (map #(% "name")))
      games (flatten (map get-games-for bots))
      game-ids (map :id games)
      total-games (count (distinct game-ids))
      dropped-game-ids (->> game-ids
                            frequencies
                            (filter #(not (= 2 (last %))))
                            (map first)
                            sort)
      dropped-games (filter #(contains? (set dropped-game-ids) (:id %)) games)
      missing-ids (filter #(not (contains? (set game-ids) %)) (range 1 total-games))
      nostart-games (filter #(< (:min_cmds %) 5) games)
      nostart-ids (->> nostart-games
                       (map :id)
                       distinct
                       sort)]
  (println "Found a total of" total-games "games from" (count bots) "bots.")
  (println "\nMissing both replays for" (count missing-ids) "games:")
  (println missing-ids)
  (println "\nMissing one replay for" (count dropped-game-ids) "games:")
  (println dropped-game-ids)
  (print (str (->> dropped-games
                   (map :text)
                   sort)))
  (println "\nFound" (count nostart-ids) "games where at least one bot has less than 5 cmds:")
  (println nostart-ids)
  (print (str (->> nostart-games
                   (map :text)
                   sort)))
  (println "\nFrequency of one missing replay per bot:")
  (println (->> dropped-games
                (map :vs)
                frequencies
                (sort-by second)
                reverse))
  (println "\nFrequency of less than 5 cmds in replay per bot:")
  (println (->> nostart-games
                (map :vs)
                frequencies
                (sort-by second)
                reverse))
  (println "\nFrequency of min(cmds) in all replays ([min(cmds) occurances]):")
  (println (->> games
                (map :min_cmds)
                frequencies
                (filter #(< 3 (second %)))
                sort
                reverse
                (sort-by second)
                reverse)))
