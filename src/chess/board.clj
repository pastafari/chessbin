(ns chess.board
  (:require [chess.pieces :refer :all]
            [chess.util :refer [rank-file->row-column]]))

(def empty-board
  (let [empty-row (into [] (repeat 8 nil))]
    (into [] (repeat 8 empty-row))))


(def start-state
  [[white-rook white-knight white-bishop white-queen white-king white-bishop white-knight white-rook]
   (into [] (repeat 8 white-pawn))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 nil))
   (into [] (repeat 8 black-pawn))
   [black-rook black-knight black-bishop black-queen black-king black-bishop black-knight black-rook]])


;; rank file notation in standard chess notation
;; e.g [:a 2] is the piece on the `a` file at 2nd rank
(defn get-piece
  "Gets the piece at pos on board. pos is specified in file-rank notation
   e.g. (get-piece start-state [:a 2]) => white-pawn"
  [board pos]
  (get-in board (rank-file->row-column pos)))


(defn add-piece
  "Adds piece at pos on board. pos is specified with file-rank notation
   e.g (add-piece empty-board [:a 5] white-knight"
  [board pos piece]
  (assoc-in board (rank-file->row-column pos) piece))


(defn remove-piece
  "removes piece from pos on board"
  [board pos]
  (add-piece board pos nil))


(defn update-board
  "What does the board look like after this move?"
  [board {:keys [piece from to]}]
  (-> board
      (remove-piece from)
      (add-piece to piece)))
