(ns clojure-noob.shires-next-top-model
  (:require [clojure.string :as string]))

(def asym-hobbit-body-parts [{:name "head", :size 3}
                             {:name "left-eye", :size 1}
                             {:name "left-ear", :size 1}
                             {:name "mouth", :size 1}
                             {:name "nose", :size 1}
                             {:name "neck", :size 2}
                             {:name "left-shoulder", :size 3}
                             {:name "left-upper-arm", :size 3}
                             {:name "chest", :size 10}
                             {:name "back", :size 10}
                             {:name "left-forearm", :size 3}
                             {:name "abdomen", :size 6}
                             {:name "left-kidney", :size 1}
                             {:name "left-hand", :size 2}
                             {:name "left-knee", :size 2}
                             {:name "left-thigh", :size 4}
                             {:name "left-lower-leg", :size 3}
                             {:name "left-achilles", :size 1}
                             {:name "left-foot", :size 2}])

(defn matching-part
  [part]
  {:name (string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Reduce implementation"
  [asym-body-parts]
  (reduce
   #(into %1 (set [%2 (matching-part %2)]))
   []
   asym-body-parts))

(symmetrize-body-parts asym-hobbit-body-parts)

(defn hit
  [asym-body-parts]
  (let [sym-parts (symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)

