(ns chess.pieces)

(def pawn {:rank :pawn})
(def knight {:rank :knight})
(def bishop {:rank :bishop})
(def rook {:rank :rook})
(def queen {:rank :queen})
(def king {:rank :king})

(defn make-piece
  [color piece]
  (merge {:color color} piece))


(def white-pawn (make-piece :white pawn))
(def black-pawn (make-piece :black pawn))

(def white-knight (make-piece :white knight))
(def black-knight (make-piece :white knight))

(def white-bishop (make-piece :white bishop))
(def black-bishop (make-piece :white bishop))

(def white-rook (make-piece :white rook))
(def black-rook (make-piece :white rook))

(def white-queen (make-piece :white queen))
(def black-queen (make-piece :white queen))

(def white-king (make-piece :white king))
(def black-king (make-piece :white king))
