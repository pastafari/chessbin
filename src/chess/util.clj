(ns chess.util)

(def rank-file->row-column
  "Converts rank-file notation to row column"
  (let [file->column (comp (zipmap [:a :b :c :d :e :f :g :h]
                                   (range))
                           first)
        rank->row (comp dec second)]
    (juxt rank->row file->column)))
