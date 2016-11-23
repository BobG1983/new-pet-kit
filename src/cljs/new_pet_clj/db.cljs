(ns new-pet-clj.db)

(def default-db
  {:selected-kit nil
   :kits         '({:name "Small Dog" :kit-contents [{:name "Spooge" :code "B00QKSSGH0"}
                                                     {:name "Boobs" :code "B0155XV9KG"}]}
                   {:name "Medium Dog" :kit-contents [{:name "Big Ol Basket" :code "B00QKSSGH0"}
                                                      {:name "Bone" :code "B0155XV9KG"}]}
                   {:name "Large Dog" :kit-contents [{:name "Life-saving Whiskey" :code "B00QKSSGH0"}
                                                     {:name "Cuddles" :code "B0155XV9KG"}]}
                   {:name "Cat" :kit-contents [{:name "Evil" :code "B00QKSSGH0"}
                                               {:name "Cheese Weasel" :code "B0155XV9KG"}]})})
