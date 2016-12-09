(ns new-pet-clj.db)

(def default-db
  {:active-panel :home-panel
   :cart nil
   :cart-status :inactive
   :selected-kit nil
   ;; TODO: Make this stuff not nonsense
   :kits         '({:name "Small Dog" :contents [{:name "Spooge" :code "B00QKSSGH0"}
                                                 {:name "Boobs" :code "B0155XV9KG"}]}
                   {:name "Medium Dog" :contents [{:name "Big Ol Basket" :code "B00QKSSGH0"}
                                                  {:name "Bone" :code "B0155XV9KG"}]}
                   {:name "Large Dog" :contents [{:name "Life-saving Whiskey" :code "B00QKSSGH0"}
                                                 {:name "Cuddles" :code "B0155XV9KG"}]}
                   {:name "Cat" :contents [{:name "Evil" :code "B00QKSSGH0"}
                                           {:name "Cheese Weasel" :code "B0155XV9KG"}]})})
