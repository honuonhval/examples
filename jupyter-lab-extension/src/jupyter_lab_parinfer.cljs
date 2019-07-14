(ns jupyter-lab-extension
  (:require ["@jupyterlab/notebook" :refer [INotebookTracker]]
            ["@jupyterlab/cells" :refer [CodeCell]]))

(defn handle-active-cell-change
  [_ ^js cell]
  (when (and cell (= (type cell) CodeCell))
    (js/console.log "The active code cell is now:" cell)))

(defn ^:export activate
  "The activation function required for a
  Jupyter Lab extension."
  [app ^js notebook-tracker]
  (.connect (.-activeCellChanged notebook-tracker) handle-active-cell-change))

(def ^:export extension #js
  {:id "jupyter-lab-extension"
   :autoStart true
   :requires #js [INotebookTracker]
   :activate activate})
