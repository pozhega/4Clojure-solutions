(ns clojure-noob.4clojure
  (:require [clojure.set :as set]
            [clojure.string :as string]))

;; [Problem 1: Nothing but the Truth [Elementary]](http://www.4clojure.com/problem/1)

(= true true)

;; [Problem 2: Simple Math [Elementary]](http://www.4clojure.com/problem/2)

(= (- 10 (* 2 3)) 4)

;; [Problem 3: Intro to Strings [Elementary]](http://www.4clojure.com/problem/3)

(= "HELLO WORLD" (.toUpperCase "hello world"))

;; [Problem 4: Intro to Lists [Elementary]](http://www.4clojure.com/problem/4)

(= (list :a :b :c) '(:a :b :c))

;; [Problem 5: Lists: conj [Elementary]](http://www.4clojure.com/problem/5)

(def lists-conj '(1 2 3 4))
(= lists-conj (conj '(2 3 4) 1))
(= lists-conj (conj '(3 4) 2 1))

;; [Problem 6: Intro to Vectors [Elementary]](http://www.4clojure.com/problem/6)

(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; [Problem 7: Vectors: conj [Elementary]](http://www.4clojure.com/problem/7)

(def vectors-conj [1 2 3 4])
(= vectors-conj (conj [1 2 3] 4))
(= vectors-conj (conj [1 2] 3 4))

;; [Problem 8: Intro to Sets [Elementary]](http://www.4clojure.com/problem/8)

(def intro-sets #{:a :b :c :d})
(= intro-sets (set '(:a :a :b :c :c :c :c :d :d)))
(= intro-sets (set/union #{:a :b :c} #{:b :c :d}))

;; [Problem 9: Sets: conj [Elementary]](http://www.4clojure.com/problem/9)

(= #{1 2 3 4} (conj #{1 4 3} 2))

;; [Problem 10: Intro to Maps [Elementary]](http://www.4clojure.com/problem/10)

(def intro-maps 20)
(= intro-maps ((hash-map :a 10, :b 20, :c 30) :b))
(= intro-maps (:b {:a 10, :b 20, :c 30}))

;; [Problem 11: Maps: conj [Elementary]](http://www.4clojure.com/problem/11)

(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;; [Problem 12: Intro to Sequences [Elementary]](http://www.4clojure.com/problem/12)

(def intro-seq 3)
(= intro-seq (first '(3 2 1)))
(= intro-seq (second [2 3 4]))
(= intro-seq (last (list 1 2 3)))

;; [Problem 13: Sequences: rest [Elementary]](http://www.4clojure.com/problem/13)

(= [20 30 40] (rest [10 20 30 40]))

;; [Problem 14: Intro to Functions [Elementary]](http://www.4clojure.com/problem/14)

(def intro-fun 8)
(= intro-fun ((fn add-five [x] (+ x 5)) 3))
(= intro-fun ((fn add-five [x] (+ x 5)) 3))
(= intro-fun (#(+ % 5) 3))
(= intro-fun ((partial + 5) 3))

;; [Problem 15: Double Down [Elementary]](http://www.4clojure.com/problem/15)

(defn double-down [x] (* 2 x))
(= (double-down 2) 4)
(= (double-down 3) 6)
(= (double-down 11) 22)
(= (double-down 7) 14)

;; [Problem 16: Hello World [Elementary]](http://www.4clojure.com/problem/16)

(defn hello-world [name] (str "Hello, " name "!"))
(= (hello-world "Dave") "Hello, Dave!")
(= (hello-world "Jenn") "Hello, Jenn")
(= (hello-world "Rhea") "Hello, Rhea")

;; [Problem 17: Sequences: map [Elementary]](http://www.4clojure.com/problem/17)

(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; [Problem 18: Sequences: filter [Elementary]](http://www.4clojure.com/problem/18)

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; [Problem 19: Last Element [Easy]](http://www.4clojure.com/problem/19)

(defn last-element [seq]
  (loop [[head & tail] seq]
    (if (nil? tail) head (recur tail))))

(defn last-element-v2 [seq]
  (->> seq
       (count)
       (dec)
       (nth seq)))

(= (last-element [1 2 3 4 5]) (last-element-v2 [1 2 3 4 5]) 5)
(= (last-element '(5 4 3)) (last-element-v2 '(5 4 3)) 3)
(= (last-element ["b" "c" "d"]) (last-element-v2 ["b" "c" "d"]) "d")

;; [Problem 20: Penultimate Element [Easy]](http://www.4clojure.com/problem/20)

(defn penultimate-elem [coll]
  (loop [[first second third & tail] coll]
    (cond
      (nil? third) first
      (nil? tail) second
      :else (recur tail))))

(defn penultimate-elem-v2 [coll] (-> coll (reverse) (second)))

(= (penultimate-elem (list 1 2 3 4 5)) (penultimate-elem-v2 (list 1 2 3 4 5)) 4)
(= (penultimate-elem ["a" "b" "c"]) (penultimate-elem-v2 ["a" "b" "c"]) "b")
(= (penultimate-elem [[1 2] [3 4]]) (penultimate-elem-v2 [[1 2] [3 4]]) [1 2])

;; [Problem 21: Nth Element [Easy]](http://www.4clojure.com/problem/21)

(defn nth-elem [coll n]
  (loop [coll coll i 0]
    (if (= i n)
      (first coll)
      (recur (rest coll) (inc i)))))

(defn nth-elem-v2 [coll n] (->> coll (drop n) (first)))

(= (nth-elem '(4 5 6 7) 2) (nth-elem-v2 '(4 5 6 7) 2) 6)
(= (nth-elem [:a :b :c] 0) (nth-elem-v2 [:a :b :c] 0) :a)
(= (nth-elem [1 2 3 4] 1) (nth-elem-v2 [1 2 3 4] 1) 2)
(= (nth-elem '([1 2] [3 4] [5 6]) 2) (nth-elem-v2 '([1 2] [3 4] [5 6]) 2) [5 6])

;; [Problem 22: Count a Sequence [Easy]](http://www.4clojure.com/problem/22)

(defn count-seq [seq]
  (loop [[head & rest] seq i 0]
    (if (nil? head) i
        (recur rest (inc i)))))

(defn count-seq-v2 [seq]
  (->> seq
       (map (constantly 1))
       (reduce +)))

(= (count-seq '(1 2 3 3 1)) (count-seq-v2 '(1 2 3 3 1)) 5)
(= (count-seq "Hello World") (count-seq-v2 "Hello World") 11)
(= (count-seq [[1 2] [3 4] [5 6]]) (count-seq-v2 [[1 2] [3 4] [5 6]]) 3)
(= (count-seq '(13)) (count-seq-v2 '(13)) 1)
(= (count-seq '(:a :b :c)) (count-seq-v2 '(:a :b :c)) 3)

;; [Problem 23: Reverse a Sequence [Easy]](http://www.4clojure.com/problem/23)

(defn reverse-seq [seq]
  (loop [[head & tail] seq reversed []]
    (if (nil? head)
      reversed
      (recur tail (cons head reversed)))))

(defn reverse-seq-v2 [seq] (reduce conj () seq))

(= (reverse-seq [1 2 3 4 5]) (reverse-seq-v2 [1 2 3 4 5]) [5 4 3 2 1])
(= (reverse-seq (sorted-set 5 7 2 7)) (reverse-seq-v2 (sorted-set 5 7 2 7)) '(7 5 2))
(= (reverse-seq [[1 2] [3 4] [5 6]]) (reverse-seq-v2 [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

;; [Problem 24: Sum It All Up [Easy]](http://www.4clojure.com/problem/24)

(defn sum-it [coll] (reduce + coll))

(= (sum-it [1 2 3]) 6)
(= (sum-it (list 0 -2 5 5)) 8)
(= (sum-it #{4 2 1}) 7)
(= (sum-it '(0 0 -1)) -1)
(= (sum-it '(1 10 3)) 14)

;; [Problem 25: Find the odd numbers [Easy]](http://www.4clojure.com/problem/25)

(defn find-odd [coll] (filter odd? coll))

(= (find-odd #{1 2 3 4 5}) '(1 3 5))
(= (find-odd [4 2 1 6]) '(1))
(= (find-odd [2 2 4 6]) '())
(= (find-odd [1 1 1 3]) '(1 1 1 3))


;; [Problem 26: Fibonacci Sequence [Easy]](http://www.4clojure.com/problem/26)

(defn fibbonaci [n]
  (loop [seq [1 1] i 2]
    (if (>= i n)
      seq
      (recur
       (conj seq (reduce +' (take-last 2 seq)))
       (inc i)))))

(defn fibbonaci-v2 [n]
  (->> (range)
       (reductions (fn [acc _] (conj acc (apply +' (take-last 2 acc)))) [1])
       (take n)
       (last)))

(defn fibbonaci-v3 [n]
  (->> [1 1]
       (iterate (fn [[a b]] [b (+' a b)]))
       (map first)
       (take n)))

(= (fibbonaci 3) (fibbonaci-v2 3) (fibbonaci-v3 3) '(1 1 2))
(= (fibbonaci 6) (fibbonaci-v2 6) (fibbonaci-v3 6) '(1 1 2 3 5 8))
(= (fibbonaci 8) (fibbonaci-v2 8) (fibbonaci-v3 8) '(1 1 2 3 5 8 13 21))

;; [Problem 27: Palindrome Detector [Easy]](http://www.4clojure.com/problem/27)

(defn palindrome-detector [coll] (= (seq coll) (reverse coll)))

(false? (palindrome-detector '(1 2 3 4 5)))
(true? (palindrome-detector "racecar"))
(true? (palindrome-detector [:foo :bar :foo]))
(true? (palindrome-detector '(1 1 3 3 1 1)))
(false? (palindrome-detector '(:a :b :c)))

;; [Problem 28: Flatten a Sequence [Easy]](http://www.4clojure.com/problem/28)

(defn flatten-seq [seq]
  (loop [[head & tail] seq flat []]
    (cond
      (nil? head) flat
      (sequential? head) (recur tail (vec (concat flat (flatten-seq head))))
      (char? head) (recur tail (conj flat (str head)))
      :else (recur tail (conj flat head)))))

(defn flatten-seq-v2 [coll]
  (->> coll
       (tree-seq sequential? seq)
       (remove sequential?)))

(= (flatten-seq '((1 2) 3 [4 [5 6]])) (flatten-seq-v2 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (flatten-seq ["a" ["b"] "c"]) (flatten-seq-v2 ["a" ["b"] "c"]) '("a" "b" "c"))
(= (flatten-seq '((((:a))))) (flatten-seq-v2 '((((:a))))) '(:a))

;; [Problem 29: Get the Caps [Easy]](http://www.4clojure.com/problem/29)

(defn get-caps [string] (apply str (re-seq #"[A-Z]" string)))

(= (get-caps "HeLlO, WoRlD!") "HLOWRD")
(empty? (get-caps "nothing"))
(= (get-caps "$#A(*&987Zf") "AZ")

;; [Problem 30: Compress a Sequence [Easy]](http://www.4clojure.com/problem/30)

(defn compress-seq [seq]
  (reduce #(if (= (last %1) %2) %1 (conj %1 %2)) [] seq))

(defn compress-seq-v2 [seq]
  (->> seq
       (partition-by identity)
       (map first)))

(= (apply str (compress-seq "Leeeeeerrroyyy")) (apply str (compress-seq-v2 "Leeeeeerrroyyy")) "Leroy")
(= (compress-seq [1 1 2 3 3 2 2 3]) (compress-seq-v2 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (compress-seq [[1 2] [1 2] [3 4] [1 2]]) (compress-seq-v2 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

;; [Problem 31: Pack a Sequence [Easy]](http://www.4clojure.com/problem/31)

(defn pack-seq [seq] (partition-by identity seq))

(= (pack-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (pack-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (pack-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

;; [Problem 32: Duplicate a Sequence [Easy]](http://www.4clojure.com/problem/32)

(defn duplicate-seq [seq] (apply concat (map #(list % %) seq)))

(defn duplicate-seq-v2 [seq] (mapcat #(list % %) seq))

(= (duplicate-seq [1 2 3]) (duplicate-seq-v2 [1 2 3]) '(1 1 2 2 3 3))
(= (duplicate-seq [:a :a :b :b]) (duplicate-seq-v2 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (duplicate-seq [[1 2] [3 4]]) (duplicate-seq-v2 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; [Problem 33: Replicate a Sequence [Easy]](http://www.4clojure.com/problem/33)

(defn replicate-seq [seq n] (mapcat #(repeat n %) seq))

(= (replicate-seq [1 2 3] 2) '(1 1 2 2 3 3))
(= (replicate-seq [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (replicate-seq [4 5 6] 1) '(4 5 6))
(= (replicate-seq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (replicate-seq [44 33] 2) [44 44 33 33])

;; [Problem 34: Implement range [Easy]](http://www.4clojure.com/problem/34)

(defn my-range [from to]
  (->> from
       (iterate inc)
       (take-while #(< % to))))

(= (my-range 1 4) '(1 2 3))
(= (my-range -2 2) '(-2 -1 0 1))
(= (my-range 5 8) '(5 6 7))

;; [Problem 35: Local bindings [Elementary]](http://www.4clojure.com/problem/35)

(def local-binding 7)
(= local-binding (let [x 5] (+ 2 x)))
(= local-binding (let [x 3, y 10] (- y x)))
(= local-binding (let [x 21] (let [y 3] (/ x y))))

;; [Problem 36: Let it Be [Elementary]](http://www.4clojure.com/problem/36)

(= 10 (let [_z 1 y 3 x 7] (+ x y)))
(= 4 (let [z 1 y 3 _x 7] (+ y z)))
(= 1 (let [z 1 _y 3 _x 7] z))

;; [Problem 37: Regular Expressions [Elementary]](http://www.4clojure.com/problem/37)

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; [Problem 38: Maximum value [Easy]](http://www.4clojure.com/problem/38)

(defn max-val [& values] (last (sort values)))

(= (max-val 1 8 3 4) 8)
(= (max-val 30 20) 30)
(= (max-val 45 67 11) 67)

;; [Problem 39: Interleave Two Seqs [Easy]](http://www.4clojure.com/problem/39)

(defn interleave-ts [seq-1 seq-2]
  (mapcat vector seq-1 seq-2))

(= (interleave-ts [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (interleave-ts [1 2] [3 4 5 6]) '(1 3 2 4))
(= (interleave-ts [1 2 3 4] [5]) [1 5])
(= (interleave-ts [30 20] [25 15]) [30 25 20 15])

;; [Problem 40: Interpose a Seq [Easy]](http://www.4clojure.com/problem/40)

(defn interpose-seq [value seq]
  (->> seq
       (mapcat #(list % value))
       (drop-last)))

(= (interpose-seq 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (interpose-seq ", " ["one" "two" "three"])) "one, two, three")
(= (interpose-seq :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;; [Problem 41: Drop Every Nth Item [Easy]](http://www.4clojure.com/problem/41)

(defn drop-nth [seq step]
  (keep-indexed #(if-not (= (mod (inc %1) step) 0) %2) seq))

(defn drop-nth-v2 [seq step]
  (->> seq
       (partition-all (dec step) step)
       (apply concat)))

(= (drop-nth [1 2 3 4 5 6 7 8] 3) (drop-nth-v2 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (drop-nth [:a :b :c :d :e :f] 2) (drop-nth-v2 [:a :b :c :d :e :f] 2) [:a :c :e])
(= (drop-nth [1 2 3 4 5 6] 4) (drop-nth-v2 [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; [Problem 42: Factorial Fun [Easy]](http://www.4clojure.com/problem/42)

(defn factorial [n]
  (if (= n 1) n
      (* n (factorial (dec n)))))

(defn factorial-v2 [n]
  (->> (inc n)
       (range 1)
       (apply *)))

(= (factorial 1) (factorial-v2 1) 1)
(= (factorial 3) (factorial-v2 3) 6)
(= (factorial 5) (factorial-v2 5) 120)
(= (factorial 8) (factorial-v2 8) 40320)

;; [Problem 43: Reverse Interleave [Medium]](http://www.4clojure.com/problem/43)

(defn reverse-interleave [seq n]
  (->> (range n)
       (map #(drop % seq))
       (map #(take-nth n %))))

(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

;; [Problem 44: Rotate Sequence [Medium]](http://www.4clojure.com/problem/44)

(defn rotate-seq [n seq]
  (let [move (mod n (count seq))]
    (concat (drop move seq) (take move seq))))

(defn rotate-seq-v2 [n seq]
  (->> seq
       (cycle)
       (drop (mod n (count seq)))
       (take (count seq))))

(= (rotate-seq 2 [1 2 3 4 5]) (rotate-seq-v2 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (rotate-seq -2 [1 2 3 4 5]) (rotate-seq-v2 -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (rotate-seq 6 [1 2 3 4 5]) (rotate-seq-v2 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (rotate-seq 1 '(:a :b :c)) (rotate-seq-v2 1 '(:a :b :c)) '(:b :c :a))
(= (rotate-seq -4 '(:a :b :c)) (rotate-seq-v2 -4 '(:a :b :c)) '(:c :a :b))

;; [Problem 45: Into to Iterate [Easy]](http://www.4clojure.com/problem/45)

(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

;; [Problem 46: Flipping out [Medium]](http://www.4clojure.com/problem/46)

(defn flip-out [f]
  (fn [& args] (apply f (reverse args))))

(= 3 ((flip-out nth) 2 [1 2 3 4 5]))
(= true ((flip-out >) 7 8))
(= 4 ((flip-out quot) 2 8))
(= [1 2 3] ((flip-out take) [1 2 3 4 5] 3))

;; [Problem 47: Contain Yourself [Easy]](http://www.4clojure.com/problem/47)

(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 4)
(contains? {4 :a 2 :b} 4)
(not (contains? [1 2 4] 4))

;; [Problem 48: Intro to some [Easy]](http://www.4clojure.com/problem/48)

(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

;; [Problem 49: Split a sequence [Easy]](http://www.4clojure.com/problem/49)

(defn split-seq [n seq]
  [(take n seq) (drop n seq)])

(= (split-seq 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
(= (split-seq 1 [:a :b :c :d]) [[:a] [:b :c :d]])
(= (split-seq 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

;; [Problem 50: Split by Type [Medium]](http://www.4clojure.com/problem/50)

(defn type-split [seq]
  (->> seq
       (group-by type)
       (vals)))

(= (set (type-split [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set (type-split [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set (type-split [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

;; [Problem 52: Intro to Destructuring [Easy]](http://www.4clojure.com/problem/52)

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] (range 1 6)] [a b c d]))

;; [Problem 53: Longest Increasing Sub-Seq [Hard]](http://www.4clojure.com/problem/53)

(defn longest-subseq [seq]
  (->> (rest seq)
       (reduce
        (fn [acc val]
          (let [last-subseq (peek acc)]
            (if (> val (peek last-subseq))
              (conj (vec (drop-last acc)) (conj last-subseq val))
              (conj acc [val]))))
        [[] [(first seq)]])
       (remove #(= (count %) 1))
       (sort)
       (last)))

(and (= (longest-subseq [1 0 1 2 3 0 4 5]) [0 1 2 3])
     (= (longest-subseq [5 6 1 3 2 7]) [5 6])
     (= (longest-subseq [2 3 3 4 5]) [3 4 5])
     (= (longest-subseq [7 6 5 4]) []))

;; [Problem 54: Partition a Sequence [Medium]](http://www.4clojure.com/problem/54)

(defn my-partition [n seq]
  (let [parts (inc (int (Math/floor (/ (count seq) n))))]
    (map #(->> seq
               (split-at (* n %))
               (first)
               (take-last n))
         (range 1 parts))))


(defn my-partition-v2 [n seq]
  (lazy-seq
   (when (>= (count seq) n)
     (cons (take n seq) (my-partition-v2 n (nthnext seq n))))))

(and
 (= (my-partition 3 (range 9)) (my-partition-v2 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
 (= (my-partition 2 (range 8)) (my-partition-v2 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
 (= (my-partition 3 (range 8)) (my-partition-v2 3 (range 8)) '((0 1 2) (3 4 5))))

;; [Problem 55: Count Occurrences [Medium]](http://www.4clojure.com/problem/55)

(defn count-occ [seq]
  (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} seq))

(defn count-occ-v2 [seq]
  (apply merge-with + (for [e seq] {e 1})))

(and
 (= (count-occ [1 1 2 3 2 1 1]) (count-occ-v2 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
 (= (count-occ [:b :a :b :a :b]) (count-occ-v2 [:b :a :b :a :b]) {:a 2, :b 3})
 (= (count-occ '([1 2] [1 3] [1 3])) (count-occ-v2 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))

;; [Problem 56: Find Distinct Items [Medium]](http://www.4clojure.com/problem/56)

(defn find-distinct [seq]
  (reduce #(if (some #{%2} %1) %1 (conj %1 %2)) [] seq))

(and
 (= (find-distinct [1 2 1 3 1 2 4]) [1 2 3 4])
 (= (find-distinct [:a :a :b :b :c :c]) [:a :b :c])
 (= (find-distinct '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
 (= (find-distinct (range 50)) (range 50)))

;; [Problem 57: Simple Recursion [Elementary]](http://www.4clojure.com/problem/57)

(= [5 4 3 2 1] ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

;; [Problem 58: Function Composition [Medium]](http://www.4clojure.com/problem/58)

(defn my-comp [& funs]
  (let [[ff & rf] (reverse funs)]
    (fn [& args] (reduce #(%2 %1) (apply ff args) rf))))

(defn my-comp-v2 [& funs]
  (fn [& args]
    (reduce #(apply %2 (list %1)) args (reverse funs))))

(and
 (= [3 2 1] ((my-comp rest reverse) [1 2 3 4]))
 (= 5 ((my-comp (partial + 3) second) [1 2 3 4]))
 (= true ((my-comp zero? #(mod % 8) +) 3 5 7 9))
 (= "HELLO" ((my-comp #(.toUpperCase %) #(apply str %) take) 5 "hello world")))

;; [Problem 59: Juxtaposition [Medium]](http://www.4clojure.com/problem/59)

(defn my-juxt [& funs]
  (fn [& args] (map #(apply %1 args) funs)))

(= [21 6 1] ((my-juxt + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] ((my-juxt #(.toUpperCase %) count) "hello"))
(= [2 6 4] ((my-juxt :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

;; [Problem 60: Sequence Reductions [Medium]](http://www.4clojure.com/problem/60)

(defn my-reductions
  ([f [first & rest]]
   (my-reductions f first rest))
  ([f val [first & rest]]
   (cons val (lazy-seq
              (when (not (nil? first))
                (my-reductions f (f val first) rest))))))
(and
 (= (take 5 (my-reductions + (range))) (take 5 (reductions + (range))) [0 1 3 6 10])
 (= (my-reductions conj [1] [2 3 4]) (reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
 (= (last (my-reductions * 2 [3 4 5])) (last (reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))

;; [Problem 61: Map Construction [Easy]](http://www.4clojure.com/problem/61)

(defn my-zipmap [keys vals]
  (into {} (map #(vector %1 %2) keys vals)))


(defn my-zipmap-v2 [keys vals]
  (apply hash-map (interleave keys vals)))

(and
 (= (my-zipmap [:a :b :c] [1 2 3]) (zipmap [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
 (= (my-zipmap [1 2 3 4] ["one" "two" "three"]) (zipmap [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
 (= (my-zipmap [:foo :bar] ["foo" "bar" "baz"]) (zipmap [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))

;; [Problem 62: Re-implement Iterate [Easy]](http://www.4clojure.com/problem/62)

(defn my-iterate [f val]
  (cons val (lazy-seq (my-iterate f (f val)))))

(= (take 5 (my-iterate #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 (my-iterate inc 0)) (take 100 (range)))
(= (take 9 (my-iterate #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

;; [Problem 63: Group a Sequence [Easy]](http://www.4clojure.com/problem/63)

(defn my-group-by [f seq]
  (reduce #(assoc %1 (f %2) (conj (%1 (f %2) []) %2)) {} seq))

(defn my-group-by-v2 [f seq]
  (apply merge-with into (for [val seq] {(f val) [val]})))

(= (my-group-by #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})

(= (my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

(= (my-group-by count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

;; [Problem 64: Intro to Reduce [Elementary]](http://www.4clojure.com/problem/64)

(def intro-reduce +)

(and
 (= 15 (reduce intro-reduce [1 2 3 4 5]))
 (=  0 (reduce intro-reduce []))
 (=  6 (reduce intro-reduce 1 [2 3])))

;; [Problem 65: Black Box Testing [Medium]](http://www.4clojure.com/problem/65)

(defn black-box [seq]
  (cond
    (= (get (conj seq [:x "x"]) :x) "x") :map
    (= (get (conj seq :x) :x) :x) :set
    (= (first (conj (conj seq :x) :y)) :y) :list
    (= (last (conj (conj seq :x) :y)) :y) :vector))

(and
 (= :map (black-box {:a 1, :b 2}))
 (= :list (black-box (range (rand-int 20))))
 (= :vector (black-box [1 2 3 4 5 6]))
 (= :set (black-box #{10 (rand-int 5)}))
 (= [:map :set :vector :list] (map black-box [{} #{} [] ()])))

;; [Problem 66: Greatest Common Divisor [Easy]](http://www.4clojure.com/problem/66)

(defn gcd [a b] (if (zero? b) a (recur b (mod a b))))

(= (gcd 2 4) 2)
(= (gcd 10 5) 5)
(= (gcd 5 7) 1)
(= (gcd 1023 858) 33)

;; [Problem 67: Prime Numbers [Medium]](http://www.4clojure.com/problem/67)

(defn prime-nums [n]
  (->> (iterate #(inc %) 2)
       (remove (fn [x] (some #(= (mod x %) 0) (range 2 x))))
       (take n)))

(and
 (= (prime-nums 2) [2 3])
 (= (prime-nums 5) [2 3 5 7 11])
 (= (last (prime-nums 100)) 541))

;; Problem 68: Recurring Theme [Elementary](http://www.4clojure.com/problem/68)

(= [7 6 5 4 3]
   (loop [x 5, result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

;; [Problem 69: Merge with a Function [Medium]](http://www.4clojure.com/problem/69)

(defn my-merge-with [f & merge-list]
  (reduce (fn [result merge-in]
            (reduce (fn [temp-result [key val]]
                      (if (temp-result key)
                        (assoc temp-result key (f (temp-result key) val))
                        (assoc temp-result key val)))
                    result
                    merge-in))
          {}
          merge-list))

(= (my-merge-with * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})

(= (my-merge-with - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})

(= (my-merge-with concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})

;; [Problem 69: Word Sorting [Medium]](http://www.4clojure.com/problem/69)

(defn word-sort [string]
  (sort-by string/lower-case (string/split string #" |\!|\.|\?")))

(and
 (= (word-sort "Have a nice day.") ["a" "day" "Have" "nice"])
 (= (word-sort "Clojure is a fun language!") ["a" "Clojure" "fun" "is" "language"])
 (= (word-sort "Fools fall for foolish follies.") ["fall" "follies" "foolish" "Fools" "for"]))

;; Problem 71: Rearranging Code -> [Elementary]](http://www.4clojure.com/problem/71)

(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
   5)

;; Problem 72: Rearranging Code ->> [Elementary]](http://www.4clojure.com/problem/72)

(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

;; [Problem 73: Analyze a Tic-Tac-Toe Board [Hard]](http://www.4clojure.com/problem/73)

(defn tic-tac-toe [[[f1 f2 f3] [f4 f5 f6] [f7 f8 f9]]]
  (let [positions [[f1 f2 f3] [f4 f5 f6] [f7 f8 f9]
                   [f1 f5 f9] [f3 f5 f7]
                   [f1 f4 f7] [f2 f5 f8] [f3 f6 f9]]]
    (->> (seque positions)
         (map #(when (apply = %) (first %)))
         (filter #{:x :o})
         (first))))

(and =
     (= nil (tic-tac-toe [[:e :e :e]
                          [:e :e :e]
                          [:e :e :e]]))

     (= :x (tic-tac-toe [[:x :e :o]
                         [:x :e :e]
                         [:x :e :o]]))

     (= :o (tic-tac-toe [[:e :x :e]
                         [:o :o :o]
                         [:x :e :x]]))

     (= nil (tic-tac-toe [[:x :e :o]
                          [:x :x :e]
                          [:o :x :o]]))

     (= :x (tic-tac-toe [[:x :e :e]
                         [:o :x :e]
                         [:o :e :x]]))

     (= :o (tic-tac-toe [[:x :e :o]
                         [:x :o :e]
                         [:o :e :x]]))

     (= nil (tic-tac-toe [[:x :o :x]
                          [:x :o :x]
                          [:o :x :o]])))

;; [Problem 74: Filter Perfect Squares [Medium]](http://www.4clojure.com/problem/74)

(defn filter-squares [string]
  (letfn [(parse-integer [str] (Integer/parseInt str))
          (perfect-square? [num] (= (Math/sqrt num) (Math/floor (Math/sqrt num))))]
    (->>
     (string/split string #",")
     (map parse-integer)
     (filter perfect-square?)
     (interpose ",")
     (apply str))))

(and
 (= (filter-squares "4,5,6,7,8,9") "4,9")
 (= (filter-squares "15,16,25,36,37") "16,25,36"))

;; [Problem 75: Euler's Totient Function [Medium]](http://www.4clojure.com/problem/75)

(defn eulers-totient [n]
  {:pre [(pos? n)]}
  (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))]
    (->>
     (range n)
     (filter #(= (gcd % n) 1))
     (count))))

(and
 (= (eulers-totient 1) 1)
 (= (eulers-totient 10) (count '(1 3 7 9)) 4)
 (= (eulers-totient 40) 16)
 (= (eulers-totient 99) 60))

;; [Problem 76: Intro to Trampoline [Medium]](http://www.4clojure.com/problem/76)

(= (range 1 12 2)
   (letfn
    [(foo [x y] #(bar (conj x y) y))
     (bar [x y] (if (> (last x) 10) x #(foo x (+ 2 y))))]
     (trampoline foo [] 1)))

;; [Problem 77: Anagram Finder [Medium]](http://www.4clojure.com/problem/77)

(defn anagrams [words]
  (->> (group-by sort words)
       (vals)
       (map set)
       (filter #(> (count %) 1))
       (into #{})))

(and
 (= (anagrams ["meat" "mat" "team" "mate" "eat"]) #{#{"meat" "team" "mate"}})
 (= (anagrams ["veer" "lake" "item" "kale" "mite" "ever"]) #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))

;; [Problem 78: Reimplement Trampoline [Medium]](http://www.4clojure.com/problem/78)

(defn my-trampoline [f & args]
  (loop [result (apply f args)]
    (if (fn? result) (recur (result)) result)))

(= (letfn [(triple [x] #(sub-two (* 3 x)))
           (sub-two [x] #(stop? (- x 2)))
           (stop? [x] (if (> x 50) x #(triple x)))]
     (my-trampoline triple 2))
   82)

(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
           (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
     (map (partial my-trampoline my-even?) (range 6)))
   [true false true false true false])

;; [Problem 79: Triangle Minimal Path [Hard]](http://www.4clojure.com/problem/79)

(defn do-min-path
  ([triangle] (do-min-path 0 triangle))
  ([idx [row & rest]]
   (if-not rest
     (row idx)
     (+ (row idx) (min (do-min-path idx rest) (do-min-path (inc idx) rest))))))

(def min-path (memoize do-min-path))

(= 7 (min-path '([1]
                 [2 4]
                 [5 1 4]
                 [2 3 4 5])))

(= 20 (min-path '([3]
                  [2 4]
                  [1 9 3]
                  [9 9 2 4]
                  [4 6 6 7 8]
                  [5 7 3 5 1 4])))

;; [Problem 80: Perfect Number [Medium]](http://www.4clojure.com/problem/80)

(defn perfect-number? [n]
  (letfn [(divisible? [num div] (zero? (mod num div)))]
    (->>
     (range 1 (/ (inc n) 2))
     (filter #(divisible? n %))
     (reduce +)
     (= n))))

(and
 (= (perfect-number? 6) true)
 (= (perfect-number? 7) false)
 (= (perfect-number? 496) true)
 (= (perfect-number? 500) false)
 (= (perfect-number? 8128) true))

;; [Problem 81: Set Intersection [Easy]](http://www.4clojure.com/problem/81)

(defn set-intersection [a b] (set (filter #(b %) a)))

(and
 (= (set-intersection #{0 1 2 3} #{2 3 4 5}) #{2 3})
 (= (set-intersection #{0 1 2} #{3 4 5}) #{})
 (= (set-intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))

;; [Problem 82: Word Chains [Hard]](http://www.4clojure.com/problem/82)

(defn word-chains [coll])

(= true (word-chains #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
(= false (word-chains #{"cot" "hot" "bat" "fat"}))
(= false (word-chains #{"to" "top" "stop" "tops" "toss"}))
(= true (word-chains #{"spout" "do" "pot" "pout" "spot" "dot"}))
(= true (word-chains #{"share" "hares" "shares" "hare" "are"}))
(= false (word-chains #{"share" "hares" "hare" "are"}))
