(ns org.rathore.amit.babble.feature)

(defn specs-for [attrib-name specs]
  (let [type-spec? #(= attrib-name (first %))
	extractor (comp next first)]
    (extractor (filter type-spec? specs))))