(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description  "FIXME: add description"
  :url          "http://example.com/FIXME"
  :license      {:name  "Eclipse Public License"
                 :url   "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins      [[tailrecursion/hoplon "0.1.0-SNAPSHOT"]]
  :dependencies [[tailrecursion/hoplon "0.1.0-SNAPSHOT"]]
  :source-paths ["src/clj"]
  :hoplon       {:html-src      "src/html"
                 :cljs-src      "src/cljs"
                 :html-out      "resources/public"
                 :pretty-print  false
                 :cljsc-opts    {:warnings      true
                                 :pretty-print  false
                                 :optimizations :whitespace}})
