(ns leiningen.new.hoplon
  (:require
    [leiningen.new.templates :as t]))

(defn hoplon
  "Create new Hoplon project."
  [name]
  (let [boot-cljs-v "1.7.228-2"
        boot-core-v "2.7.1"
        boot-jetty-v "0.1.3"
        boot-reload-v "0.4.13"
        clojure-v "1.8.0"
        clojurescript-v "1.9.293"
        hoplon-v "6.0.0-alpha17"
        render  (t/renderer "hoplon")
        data    {:raw-name         name
                 :boot-cljs-v      boot-cljs-v
                 :boot-core-v      boot-core-v
                 :boot-jetty-v     boot-jetty-v
                 :boot-reload-v    boot-reload-v
                 :clojure-v        clojure-v
                 :clojurescript-v  clojurescript-v
                 :hoplon-v         hoplon-v
                 :name             (t/project-name name)
                 :year             (t/year)}]
    (t/->files data
               ["README.md"         (render "README.md"       data)]
               ["build.boot"        (render "build.boot"      data)]
               ["boot.properties"   (render "boot.properties" data)]
               ["src/index.cljs.hl" (render "index.cljs.hl"   data)]
               ["assets/app.css"    (render "app.css"         data)]
               [".gitignore"        (render "gitignore"       data)])))
