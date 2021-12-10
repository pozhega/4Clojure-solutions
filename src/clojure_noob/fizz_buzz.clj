(ns clojure-noob.fizz-buzz)

(defn do-fizz-buzz [num]
  (cond
    (= (mod num 15) 0) "Fizz Buzz"
    (= (mod num 3) 0) "Fizz"
    (= (mod num 5) 0) "Buzz"
    :else num))

(defn -main [to]
  (map do-fizz-buzz (range 1 to)))

(-main 55)
