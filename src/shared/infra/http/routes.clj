(ns shared.infra.http.routes
  (:require [reitit.ring :as ring]))

(def demo-handler [req]
  {:body "success"})

(def routes
  (ring/ring-handler
   (ring/router
    [["/api" {:get {:handler demo-handler}}]])))