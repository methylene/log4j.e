(ns log4j.e-test
  (:require [clojure.test :refer :all])
  (:import [org.apache.log4j BasicConfigurator]
           [log4j e]
           [org.apache.log4j Logger]))

(defn dostuff [] 
  (do 
    (BasicConfigurator/configure (e.))
    (let [log (Logger/getLogger "foo.bar")]
      (.info log "hi"))))


(deftest slow.test (dostuff))
