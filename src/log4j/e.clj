(ns log4j.e
  (:import [org.apache.log4jAppenderSkeleton])
  (:gen-class :name log4j.e
              :extends org.apache.log4j.AppenderSkeleton))

(def properties (atom {}))

(defn -setHost [_ host] (swap! properties assoc :host host))
(defn -getHost [_] (:host @properties))
(defn -setPort [_ port] (swap! properties assoc :port port))
(defn -getPort [_] (:port @properties))
(defn -setFormat [_ format] (swap! properties assoc :format format))
(defn -getFormat [_] (:format @properties))

;; implement void append(LoggingEvent event):
(defn -append [_ event] ; first argument is 'this', ignored
  (println (.getMessage event))) ; just print the event message (to *out*)

;; implement void close()
(defn -close [_]) ; no resources to clean up

;; implement boolean requiresLayout()
(defn -requiresLayout [_] false) ; we handle all formatting

(defn -main [& args]
(println "foo"))

