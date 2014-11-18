(ns chess.core
  (:require [chess.moves :as moves]
            [chess.board :refer [update-board]]))


(defn make-move
  [board move]
  (if (moves/valid? board move)
    (update-board board move)
    {:type :bad-move-exception}))
