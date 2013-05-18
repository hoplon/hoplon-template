(ns leiningen.new.hoplon
  (:require
    [clojure.string           :as string]
    [clojure.java.io          :as io]
    [leiningen.new.templates  :as t]))

(defn hoplon
  "Create new Hoplon project."
  [name]
  (let [render  (t/renderer "hoplon")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data    {:raw-name    name
                 :name        (t/project-name name)
                 :namespace   (t/multi-segment (t/sanitize-ns name))
                 :nested-dirs (t/name-to-path main-ns)
                 :year        (t/year)}]
    (t/->files data
               ["README.md"           (render "README.md"   data)]
               ["project.clj"         (render "project.clj" data)]
               ["src/html/index.html" (render "index.html"  data)])))
