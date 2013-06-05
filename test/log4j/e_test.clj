(ns log4j.e-test
  (:require [clojure.test :refer :all])
  (:import [org.apache.log4j BasicConfigurator]
           [org.apache.log4j.xml DOMConfigurator]
           [it.log4je ElasticAppender]
           [org.apache.log4j Logger]))

(defn dostuff [] 
  (let [e-app (ElasticAppender.)]
    (BasicConfigurator/configure e-app)
    (let [log (Logger/getLogger "foo.bar")]
      (.info log "hi"))))


(deftest slow.test (dostuff))
