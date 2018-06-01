(ns intro-to-prejenter.elements
  (:require [prejenter.core :as p]))

(def t
  (p/create-element
   (fn [attrs & lines]
     [:slide
      [:block (merge {:height 840
                      :text-align :center
                      :vertical-align :middle
                      :font-size 70
                      :font-weight :bold}
                     attrs)
       lines]])))

(def title
  (p/create-element
   (fn [attrs t]
     (let [attrs (merge {:height 50
                         :font-size 60
                         :font-weight :bold
                         :text-align :center
                         :vertical-align :top
                         :padding-bottom 20}
                        attrs)]
       [:title attrs t]))))

(def body
  (p/create-element
   (fn [attrs & elems]
     [:block
      (merge {:height 670
              :vertical-align :middle}
             attrs)
      elems])))

(def items
  (p/create-element
   (fn [attrs & items]
     [:items attrs
      (map (fn [item]
             [:inline {:padding-top 15 :padding-bottom 15}
              item])
           items)])))

(def lines
  (p/create-element
   (fn [attrs & items]
     [:lines attrs
      (map (fn [line]
             [:inline {:padding-top 15 :padding-bottom 15}
              line])
           lines)])))

(def code
  (p/create-element
   (fn [attrs content]
     [:text (merge {:font-family "Osaka"} attrs)
      content])))
