(ns zolo.babble.feature-spec
 (:use [clojure.test :only [run-tests deftest is]])
 (:use org.rathore.amit.babble.feature))

(def *some-var*)

(defmacro with-some-var [var-value & body]
  (binding [*some-var* var-value]
    (do ~@body)))




