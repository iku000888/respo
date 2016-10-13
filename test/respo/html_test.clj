
(ns respo.html-test
  (:require [clojure.test :refer :all]
            [respo.alias :refer [html
                                 head
                                 title
                                 script
                                 style
                                 meta'
                                 div
                                 link
                                 body]]
            [respo.test-component.todolist :refer [comp-todolist]]
            [respo.render.html :refer [make-string make-html]]))

(def todolist-store
 (atom [{:id 101, :text "101"} {:id 102, :text "102"}]))

(defn use-text [x] {:attrs {:innerHTML x}})

(deftest
  html-test
  (let [todo-demo (comp-todolist @todolist-store)]
    (testing
      "test generated HTML"
      (is (= (slurp "examples/demo.html") (make-string todo-demo))))))

(deftest
  simple-html-test
  (let [tree-demo (html
                    {}
                    (head
                      {}
                      (title (use-text "Demo"))
                      (link {:attrs {:rel "icon", :type "image/png"}})
                      (script (use-text "{}")))
                    (body {} (div {:attrs {:id "app"}} (div {}))))]
    (testing
      "test generated HTML"
      (is (= (slurp "examples/simple.html") (make-html tree-demo))))))