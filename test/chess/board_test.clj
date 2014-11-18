(ns chess.board-test
  (:require [chess.board :refer :all]
            [chess.pieces :refer :all]
            [expectations :refer :all]))

(expect white-pawn (get-piece start-state [:a 2]))
(expect black-knight (get-piece start-state [:g 8]))
(expect black-rook (get-piece start-state [:h 8]))

;; testing add-piece while we're at it
(let [board (add-piece empty-board [:a 5] white-knight)]
  (expect (get-piece board [:a 5])
          white-knight))
