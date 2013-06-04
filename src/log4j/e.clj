(ns log4j.e
  (:import [org.apache.log4j AppenderSkeleton])
  ;; specify the Java class name to generate and what it extends:
  (:gen-class :name h908714124.log4j.e.ElasticAppender
              :extends org.apache.log4j.AppenderSkeleton))

(def properties (atom {}))

(defn create-one []
  (let [properties (atom {})]
       (reify h908714124.log4j.e.ElasticAppender
         (append [_ event] 
           (format "host: %s port: %s message:%s%n" 
                   host port (.getMessage event)))
         (close [_] (println "close"))
         (setHost [_ host] (swap! properties assoc :host host))
         (getHost [_] (:host @atom))
         (setPort [_ port] (swap! properties assoc :port port))
         (getPort [_] (:port @atom))
         (setFormat [_ port] (swap! properties assoc :port port))
         (getFormat [_] (:format @atom))
         (Requireslayout [_] false))))

(defn setHost [_ host] (swap! properties assoc :host host))
(defn getHost [_] (:host @atom))
(defn setPort [_ port] (swap! properties assoc :port port))
(defn getPort [_] (:port @atom))
(defn setFormat [_ port] (swap! properties assoc :port port))
(defn getFormat [_] (:format @atom))

(def instance (create-one))

;; implement void append(LoggingEvent event):
(defn -append [_ event] ; first argument is 'this', ignored
  (println (.getMessage event))) ; just print the event message (to *out*)

;; implement void close()
(defn -close [_]) ; no resources to clean up

;; implement boolean requiresLayout()
(defn -requiresLayout [_] false) ; we handle all formatting

