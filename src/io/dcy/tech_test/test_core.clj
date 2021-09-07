(ns io.dcy.tech-test.test-core
  (:require
    [clojure.test :refer [deftest testing is are run-tests]]
    [clojure.spec.alpha :as s]
    [clojure.string :as string]
    [clojure.data.json :as json]))

; DCY Technical Test

; Read the comments below, and implement the code necessary to pass all the tests !

(comment
  ;you can eval the next line to run the tests in the REPL.
  (run-tests))

; test 1
; This first tests require you to know how to count
; Re-implement the core 'count' function
; Do not use java interop functions

(defn my-count [coll])
  ; implement the body of this function for the next test to pass


(deftest test-1
  (testing "my-count should be the same as count"
    (let [empty-coll []
          my-collection [1 2 3 4 5]]
      (is (= (my-count empty-coll)
             (count empty-coll)))
      (is (= (my-count my-collection)
             (count my-collection))))))



; test 2
; add a "display-name" field to all the items in the collection
; this field must be like "first-name last-name (age)".
; see examples in test-2's final-collection.

(defn add-display-name [coll])
  ; implement the body of this function for the next test to pass


(deftest test-2
  (testing "Collection modifications should be OK"
    (let [initial-collection [{:first-name "John" :last-name "Smith" :age 49}
                              {:first-name "Jean" :last-name "Dupont" :age 30}
                              {:first-name "Robert" :last-name "Lamoureux" :age 40}]
          final-collection [{:first-name "John" :last-name "Smith" :age 49 :display-name "John Smith (49)"}
                            {:first-name "Jean" :last-name "Dupont" :age 30 :display-name "Jean Dupont (30)"}
                            {:first-name "Robert" :last-name "Lamoureux" :age 40 :display-name "Robert Lamoureux (40)"}]]
      (is (not= initial-collection final-collection))
      (is (= final-collection (add-display-name initial-collection))))))

; test 3
; webservice parsing
; we need you to get the data returned by the specified url and return a collection of maps that satisfies the specs below.
; the clojure data.json library is available for parsing and required at the top if this NS.

(s/def :crypto/id int?)
(s/def :crypto/name string?)
(s/def :crypto/symbol (s/and string? #(not (nil? (re-matches #"[A-Z0-9]+" %)))))
(s/def :crypto/slug (s/and string? #(not (nil? (re-matches #"[a-z0-9\-]+" %)))))
(s/def :crypto/rank (s/and int? #(<= 1 % 100)))

(s/def :crypto/map (s/keys :req-un [:crypto/id
                                    :crypto/name
                                    :crypto/symbol
                                    :crypto/slug
                                    :crypto/rank]))

(s/def :crypto/seq (s/coll-of :crypto/map :min-count 3))


(defn get-cryptos-top-100 [url])
  ; implement the body of this function for the next test to pass

(deftest test-3
  (testing "Getting and parsing a crypto API"
    (let [api-url "https://api.coinmarketcap.com/data-api/v3/map/all?cryptoAux=is_active,status&listing_status=active,untracked"
          api-data (get-cryptos-top-100 api-url)]
      (when (not (s/valid? :crypto/seq api-data))
        (s/explain :crypto/seq api-data))
      (is (s/valid? :crypto/seq api-data))
      (is (= 100 (count api-data))))))


(comment
  ;you can eval the next line to run the tests in the REPL.
  (run-tests))