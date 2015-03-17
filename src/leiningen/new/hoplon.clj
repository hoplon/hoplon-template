(ns leiningen.new.hoplon
  (:require [leiningen.new.templates :as t]
            [ancient-clj.core        :refer [latest-version-string!]]))

(def deps
  '[tailrecursion/boot.core
    tailrecursion/boot.task
    tailrecursion/hoplon])

(defn latest-deps-strs [deps]
  (mapv #(latest-version-string! % {:snapshots? false}) deps))

(defn hoplon
  "Create new Hoplon project."
  [name]
  (let [[boot-core-v boot-task-v hoplon-v] (->> deps latest-deps-strs)
        render  (t/renderer "hoplon")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data    {:raw-name    name
                 :boot-core-v boot-core-v
                 :boot-task-v boot-task-v
                 :hoplon-v    hoplon-v
                 :dependencies (latest-deps-strs deps)
                 :require-tasks '#{[tailrecursion.boot.task :refer :all]
                                   [tailrecursion.hoplon.boot :refer :all]}
                 :name        (t/project-name name)
                 :year        (t/year)}]
    (t/->files data
               ["README.md"           (render "README.md"      data)]
               ["build.boot"          (render "build.boot"     data)]
               ["src/index.cljs.hl"   (render "index.cljs.hl"  data)]
               ["src/main.inc.css"    (render "main.inc.css"   data)]
               [".gitignore"          (render "gitignore"      data)])))
