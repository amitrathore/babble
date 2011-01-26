(ns org.rathore.amit.babble.feature)

(defn specs-for [attrib-name specs]
  (let [type-spec? (fn [spec] 
                     (when (sequential? spec)
                       (= attrib-name (first spec))))
	extractor (comp next first)]
    (extractor (filter type-spec? specs))))

(defn config-from [specs & attribs]
  (let [config-kv (fn [attrib]
                    {(keyword attrib) (first (specs-for attrib specs))})]
    (apply merge (map config-kv attribs))))

(defmacro nested-config-from [spec-key specs & attribs]
  `(config-from (specs-for ~spec-key ~specs) ~@attribs))