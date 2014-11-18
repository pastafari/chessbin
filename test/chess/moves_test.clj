(ns chess.moves-test
  (:require [expectations :refer :all]
            [chess.moves :refer :all]
            [chess.board :refer :all]
            [chess.pieces :refer :all]))

;; Board validations
;; no piece on from square
(expect false
        (valid? start-state {:from [:a 4]
                             :to [:a 5]
                             :piece white-pawn}))

;; Pawn moves
;; a3 in starting state is a valid move
(expect true
        (valid? start-state {:from [:a 2]
                             :to [:a 3]
                             :piece white-pawn}))


;; a4 in starting state is a valid move
(expect true
        (valid? start-state {:from [:a 2]
                             :to [:a 4]
                             :piece white-pawn}))



;; a5 in starting state is not a valid move
(expect false
        (valid? start-state {:from [:a 2]
                             :to [:a 5]
                             :piece white-pawn}))


;; pawn can't move from a3 to a6
(expect false
        (valid? (add-piece empty-board [:a 3] white-pawn)
                {:from [:a 3]
                 :to [:a 6]
                 :piece white-pawn}))


;; pawn can kill diagonally
(expect true
        (valid? (-> empty-board
                    (add-piece [:a 4] white-pawn)
                    (add-piece [:b 5] black-knight))
                {:from [:a 4]
                 :to [:b 5]
                 :piece white-pawn}))
