(ns clojure-noob.core
  (:gen-class)
  (:require [clojure.string :as string]))

(defn -main
  "I don't do a whole lot ... yet."
  [& _args]
  (println "I'm a little teapot!"))


(defn hello
  "This is basic description"
  []
  "World!")

(hello)


;; IF
(if true "This will execute if true!" "Else, this will exectute!")
(if false "This will execute if true!" "Else, this will exectute!")
(if false "This will not execute!")


;; DO
;; This operator lets you do multiple things in each of the if expression’s branches.
(do
  (println (str "It was the panda " "in the library " "with a dust buster"))
  (+ 1 2 3))

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

;; WHEN
;; Use when if you want to do multiple things when some condition is true,
;; and you always want to return nil when the condition is false.
(when true
  (println "Success!")
  "abra cadabra")

;; nil, true, false, Truthiness, Equality, and Boolean Expressions
;; Clojure has true and false values. nil is used to indicate no value in Clojure.
;; Both nil and false are used to represent logical falsiness, whereas all other values are logically truthy.
;; or returns either the first truthy value or the last value.
;; and returns the first falsey value or, if no values are falsey, the last truthy value.

(nil? 1)
(nil? nil)

(if "bears eat beets"
  "bears beets Battlestar Galactica")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

(= 1 1)
(= nil nil)
(= 1 2)

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
(or (= 0 1) (= "yes" "no"))
(or nil)

(and :free_wifi :hot_coffe)
(and :feelin_super_cool nil false)

;; DEF
;; You use def to bind a name to a value in Clojure.
(def failed-protagonist-names ["Larry Potter" "Doreen the Explorer" "The incredible Bulk"])
failed-protagonist-names

;; STRINGS

"Lord Voldemort"
"\"He who must not be named\""
"\"Great cow of Moscow!\" - Hermes Conrad"

;; Clojure doesn’t have string interpolation. It only allows concatenation via the str function.
(def character "Chewbacca")
(str "\"Uggllglglglglglglglll\" - " character)

;; MAPS
;; Map values can be of any type—strings, numbers, maps, vectors, even functions.
{}
(hash-map :a 1, :b 2)
{:first-name "Charlie", :last-name "McFishwich"}
{"string-key" +}
{:name {:first "John"
        :middle "Jacob"
        :last "Jingleheimerschmidt"}}

;; You can look up values in maps with the get function
(get {:a 0, :b 1} :b)
(get {:a 0, :b {:c "ho hum"}} :b)
(get {:a 0, :b 1} :c)
(get {:a 0 :b 1} :c "unicorns?")

;; Another way to look up a value in a map is to treat the map like a function with the key as its argument.
({:name "The Human Coffeepot"} :name)

;; Get-in function lets you look up values in nested maps.
(get-in {:a 0, :b {:c "ho hum"}} [:b :c])

