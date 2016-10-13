
(ns respo.test-component.todolist
  (:require [respo.alias :refer [create-comp div]]
            [respo.test-component.task :refer [comp-task]]))

(def style-todolist {:color "blue", :font-family "\"微软雅黑\", Verdana"})

(defn render [tasks]
  (fn [state mutate]
    (div
      {:style style-todolist}
      (->> tasks (map (fn [task] [(:id task) (comp-task task)]))))))

(def comp-todolist (create-comp :todolist render))