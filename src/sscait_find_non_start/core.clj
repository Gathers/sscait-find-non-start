(ns sscait-find-non-start.core
  (require [net.cgrand.enlive-html :as html]))

(def sscait-scores-url "https://sscaitournament.com/index.php?action=scoresCompetitive")

(def fetch-url
  "Fetch URL with spoofed User-Agent."
  (memoize (fn [url]
             (with-open [inputstream (-> (java.net.URL. url)
                                         .openConnection
                                         (doto (.setRequestProperty "User-Agent"
                                                                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11"))
                                         .getContent)]
               (println "Fetched" url)
               (Thread/sleep 1000)
               (html/html-resource inputstream)))))

(defn get-games-for
  "Get list of games by bot."
  [bot]
  (let [content (fetch-url (str "https://sscaitournament.com/" (:url bot)))
        games-with-text (->> (html/select content [:table :tr])
                             (filter #(= "[ watch in OpenBW ]" (html/text (last (:content %)))))
                             (map (comp html/text first :content)))
        games (->> games-with-text
                   (map #(re-find #"\d+" %))
                   (map #(Integer/parseInt %))
                   (filter #(< % 30000)))]
    {:games (set games) :text (set games-with-text)}))

(let [content (fetch-url sscait-scores-url)
      bots-with-url (->> (html/select content [:table#bot_list :tr :a])
                         (filter #(and (string? (first (:content %)))
                                       (nil? (:target (:attrs %)))))
                         ;(take 4)
                         (map #(into {} {:bot (first (:content %)) :url (:href (:attrs %))})))
      bots-with-games (map #(conj % (get-games-for %)) bots-with-url)
      all-games (flatten (map vec (map :games bots-with-games)))
      total-games (count (distinct all-games))
      all-text (distinct (flatten (map vec (map :text bots-with-games))))
      dropped-games (->> all-games
                         frequencies
                         (filter #(not (= 2 (last %))))
                         (mapv first)
                         set)]
  (println "Found" (count dropped-games) "dropped games out of a total of" total-games "games from" (count bots-with-url) "bots.")
  (->> all-text
       (filter #(contains? dropped-games (Integer/parseInt (re-find #"\d+" %))))
       sort))
