(defproject hoplon/lein-template "3.1.0"
  :description        "Create new Hoplon projects with style and grace."
  :url                "http://github.com/tailrecursion/hoplon-template/"
  :license            {:name  "Eclipse Public License"
                       :url   "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[ancient-clj "0.3.11" :exclusions [com.amazonaws/aws-java-sdk-s3]]
                 [com.amazonaws/aws-java-sdk-s3 "1.9.0" :exclusions [joda-time]]]
  :eval-in-leiningen true)