;; KEYWORDS
;; Keywords can be used as functions that look up the corresponding value in a data structure.
(:a {:a 1 :b 2 :c 3})
(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")
(:a #{:a :b})

;; VECTORS

[3 2 1]
(vector "creepy" "full" "moon")

(get [3 2 1] 1)
(get ["a" {:name "Pugley Winterbottom"} "c"] 1)

;; You can use the conj function to add additional elements to the vector.
(conj [1 2 3 4] 5)


;; LISTS

'(1 2 3 4)
(list 1 "two" {3 4})

;; It’s good to know that using nth to retrieve an element from a list is slower than
;; using get to retrieve an element from a vector.
(nth '(:a :b :c) 0)
(nth '(:a :b :c) 2)

;; Elements are added to the beginning of a list.
(conj '(1 2 3) 4)

;; When should you use a list and when should you use a vector?
;; A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list.
;; Otherwise, you should use a vector.
;; As you learn more, you’ll get a good feel for when to use which.


;; SETS

#{"kurt vonnegut" 20 :icicle}
(hash-set 1 1 2 2)

(conj #{:a :b} :b)

;; You can also create sets from existing vectors and lists by using the set function.
(set [3 3 3 4 4])

;; You can check for set membership using the contains? function.
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(contains? #{nil} nil)

;; Get set member
(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a :b} "Kurt")

;; FUNCTIONS

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOOOMED!")))

;; Function call is just another term for an operation where the operator is a function
;; or a function expression (an expression that returns a function).
(error-message :mild)


(or + -)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])

;; Clojure functions can be defined with zero or more parameters.
;; The values you pass to functions are called arguments, and the arguments can be of any type.
;; The number of parameters is the function’s arity.

(defn no-params []
  "I take no params")

(defn one-params [x]
  (str "I take one param: " x))

(defn two-params [x y]
  (str "I take two params: " x y))

(no-params)
(one-params 1)
(two-params 1 2)

(defn do-things [& args] (map #(str "Argument: " %1) args))

(defn multi-arity
  ([first second third] (do-things first second third))
  ([first second] (do-things first second))
  ([first] (do-things first)))

(multi-arity 1)
(multi-arity 1 2)
(multi-arity 1 2 3)

;; Let

(def x 3)
x
(let [x (inc x)] x)
x

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

;; LOOPS

;; loop
(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye")
    (recur (inc iteration))))

;; classic recursion
(defn recursive-printer
  ([] (recursive-printer 0))
  ([iteration]
   (println (str "Iteration " iteration))
   (if (> iteration 3)
     (println "Goodbye")
     (recursive-printer (inc iteration)))))

(recursive-printer)

;; Same as `.times` in Ruby
(dotimes [name 5] (println name))

;; Same as Enum.each/2 in Elixir
(doseq [x (range 5)] (println x))


;; REGEX

(re-find #"^left-" "left-eye")
(re-find #"left-" "cleft")
(re-find #"^left-" "janjetina")

(defn matching-part
  [part]
  {:name (string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-hand", :size 1})
(matching-part {:name "head", :size 3})


;; Enumerations

(map (fn [x] x) (range 5))

(reduce + 15 [1 2 3 4])

(defn my-reduce
  ([f val [head & tail]]
   (if (nil? head) val (my-reduce f (f val head) tail)))

  ([f [head & tail]]
   (my-reduce f head tail)))

(my-reduce + 15 [1 2 3 4])
(my-reduce + [1 2 3 4])

(defn my-reduce-2
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))

  ([f [head & tail]]
   (my-reduce-2 f head tail)))

(my-reduce-2 + 15 [1 2 3 4])

;; Evaluation


(comment
  (defmacro backwards
    [form]
    (reverse form))

  (backwards (" backwards" " am" "I" str))

  (def addition-list (list + 1 2))
  (eval addition-list)
  (eval (concat addition-list [10]))

  (eval (list 'def 'lucky-number (concat addition-list [10])))
  lucky-number

  (read-string "(+ 1 2)")
  (list? (read-string "(+ 1 2)"))
  (eval (conj (list (read-string "(+ 1 2)")) 3 '=))
  (eval (read-string "(+ 1 2)"))
  (#(+ 1 %) 3)
  (read-string "#(+ 1 %)")
  (read-string "'(a b c)")
  (read-string "@var")
  (read-string "; ignore!\n(+ 1 2)")

  true
  false
  {}
  :huzzah
  ()

  (if true :a :b)

  (let [x 5] (+ x 3))
  (def x 15)
  (+ x 3)

  (def x 15)
  (let [x 5]
    (+ x 3))


  (let [x 5]
    (let [x 6]
      (+ x 3)))

  (defn exclaim
    [exclamation]
    (str exclamation "!"))

  (exclaim "Hadoken")

  (map inc [1 2 3])

  (read-string "+")
  (type (read-string "+"))
  (list (read-string "+") 1 2)
  (eval (list (read-string "+") 1 2))

  (eval (read-string "()"))

  '(a b c)

  (read-string "(1 + 1)")
  (eval (read-string "(1 + 1)"))

  (let [infix (read-string "(1 + 1)")]
    (list (second infix) (first infix) (last infix)))

  (eval
   (let [infix (read-string "(1 + 1)")]
     (list (second infix) (first infix) (last infix))))

  (defmacro ignore-last-operand [function-call]
    (butlast function-call))

  (ignore-last-operand (+ 1 2 10))
  (ignore-last-operand (+ 1 2 (println "look at me!!!")))
  (macroexpand '(ignore-last-operand (+ 1 2 10)))
  (macroexpand '(ignore-last-operand (+ 1 2 (println "look at me!!!"))))

  (defmacro infix
    [infixed]
    (list (second infixed)
          (first infixed)
          (last infixed)))

  (eval (macroexpand '(infix (1 + 2))))
  (infix (1 + 2))

  (eval (read-string "(println \"Marko Požega\")")))

;; Threads, Promises, and Futures

(defn do-something-in-a-thread []
  (println "Hello from the thread #2.")
  (Thread/sleep 3000)
  (println "Goodbye from the the thread #2."))

(defn thread-demo []
  (.start (Thread. do-something-in-a-thread))
  (.start (Thread. #(println "Hello from the thread #1."))))

(thread-demo)

(def f (future (Thread/sleep 2000) (println "Done") 1))

@f

(future (Thread/sleep 2000) (println "Janje"))



(string/lower-case "cIydJZy0PsMtktoS9yJWIDcRKMPXrjc+hdt3mpJ1")

;; (def atom-example (atom 0))
;; (def future-inc (future (swap! atom-example inc)))
;; (def future-dec (future (swap! atom-example dec)))
;; @future-inc
;; @future-dec
;; @atom-example

;; (doseq [_ (range 10)] (future (println "f1:" (swap! atom-example inc)) (future (println "f2:" (swap! atom-example dec))))

;; @atom-example


(doseq [x [1 2 3]
        y [4 5]
        :let [z (+ x y)]]
  (println x "+" y "=" z))


(def numbers [1 2 3])

(as-> numbers $
  (map inc $)
  (filter odd? $)
  (first $)
  (hash-map :result $ :id 1))

(some-> (rand-nth [1 nil])
        (inc))

(defn parse-int
  [v]
  #?(:clj  (Integer/parseInt v)
     :cljs (js/parseInt v)))

(parse-int "123")


(defprotocol IInvertible
  "This is a protocol for data types that are 'ivertible'"
  (invert [this] "Invert the given name"))

(extend-type java.lang.String
  IInvertible
  (invert [this] (apply str (reverse this))))

(extend-type clojure.lang.PersistentList
  IInvertible
  (invert [this] (reverse this)))

(extend-type clojure.lang.PersistentVector
  IInvertible
  (invert [this] (into [] (reverse this))))

(invert "janjetina")
(invert '(1 2 3 4))
(invert [1 2 3 4])

(extend-protocol IInvertible
  java.lang.String
  (invert [this] (apply str (reverse this))))

(extend-protocol IInvertible
  clojure.lang.PersistentList
  (invert [this] (reverse this)))

(extend-protocol IInvertible
  clojure.lang.PersistentVector
  (invert [this] (into [] (reverse this))))

(invert "janjetina")
(invert '(1 2 3 4))
(invert [1 2 3 4])

(defrecord User [firstname lastname])
(def person (User. "Marko" "Požega"))
(def person (->User "Marko" "Požega"))
(:firstname person)
(type person)
