(ns sscait-find-non-start.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [clojure.string :as string]))

(def sscait-api-url "https://sscaitournament.com/api/")
(def sscait-replays-url "https://sscaitournament.com/Replays/")

(def fetch-url
  "Fetch URL with delay and caching."
  (memoize (fn [url]
             (println "Fetched" url)
             (Thread/sleep 200)
             (:body (client/get url)))))

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
                         :url (str url "/" (second %))}))
         (filter #(< (:id %) 5000)))))

(let [bots (->> (str sscait-api-url "bots.php")
                fetch-url
                json/read-str
                (filter #(= (get % "status") "Enabled"))
                (map #(% "name")))
      games (flatten (map get-games-for bots))
      game-ids (map :id games)
      total-games (count (distinct game-ids))
      dropped-games (->> game-ids
                         frequencies
                         (filter #(not (= 2 (last %))))
                         (mapv first)
                         set)]
  (println "Found" (count dropped-games) "possibly dropped games out of a total of" total-games "games from" (count bots) "bots.")
  (->>  games
        (filter #(contains? dropped-games (:id %)))
        (map :text)
        sort))
