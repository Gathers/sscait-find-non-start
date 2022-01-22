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

(defn get-between
  "Get short name of both bots from replay name."
  [text]
  (let [text (string/upper-case text)
        a (subs text 5 9)
        b (subs text 10 14)]
    [a b]))

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
  [max-id bot]
  (let [url  (->> (string/escape (java.net.URLEncoder/encode bot) {\+ "%20"})
                  string/upper-case
                  (str sscait-replays-url))]
    (->> url
         fetch-url
         (re-seq #"(?i)<td><a href=\"(\S+\.rep)\">(.*)</a>")
         (map #(into {} {:id (Integer/parseInt (re-find #"\d+" (last %)))
                         :text (last %)
                         :url (str url "/" (second %))
                         :between (get-between (last %))}))
         (filter #(<= (:id %) max-id))
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
      total-bots (count bots)
      total-rr-games (* total-bots (dec total-bots))
      games (flatten (map (partial get-games-for total-rr-games) bots))
      game-ids (map :id games)
      total-games (count (distinct game-ids))
      dropped-game-ids (->> game-ids
                            frequencies
                            (filter #(not (= 2 (last %))))
                            (map first)
                            sort)
      dropped-games (filter #(contains? (set dropped-game-ids) (:id %)) games)
      missing-ids (filter #(not (contains? (set game-ids) %)) (range 1 (inc total-rr-games)))
      nostart-games (filter #(< (:min_cmds %) 5) games)
      nostart-ids (->> nostart-games
                       (map :id)
                       distinct
                       sort)]
  (println "Found a total of" total-games "games from" total-bots "bots, expecting" total-rr-games "games.")
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
  (println "\nNumber of times each bot was in a game where any bot has a missing replay:")
  (println (->> dropped-games
                (map :between)
                (reduce concat)
                frequencies
                (sort-by second)
                reverse))
  (println "\nNumber of times each bot was in a replay where any bot had less than 5 cmds:")
  (println (->> nostart-games
                (map :between)
                (reduce concat)
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
