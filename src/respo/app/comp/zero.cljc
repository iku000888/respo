
(ns respo.app.comp.zero
  (:require-macros [respo.macros :refer [defcomp div]])
  (:require [respo.core :refer [create-comp]]))

(defcomp comp-zero () (div {:inner-text 0}))
