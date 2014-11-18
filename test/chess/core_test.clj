(ns chess.core-test
  (:require [expectations :refer :all]
            [chess.core :refer :all]
            [chess.board :refer :all]
            [chess.pieces :refer :all]))

;; Fresh board - e4
(expect (-> start-state
            (remove-piece [:e 2])
            (add-piece [:e 4] white-pawn))
        (make-move start-state {:from [:e 2]
                                :to [:e 4]
                                :piece white-pawn}))

;; Pawns cant move diagonally!
(expect {:type :bad-move-exception}
        (in (make-move start-state {:from [:a 2]
                                    :to [:c 3]
                                    :piece white-pawn})))
