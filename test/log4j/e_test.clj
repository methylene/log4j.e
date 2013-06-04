(ns log4j.e-test
  (:require [clojure.test :refer :all]
            [log4j.e :as je])
  (:import [org/apache/log4j BasicConfigurator]
           [h908714124.log4j.e ElasticAppender]
           [org.apache.log4j Logger]))

(defn dostuff [] 
  (do 
    (BasicConfigurator/configure (ElasticAppender.)) 
    (let [log (Logger/getLogger "foo.bar")]
      (.info log "hi")))))


(deftest slow.test (dostuff))
