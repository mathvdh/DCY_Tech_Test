(defproject io.dcy.tech-test "0.1.0-SNAPSHOT"
  :description "DCY Technical Test Project"
  :url "https://www.dcy.io"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/spec.alpha "0.2.194"]
                 [org.clojure/data.json "2.4.0"]]

  :main ^:skip-aot io.dcy.tech-test.test-core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
