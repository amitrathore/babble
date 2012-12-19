(ns zolo.babble.feature)

(defn specs-for [attrib-name specs]
  (let [is-attrib? #(when (sequential? %)
                      (= attrib-name (first %)))]
    (->> specs
         (filter is-attrib?)
         last
         rest)))

(defn all-specs [specs & attribs]
  (let [config-kv (fn [attrib]
                    {(keyword attrib) (first (specs-for attrib specs))})]
    (apply merge (map config-kv attribs))))

(defmacro nested-config-from [spec-key specs & attribs]
  `(config-from (specs-for ~spec-key ~specs) ~@attribs))