(ns new-pet-clj.db)

(def default-db
  {:active-panel :home-panel
   :cart nil
   :cart-status :inactive
   :selected-kit nil
   :kits         '({:name "Small Dog" :contents [{:name "Blueberry Pet Collar" :code "B017UAIYW8"}
                                                 {:name "Blueberry Pet Leash" :code "B01LWYVC7L"}
                                                 {:name "American Kennel Club Bed" :code "B00FWQALD8"}
                                                 {:name "Xentyx Pet Toys - 4 Pack" :code "B01E9TJMAQ"}
                                                 {:name "Ranch Rewards Natural Rawhide Bone" :code "B000HHQ4UQ"}
                                                 {:name "Bergan Heavy Duty Dog Bowl - 2 Pack" :code "B01FKLLGS8"}
                                                 {:name "mDesign Silicon Feeding Mat" :code "B01EB6CRHW"}
                                                 {:name "Pedigree Steak Flavor Dry Dog Food - 1 Months Supply" :code "B016ZPB7QE"}]}
                   {:name "Medium Dog" :contents [{:name "Big Ol Basket" :code "B00QKSSGH0"}
                                                  {:name "Bone" :code "B0155XV9KG"}]}
                   {:name "Large Dog" :contents [{:name "Life-saving Whiskey" :code "B00QKSSGH0"}
                                                 {:name "Cuddles" :code "B0155XV9KG"}]}
                   {:name "Cat" :contents [{:name "Evil" :code "B00QKSSGH0"}
                                           {:name "Cheese Weasel" :code "B0155XV9KG"}]})})
