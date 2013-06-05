(ns log4j.e
  (:import [org.apache.log4jAppenderSkeleton])
  (:gen-class :name it.log4je.ElasticAppender
              :extends org.apache.log4j.AppenderSkeleton))

(def properties (atom {}))

(defn -setHost [_ host] (swap! properties assoc :host host))
(defn -getHost [_] (:host @properties))
(defn -setPort [_ port] (swap! properties assoc :port port))
(defn -getPort [_] (:port @properties))
(defn -setFormat [_ format] (swap! properties assoc :format format))
(defn -getFormat [_] (:format @properties))

(defn -append [_ event]
  (format "log4j.e INFO %s %s %n" (:port @properties) (.getMessage event)))

(defn -close [_])

(defn -requiresLayout [_] false)

