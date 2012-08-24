(ns eagents.core)

(defn query-and-alter [a query-fn alter-fn]
  (let [p (promise)
        f (fn [x]
            (deliver p (query-fn x))
            (alter-fn x))]
    (send a f)
    @p))

    