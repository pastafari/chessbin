(ns chess.moves-test
  (:require [expectations :refer :all]
            [chess.moves :refer :all]
            [chess.board :refer :all]
            [chess.pieces :refer :all]))


;; a3 in starting state is a valid move
(expect true
        (valid? start-state {:from [6 0]
                             :to [5 0]
                             :piece white-pawn}))


;; a4 in starting state is a valid move
(expect true
        (valid? start-state {:from [6 0]
                             :to [4 0]
                             :piece white-pawn}))



;; a5 is not a valid move from starting state
(expect false
        (valid? start-state {:from [6 0]
                             :to [3 0]
                             :piece white-pawn}))


;; pawn can't move pawn from a3 to a6
(expect false
        (valid? (add-piece empty-board [5 0] white-pawn)
                {:from [5 0]
                 :to [3 0]
                 :piece white-pawn}))


;; pawn can kill diagonally
(expect true
        (valid? (-> empty-board
                    (add-piece [5 0] white-pawn)
                    (add-piece [4 1] black-knight))
                {:from [5 0]
                 :to [4 1]
                 :piece white-pawn}))

;; no piece on from square
(expect false
        (valid? start-state {:from [4 0]
                             :to [6 1]
                             :piece white-pawn}))
