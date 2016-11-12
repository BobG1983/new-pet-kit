(ns new-pet-clj.db)

(def default-db
  {:selected-kit nil
   :kits '({:name "Small Dog" :kit [{:name "Spooge" :code 123456}
                                    {:name "Boobs" :code 456123}]}
           {:name "Medium Dog" :kit [{:name "Big Ol Basket" :code 897}
                                     {:name "Bone" :code 123123}]}
           {:name "Large Dog" :kit [{:name "Life-saving Whiskey" :code 1}
                                    {:name "Cuddles" :code 2}]}
           {:name "Cat" :kit [{:name "Evil" :code 394123455545}
                              {:name "Cheese Weasel" :code 12334}]})})
