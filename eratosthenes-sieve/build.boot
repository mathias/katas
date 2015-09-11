(set-env!
  :source-paths   #{"src"}
  :resource-paths #{"resources/public"}
  :dependencies '[[zilti/boot-midje "0.1.2" :scope "test"]
                  [midje "1.8-alpha1"]
                  [org.clojure/clojure "1.7.0"]])

(require
 '[zilti.boot-midje :refer [midje]])

(deftask autotest
  []
  (set-env! :source-paths #{"test" "src"})
  (comp (midje :autotest true
               :test-paths #{"test"}) (wait)))
