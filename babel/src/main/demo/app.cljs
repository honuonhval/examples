(ns demo.app
  (:require [shadow.markup.react :as html :refer ($ defstyled)]
            [shadow.dom :as dom]
            ["react" :as react]
            ["react-dom" :refer (render)]
            ["./bar" :refer (MyComponent)]))

(defstyled title :h1
           [env]
           {:color "red"})

(defn root []
  (html/div
    (title "CLJS!")
    ;; $ is a little interop helper
    ($ MyComponent {:hello "this is from CLJS!!!"})
    ;; this works as well
    #_ (react/createElement Foo #js {:hello "also from CLJS!"})))

(defn ^:export mount-root []
  (render (root) (dom/by-id "app")))


(defn ^:export main []
  (js/console.log "app init")
  (mount-root))

