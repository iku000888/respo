
(ns respo.app.comp.wrap
  (:require-macros [respo.macros :refer [defcomp div]])
  (:require [respo.core :refer [create-comp]]))

(defcomp comp-wrap (x) (div {} x))
