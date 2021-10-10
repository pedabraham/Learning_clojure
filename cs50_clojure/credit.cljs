;transformar cada letra en un numero
(defn parseInt [c] (- (int c) 48))

(defn even [n] (= 0 (mod n 2)))

(defn checksum [card_number]
  (if
    (= 0
      (mod
        (reduce +
          (for [i
                  ;;get stringsize
                  (range (count card_number))
                :let [value
                    ;;accesar a los elementos de la string mediante indices
                      (parseInt (nth card_number i))]
                ]
            (if (=
                  (even i)
                  (even (count card_number))
                )
                ;; if i is even and count even
                (if (> 10 (* 2 value))
                  ;; if the number is smaller than 10, return the number
                  (* 2 value)
                  ;; else return (n - 10) + 1
                  (+ 1
                    (-
                      (* 2 value)
                      10
                    )
                  )
                )
                ;; if i is not the same (even or odd) that count
                value
            )
          )
        )
        10
      )
    )
    true
    false
  )
)

(defn getCompany [card_number]
  ;;AMEX
  (if (and
        (= 15 (count card_number))
        (= (parseInt (nth card_number 0)) 3)
        (or
          (= (parseInt (nth card_number 1)) 4)
          (= (parseInt (nth card_number 1)) 7)
        )
      )
      "AMEX"
      ;;VISA
      (if (and
            (= (parseInt (nth card_number 0)) 4)
            (or
              (= 13 (count card_number))
              (= 16 (count card_number))
            )
          )
          "VISA"
          (if (and
                (= 16 (count card_number))
                (= (parseInt (nth card_number 0)) 5)
                (>= (parseInt (nth card_number 1)) 1)
                (<= (parseInt (nth card_number 1)) 5)
              )
              "MASTERCARD"
              "INVALID"
          )
      )
  )
)

(defn credit [card_number]
  (if (checksum card_number)
    (getCompany card_number)
    "INVALID"
  )
)
