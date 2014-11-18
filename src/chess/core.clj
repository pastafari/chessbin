(ns chess.core
  (:require [chess.moves :as moves]))


(defn- update-board
  [board move]
  (-> board
      (assoc-in (:from move) nil)
      (assoc-in (:to move) (:piece move))))


(defn make-move
  [board move]
  (if (moves/valid? board move)
    (update-board board move)
    {:type :bad-move-exception}))
