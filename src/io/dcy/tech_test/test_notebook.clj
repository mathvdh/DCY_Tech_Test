(ns io.dcy.tech-test.test-notebook
  (:require
    [notespace.api :as notespace]
    [notespace.kinds :as kind]))

["# DCY Technical Test"
 "This is a notespace 'notebook'"

 "Notespace is a clojure library that allows you to convert any clojure namespace into a 'Jupyter-style' notebook."

 "Start a REPL and switch to this this namespace and evaluate it."]

^kind/hidden
(comment

  ;eval this line to launch the server and open a browser
  (notespace/init-with-browser)
  (notespace/init :port 1900)

  ;eval this line to refresh the browser's content from this file
  (notespace/eval-and-realize-this-notespace)
  (notespace/eval-this-notespace)


  ;eval this line to stop the server
  (notespace/stop-server)


  (notespace/listen)

  (notespace/unlisten)

  (notespace/toggle-single-note-mode true)
  (notespace/toggle-single-note-mode false))


["## Tests"]

["### clojure.test"]

(require '[clojure.test :refer [deftest testing is are]])


["### test 1"
 "This first tests require you to know how to count"
 "Re-implement the core 'count' function"
 "Do not use java interop functions"]

(defn my-count [coll]
  (if (empty? coll)
    0
    (inc (my-count (rest coll)))))

(deftest test-count
  (testing "my-count should be the same as count"
    (let [my-collection [1 2 3 4 5]]
      (is (= (my-count my-collection)
             (count my-collection))))))

(deftest t2
  (testing "4 is 4 ?"
    (is (= 3 3))))

(deftest t3
  (testing "5 is 5 ?"
    (is (= 5 5))))

["We can ask for the summary of all clojure.test tests:"]

(notespace/clojure-tests-summary)

