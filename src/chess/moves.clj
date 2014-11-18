(ns chess.moves
  (:require [chess.board :as board]))

(defmulti legal-move?
  (fn [{:keys [piece from to]} board]
    (:rank piece)))

;; pawns can move one step forward
;; or two steps forward on their first move
;; or kill diagonally
(letfn [(forward-one? [[r c] [r1 c1]] (and (= c c1)
                                           (= 1 (Math/abs (- r1 r)))))
        (forward-two? [[r c] [r1 c1]] (and (= c c1)
                                           (= 2 (Math/abs (- r1 r)))))
        (kill? [[r c] [r1 c1]] (and (= 1 (Math/abs (- c1 c)))
                                    (= 1 (Math/abs (- r1 r))))) ]
    (defmethod legal-move? :pawn
      [{:keys [piece from to]} board]
      (or (forward-one? from to)
          (and (forward-two? from to)
               (= board board/start-state))
          (kill? from to))))


(defn valid?
  [board move]
  (legal-move? move board))
