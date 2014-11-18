(ns chess.moves
  (:require [chess.board :as board]
            [chess.util :refer [rank-file->row-column]]))


(defn some-piece-on-board?
  [board pos]
  (boolean (get-in board pos)))


(defn piece-on-board?
  [board piece pos]
  (= piece
     (get-in board pos)))


(defmulti legal-move?
  (fn [board {:keys [piece from to]}]
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
      [board {:keys [piece from to]}]
      (or (forward-one? from to)
          (and (forward-two? from to)
               (= board board/start-state))
          (and (some-piece-on-board? board to)
               (kill? from to)))))


(defn- normalize-move
  [{:keys [from to piece]}]
  (let [[n-from n-to] (map rank-file->row-column [from to])]
    {:piece piece
     :from n-from
     :to n-to}))


(defn valid?
  [board move]
  (let [{:keys [piece from to] :as n-move} (normalize-move move)]
    (and (piece-on-board? board piece from)
         (legal-move? board n-move))))
