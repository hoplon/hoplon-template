(ns leiningen.new.hoplon
  (:require
    [clojure.string           :as string]
    [clojure.java.io          :as io]
    [leiningen.new.templates  :as t]
    [ancient-clj.core         :refer [latest-version-string!]]))

(def deps
  '[tailrecursion/boot.core
    tailrecursion/boot.task
    tailrecursion/hoplon
    org.clojure/clojurescript])

(defn latest-deps-strs [deps]
  (mapv latest-version-string! deps))

(defn hoplon
  "Create new Hoplon project."
  [name]
  (let [[boot-core-v boot-task-v
         hoplon-v clojurescript-v] (->> deps
                                        latest-deps-strs
                                        (mapv pr-str))
        render  (t/renderer "hoplon")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data    {:raw-name    name
                 :boot-core-v boot-core-v
                 :boot-task-v boot-task-v
                 :hoplon-v    hoplon-v
                 :clojurescript-v clojurescript-v
                 :dependencies (latest-deps-strs deps)
                 :require-tasks '#{[tailrecursion.boot.task :refer :all]
                                   [tailrecursion.hoplon.boot :refer :all]}
                 :name        (t/project-name name)
                 :year        (t/year)}]
    (t/->files data
               ["README.md"           (render "README.md"      data)]
               ["boot.edn"            (render "boot.edn"       data)]
               ["src/index.cljs.hl"   (render "index.cljs.hl"  data)])))
