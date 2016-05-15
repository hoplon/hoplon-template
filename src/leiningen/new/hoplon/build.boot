(set-env!
  :dependencies '[[adzerk/boot-cljs          "{{boot-cljs-v}}"]
                  [adzerk/boot-reload        "{{boot-reload-v}}"]
                  [hoplon/boot-hoplon        "{{boot-hoplon-v}}"]
                  [hoplon/hoplon             "{{hoplon-v}}"]
                  [org.clojure/clojure       "{{clojure-v}}"]
                  [org.clojure/clojurescript "{{clojurescript-v}}"]
                  [tailrecursion/boot-jetty  "{{boot-jetty-v}}"]]
  :source-paths #{"src"}
  :asset-paths  #{"assets"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]]
  '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev
  "Build {{raw-name}} for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve :port 8000)))

(deftask prod
  "Build {{raw-name}} for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (target :dir #{"target"})))
