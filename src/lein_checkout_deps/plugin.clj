(ns lein-checkout-deps.plugin
	(:require
		[robert.hooke :only [add-hook]]
		[leiningen.deps :only [deps]]
		[leiningen.core.project :as project :only [read]])
	(:use
		[clojure.java.io :only [file]]
		[leiningen.install :only [install]]))

(defn deps-hook [f project & args]
	(doseq [dep (.listFiles (file (:root project) "checkouts"))]
		(let [filename (.getAbsolutePath (file dep "project.clj"))
			   p (project/read filename)]
			(println "Reading project file" filename)
			(when p
				(install p))))
	(apply f project args))

(defn hooks []
	(robert.hooke/add-hook #'leiningen.deps/deps deps-hook))