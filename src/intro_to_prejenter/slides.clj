(ns intro-to-prejenter.slides
  (:require [clojure.java.io :as io]
            [intro-to-prejenter.elements :refer :all])
  (:import [java.awt Color]
           [javax.imageio ImageIO]))

(def context
  {:width 1120 :height 840
   :padding 40
   :padding-top 80
   :font-family "Tsukushi A Round Gothic"
   :font-size 40
   :color Color/BLACK
   :background-color Color/WHITE})

(def cover
  [:slide {:text-align :center
           :vertical-align :middle
           :font-size 60
           :padding 0}
   [:block
    {:top 100
     :background-color Color/GRAY}
    [:lines {:padding 75
             :color Color/WHITE
             :font-weight :bold}
     [:inline "あなたの " [:text {:color Color/YELLOW} "CIDER"] " を"]
     "プレゼンツールにする方法"]]
   [:lines {:bottom 50 :right 50
            :font-size 30
            :text-align :right}
    "Lisp meetup #64"
    "@athos0220"]])

(def cider-0_17_0
  [:slide
   [title "CIDER 0.17.0"]
   [body
    [items
     "今月始めに 0.17.0 がリリースされた"
     "目玉機能としてREPLでの画像表示機能を追加"
     "Imageや画像ファイルのFileがインラインに表示される"]]])

(def basic-inspiration
  [t
   "これを使ったらCIDERで"
   [:inline {:vertical-align :middle}
    "スライドができるんでは？"
    [:image
     {:src (ImageIO/read (io/resource "thinking.jpg"))
      :height 80}]]])

(def existing-projects
  (let [projects [["L5" "https://github.com/fukamachi/L5"]
                  ["plojector" "https://github.com/liquidz/plojuctor"]
                  ["cljs-present" "https://github.com/mneise/cljs-present"]]]
    [:slide
     [title "既存プロジェクト"]
     [body
      `[~items
        ~@(for [[name url] projects]
            [:inline
             (str name " ")
             [code {:font-size 35} (str "(" url ")")]])]]]))

(def what-matters
  [:slide
   [title "既存プロジェクトに対する不満点"]
   [body
    [items
     "どこにどう表示するかを変えられる柔軟性がない"
     "スライドを書くこと自体はあまり省力化できない"
     "全体的に古い"]]])

(def let's-do-it-yourself
  [t {:font-size 200}
   "作ってみた"])

(def prejenter
  [:slide
   [title "prejenter"]
   [body
    [items
     "Hiccup形式で書けるデータ指向のスライド記述DSL"
     "REPLから操作可能"
     [:inline
      "「どう表示するか」を "
      [:text {:font-weight :bold} "エージェント"]
      " として切替可能"]
     "PDF出力サポート"]]])

(def why-data-oriented?
  [:slide
   [title "なぜデータ指向？"]
   [body
    [items
     "繰り返し現れるパターンを関数で共通化できる"
     "プログラム的にスライドを作ることも可能に"
     "再帰的レイアウトのスライドや無限に長いスライド等々"]]])

(def what-is-recursive-layout?
  [:slide
   [title "再帰的なスライドの例"]])

(def recursion-example
  (let [logo (ImageIO/read (io/resource "clojure.png"))]
    (letfn [(rec [n x y size]
              (let [image [:image {:src logo :width size :height size
                                   :top y :left x}]]
                (if (= n 0)
                  [image]
                  (let [size' (/ size 2.0)]
                    (cons image
                          (concat (rec (dec n) (+ x size) y size')
                                  (rec (dec n) (+ x size) (+ y size') size')))))))]
      [:slide
       [title "再帰的なスライドの例"]
       [body {:padding-top 50}
        (rec 5 0 0 500)]])))

(def wrap-up
  [:slide
   [title "まとめ"]
   [body
    [items
     "CIDERをプレゼンツールにするライブラリを作った"
     "まだアライメント計算等がたぶんバグってる…"
     "ひとまず遊べるレベルにはなってきた"
     "Enjoy!"]]])

(def slides
  [cover
   cider-0_17_0
   basic-inspiration
   existing-projects
   what-matters
   let's-do-it-yourself
   prejenter
   why-data-oriented?
   what-is-recursive-layout?
   recursion-example
   wrap-up])
