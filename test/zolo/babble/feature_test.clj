(ns zolo.babble.feature-test
 (:use [clojure.test :only [run-tests deftest is]])
 (:use zolo.babble.feature))

(def *some-var*)

(defmacro with-some-var [var-value & body]
  (binding [*some-var* var-value]
    (do ~@body)))




