#!/usr/bin/env boot

#tailrecursion.boot.core/version "{{boot-core-v}}"

(set-env!
  :project      '{{raw-name}}
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "{{boot-task-v}}"]
                  [tailrecursion/hoplon      "{{hoplon-v}}"]]
  :out-path     "resources/public"
  :src-paths    #{"src"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require
  '[tailrecursion.hoplon.boot    :refer :all]
  '[tailrecursion.boot.task.ring :refer [dev-server]])

(deftask development
  "Build {{raw-name}} for development."
  []
  (comp (watch) (hoplon {:pretty-print true :prerender false}) (dev-server)))

(deftask dev-debug
  "Build {{raw-name}} for development with source maps."
  []
  (comp (watch) (hoplon {:pretty-print true
                         :prerender false
                         :source-map true}) (dev-server)))

(deftask production
  "Build {{raw-name}} for production."
  []
  (hoplon {:optimizations :advanced}))
