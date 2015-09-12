(ns leiningen.new.hoplon
  (:require [leiningen.new.templates :as t]
            [ancient-clj.core        :refer [latest-version-string!]]))

(def deps
  '[boot/core
    adzerk/boot-cljs
    adzerk/boot-reload
    org.clojure/clojurescript
    hoplon/boot-hoplon
    hoplon/hoplon
    tailrecursion/boot-jetty])

(defn latest-deps-strs [deps]
  (mapv #(latest-version-string! % {:snapshots? false}) deps))

(defn hoplon
  "Create new Hoplon project."
  [name]
  (let [[boot-core-v
         boot-cljs-v
         boot-reload-v
         clojurescript-v
         boot-hoplon-v
         hoplon-v
         boot-jetty-v] (latest-deps-strs deps)
        clojure-v "1.7.0"
        render  (t/renderer "hoplon")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data    {:raw-name        name
                 :boot-core-v     boot-core-v
                 :hoplon-v        hoplon-v
                 :boot-cljs-v     boot-cljs-v
                 :boot-reload-v   boot-reload-v
                 :clojure-v       clojure-v
                 :clojurescript-v clojurescript-v
                 :boot-hoplon-v   boot-hoplon-v
                 :boot-jetty-v    boot-jetty-v
                 :name            (t/project-name name)
                 :year            (t/year)}]
    (t/->files data
               ["README.md"         (render "README.md"       data)]
               ["build.boot"        (render "build.boot"      data)]
               ["boot.properties"   (render "boot.properties" data)]
               ["src/index.cljs.hl" (render "index.cljs.hl"   data)]
               ["src/main.inc.css"  (render "main.inc.css"    data)]
               [".gitignore"        (render "gitignore"       data)])))
