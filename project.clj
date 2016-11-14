(defproject new-pet-clj "0.1.0-SNAPSHOT"
            :profiles {:dev {:env {:dev true}
                             :dependencies [[binaryage/devtools "0.8.3"]]
                             :plugins [[lein-figwheel "0.5.7"]]}}
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [org.clojure/clojurescript "1.9.293"]
                           [reagent "0.6.0"]
                           [re-frame "0.8.0"]
                           [secretary "1.2.3"]
                           [compojure "1.5.1"]
                           [yogthos/config "0.8"]
                           [ring "1.5.0"]
                           [environ "1.1.0"]]
            :plugins [[lein-cljsbuild "1.1.4"]]
            :min-lein-version "2.5.3"
            :source-paths ["src/clj"]
            :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
            :figwheel {:css-dirs ["resources/public/css"]
                       :ring-handler new-pet-clj.handler/dev-handler}
            :cljsbuild {:builds [{:id "dev"
                                  :source-paths ["src/cljs"]
                                  :figwheel     {:on-jsload "new-pet-clj.core/mount-root"}
                                  :compiler     {:main new-pet-clj.core
                                                 :output-to "resources/public/js/compiled/app.js"
                                                 :output-dir "resources/public/js/compiled/out"
                                                 :asset-path "js/compiled/out"
                                                 :source-map-timestamp true
                                                 :preloads [devtools.preload]
                                                 :external-config {:devtools/config {:features-to-install :all}}}}
                                 {:id "min"
                                  :source-paths ["src/cljs"]
                                  :jar true
                                  :compiler {:main new-pet-clj.core
                                             :output-to "resources/public/js/compiled/app.js"
                                             :optimizations :advanced
                                             :closure-defines {goog.DEBUG false}
                                             :pretty-print false}}]}
            :main new-pet-clj.server
            :aot [new-pet-clj.server]
            :uberjar-name "new-pet-clj.jar"
            :prep-tasks [["cljsbuild" "once" "min"] "compile"])
