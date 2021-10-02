;; get every line
(defn getline [spaces,blocks]
  (clojure.string/join ""
    (for [i (range (+ spaces blocks))]
      (if (< i spaces) " " "#")
    )
  )
)

;; get a collection of all the lines
(defn mario [n]
  (for [i (range n)]
    (getline
      (- n (+ i 1))
      (+ i 1))
  )
)

;; print all the lines
(defn print_mario [n]
  (for [line
        ;; add a aditional line to avoid and extra space
        (cons "" (mario n))]
    (println line)
  )
)

(print_mario 10)
