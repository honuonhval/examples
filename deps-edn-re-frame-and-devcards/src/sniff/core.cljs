(ns sniff.core
  (:require  [reagent.core :as r]))

(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(defn ^:export main
  []
  (r/render [simple-component]
                  (.getElementById js/document "app")))

