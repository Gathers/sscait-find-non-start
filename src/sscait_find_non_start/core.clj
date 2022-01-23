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

(defn get-names-and-cmds
  "Extracts bot names and number of commands."
  [game]
  (let [screp (:screp game)
        names-to-id (->> (get-in screp ["Header" "Players"])
                         (map #(into {} {(get % "ID") (get % "Name")}))
                         (reduce merge))]
    (->> (get-in screp ["Computed" "PlayerDescs"])
         (map #(into {} {(names-to-id (get % "PlayerID")) (get % "CmdCount")}))
         (reduce merge))))

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
                         :url (str url "/" (second %))}))
         (filter #(<= (:id %) max-id))
         (map #(assoc % :screp (analyze-with-screp (:url %))))
         (map #(assoc % :names_cmds (get-names-and-cmds %)))
         (map #(assoc % :between (keys (:names_cmds %)))))))

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
      game-cmds-map (->> games
                         (map #(into {} {(:id %) (:names_cmds %)}))
                         (reduce (partial merge-with (partial merge-with max))))
      nostart-cmds-map (->> game-cmds-map
                            seq
                            (filter #(> 5 (reduce min (vals (second %))))))
      nostart-ids (sort (keys nostart-cmds-map))
      dropped-game-ids (->> game-ids
                            frequencies
                            (filter #(not (= 2 (last %))))
                            (map first)
                            sort)
      dropped-games (filter #(contains? (set dropped-game-ids) (:id %)) games)
      missing-ids (filter #(not (contains? (set game-ids) %)) (range 1 (inc total-rr-games)))]
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
  (print (str (->> games
                   (filter #(contains? (set nostart-ids) (:id %)))
                   (map :text)
                   sort)))
  (println "\nNumber of times each bot was in a game where any bot has a missing replay:")
  (println (->> dropped-games
                (map :between)
                (reduce concat)
                frequencies
                (sort-by second)
                reverse))
  (println "\nNumber of times each bot was in a game where any bot had less than 5 cmds:")
  (println (->> nostart-cmds-map
                (map second)
                (map seq)
                (reduce concat)
                (map first)
                frequencies
                (sort-by second)
                reverse))
  (println "\nEstimated number of less than 5 cmds no-start losses per bot:")
  (println (->> nostart-cmds-map
                (map second)
                (map seq)
                (reduce concat)
                (filter #(> 5 (second %)))
                (map first)
                frequencies
                (sort-by second)
                reverse))
  (println "\nEstimated number of less than 5 cmds no-start wins per bot:")
  (println (->> nostart-cmds-map
                (map second)
                (map seq)
                (reduce concat)
                (filter #(< 5 (second %)))
                (map first)
                frequencies
                (sort-by second)
                reverse))
  (println "\nFrequency of min(cmds) in all replays ([min(cmds) occurances]):")
  (println (->> games
                (map #(reduce min (vals (:names_cmds %))))
                frequencies
                (filter #(< 3 (second %)))
                sort
                reverse
                (sort-by second)
                reverse)))
