(defproject io.dcy.tech-test "0.1.0-SNAPSHOT"
  :description "DCY Technical Test Project"
  :url "https://www.dcy.io"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [scicloj/notespace "3-beta9"]]

  :main ^:skip-aot io.dcy.tech-test.test-notebook
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
