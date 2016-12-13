(ns new-pet-clj.kits.core)

(def small-dog-contents [{:name "Blueberry Pet™ Dog Collar" :code "B017UAIYW8"}
                         {:name "Blueberry Pet™ Dog Leash" :code "B01LWYVC7L"}
                         {:name "Furhaven™ Deluxe Dog Bed" :code "B00VXA5A8S"}
                         {:name "Xentyx™ Pet Toys - 4 Pack" :code "B01E9TJMAQ"}
                         {:name "Ranch Rewards™ Natural Rawhide Bone" :code "B000HHQ4UQ"}
                         {:name "Iconic™ 8oz Dog Bowl - 2 Pack" :code "B00WHISO4W"}
                         {:name "mDesign™ Silicon Feeding Mat" :code "B01EB6CRHW"}
                         {:name "Pedigree™ Steak Flavored Dry Dog Food - 1 Months Supply" :code "B016ZPBD04"}])
(def small-dog-kit {:name "Small Dog" :contents small-dog-contents})

(def medium-dog-contents [{:name "Blueberry Pet™ Dog Collar" :code "B017UAJ0WG"}
                          {:name "Blueberry Pet™ Dog Leash" :code "B01LWYVC7L"}
                          {:name "Furhaven™ Deluxe Dog Bed" :code "B00QKSSGH0"}
                          {:name "Xentyx™ Pet Toys - 4 Pack" :code "B01E9TJMAQ"}
                          {:name "Ranch Rewards™ Natural Rawhide Bone" :code "B000HHO69W"}
                          {:name "Iconic™ 16oz Dog Bowl - 2 Pack" :code "B00WHIUKX0"}
                          {:name "mDesign™ Silicon Feeding Mat" :code "B01F2KK1QA"}
                          {:name "Pedigree™ Chicken Flavored Dry Dog Food - 1 Months Supply" :code "B00JN9IJAW"}])
(def medium-dog-kit {:name "Medium Dog" :contents medium-dog-contents})

(def large-dog-contents [{:name "Blueberry Pet™ Dog Collar" :code "B017UAJ3BE"}
                         {:name "Blueberry Pet™ Dog Leash" :code "B01LWYVC7L"}
                         {:name "Furhaven™ Deluxe Dog Bed" :code "B00VX9S87O"}
                         {:name "Xentyx™ Pet Toys - 4 Pack" :code "B01E9TJMAQ"}
                         {:name "Ranch Rewards™ Natural Rawhide Bone" :code "B000HHO69W"}
                         {:name "Iconic™ 32oz Dog Bowl - 2 Pack" :code "B00WHIX7WQ"}
                         {:name "mDesign™ Silicon Feeding Mat" :code "B01F2JL7BO"}
                         {:name "Pedigree™ Chicken Flavored Dry Dog Food - 1 Months Supply" :code "B00008GKAV"}])
(def large-dog-kit {:name "Large Dog" :contents large-dog-contents})

(def cat-contents [{:name "Aolove™ Classic Leather Cat Collar" :code "B01B9MR3CA"}
                   {:name "Petmate™ Cat Carrier" :code "B0062JFGM0"}
                   {:name "Hartz™ Midnight Crazies™ Cat Toy" :code "B000BO96K0"}
                   {:name "Penn Plax™ Purr-Pet™ Furry Mice Toys" :code "B00304T1BM"}
                   {:name "Iconic™ 8oz Cat Bowl - 2 Pack" :code "B00WHISO4W"}
                   {:name "mDesign™ Silicon Feeding Mat" :code "B01EB6CRHW"}
                   {:name "Petmate™ Litter Pan" :code "B00074VWJM"}
                   {:name "Duranimals™ Cat Litter Scoop" :code "B001DCAAP4"}
                   {:name "Arm & Hammer™ Double Duty Clumping Cat Litter™" :code "B004U8Z436"}
                   {:name "Meow Mix™ Original Choice™ Cat Food - 1 Months Supply" :code "B000R4CJQ2"}])
(def cat-kit {:name "Cat" :contents cat-contents})

(def puppy-contents (conj small-dog-contents {:name "Four Paws™ Wee Wee™ Pads" :code"B0002DJT9S"}))
(def puppy-kit {:name "Puppy" :contents puppy-contents})

(def kitten-contents cat-contents)
(def kitten-kit {:name "Kitten" :contents kitten-contents})