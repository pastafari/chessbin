(ns chess.core-test
  (:require [expectations :refer :all]
            [chess.core :refer :all]
            [chess.board :refer [start-state]]
            [chess.pieces :refer :all]))

;; Fresh board - e4
(expect (-> start-state
            (assoc-in [6 4] nil)
            (assoc-in [5 4] white-pawn))
        (make-move start-state {:from [6 4]
                                :to [5 4]
                                :piece white-pawn}))

;; Fresh board - Ng1-f3
(expect (-> start-state
            (assoc-in [7 6] nil)
            (assoc-in [5 5] white-knight))
        (make-move start-state {:from [7 6]
                                :to [5 5]
                                :piece white-knight}))


;; Invalid move leads to exception
(expect {:type :bad-move-exception}
        (in (make-move start-state {:from [7 6]
                                    :to [5 4]
                                    :piece white-knight})))
