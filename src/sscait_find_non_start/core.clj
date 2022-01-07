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

(defn get-vs
  "Get name of opponent from replay name."
  [bot text]
  (let [bot (string/upper-case bot)
        text (string/upper-case text)
        a (subs text 5 9)
        b (subs text 10 14)]
    (if (string/starts-with? bot a) b a)))

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
         (filter #(< (:id %) 5000)))))

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
                            (mapv first)
                            set)
      dropped-games (filter #(contains? dropped-game-ids (:id %)) games)
      missing-ids (filter #(not (contains? (set game-ids) %)) (range 1 total-games))]
  (println "Found" (count dropped-games) "possibly dropped games out of a total of" total-games "games from" (count bots) "bots:")
  (print (str (->> dropped-games
                   (map :text)
                   sort)))
  (println "Missing both replays for" (count missing-ids) "games:")
  (println missing-ids)
  (println "Number of possibly dropped games per bot:")
  (println (->> dropped-games
                (map :vs)
                frequencies
                (sort-by second)
                reverse)))
