(ns chess.board
  (:require [chess.pieces :refer :all]))

(def empty-board
  (let [empty-row (into [] (repeat 8 nil))]
    (into [] (repeat 8 empty-row))))


(def start-state
  [[black-rook black-knight black-bishop black-queen black-king black-bishop black-knight black-rook]
   (into [] (repeat 8 black-pawn))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 white-pawn))
   [white-rook white-knight white-bishop white-queen white-king white-bishop white-knight white-rook]])


;; Helper for setup and tests.
(def add-piece assoc-in)
