(ns demo.server
  (:require ["koa" :as koa]
            [clojure.string :as str]))

(defonce app-ref (atom nil))

(defn handler [ctx next]
  (set! (. ctx -body) "hello world")
  (next))

(defn delay-by-two-seconds [ctx next]
  (-> (js/Promise.
        (fn [resolve reject]
          (js/setTimeout resolve 2000)))
      (.then next)))

(defn append-async [ctx next]
  (-> (next)
      (.then
        (fn []
          (set! (. ctx -body) (str/upper-case (. ctx -body)))))))


(defn main []
  (let [app (koa.)]
    (reset! app-ref app)

    (doto app
      (.use delay-by-two-seconds)
      (.use handler)
      (.use append-async)
      (.listen 3000))
    (println "Listening on 3000")))
