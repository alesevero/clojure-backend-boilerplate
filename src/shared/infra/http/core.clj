(ns shared.infra.http.core
  (:require [org.httpkit.server :refer [run-server]]
            [mount.core :as mount]
            ;; app routes
            [shared.infra.http.routes :refer [routes]]))

(defonce server (atom nil))

(defn stop-server []
  (println (mount/stop))
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)
    (println "server stoped!")))

(defn- start-server []
  (reset! server (run-server #'routes {:port 4000})))

(defn- start-mount []
  (println (mount/start)))

(defn -main []
  (start-mount)
  (start-server))

(defn restart-server []
  (stop-server)
  (-main))

;; testing only
(comment
  (-main)
  (stop-server)
  (restart-server))