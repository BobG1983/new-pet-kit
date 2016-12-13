(ns new-pet-clj.site.head
  (:require [new-pet-clj.site.scripts :as scr]
            [new-pet-clj.site.stylesheets :as sty]
            [new-pet-clj.site.icons :as ico]))

; Title
(defn title [site descr]
  [:title (str site " - " descr)])

; Meta
(defn meta-content [description]
  (list [:meta {:charset "utf-8"}]
        [:meta {:content "IE=edge" :http-equiv "X-UA-Compatible"}]
        [:meta { :name "viewport" :content "width=device-width, initial-scale=1.0"}]
        [:meta {:name "description" :content description}]))

; Defines
(def description "Starter kits for Cats & Dogs")
(def long-description "Get everything you need for your new Cat or Dog in just two clicks.")
(def site "New Pet Kit")

(def apple-icon-sizes [57 60 72 76 114 120 144 152 180 192])
(def android-icon-sizes [36 48 72 96 144 192])
(def favicon-sizes [16 32 96])
(def msft-icon-sizes [144])

(def css-folder "css")
(def primary-sheet "bulma.css")
(def expanded-sheet "landing.css")
(def font-awesome-sheet "https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css")

(def preload-polyfill "!function(e){\"use strict\"\nvar t=function(t,n,o){function r(e){return u.body?e():void setTimeout(function(){r(e)})}function l(){c.addEventListener&&c.removeEventListener(\"load\",l),c.media=o||\"all\"}var a,d,i,s,u=e.document,c=u.createElement(\"link\")\nreturn n?a=n:(d=(u.body||u.getElementsByTagName(\"head\")[0]).childNodes,a=d[d.length-1]),i=u.styleSheets,c.rel=\"stylesheet\",c.href=t,c.media=\"only x\",r(function(){a.parentNode.insertBefore(c,n?a:a.nextSibling)}),s=function(e){for(var t=c.href,n=i.length;n--;)if(i[n].href===t)return e()\nsetTimeout(function(){s(e)})},c.addEventListener&&c.addEventListener(\"load\",l),c.onloadcssdefined=s,s(l),c}\n\"undefined\"!=typeof exports?exports.loadCSS=t:e.loadCSS=t}(\"undefined\"!=typeof global?global:this),function(e){var t,n\ne.loadCSS&&(t=loadCSS.relpreload={},t.support=function(){try{return e.document.createElement(\"link\").relList.supports(\"preload\")}catch(e){return!1}},t.poly=function(){var t,n,o\nfor(t=e.document.getElementsByTagName(\"link\"),n=0;n<t.length;n++)o=t[n],\"preload\"===o.rel&&\"style\"===o.getAttribute(\"as\")&&(e.loadCSS(o.href,o),o.rel=null)},t.support()||(t.poly(),n=e.setInterval(t.poly,300),e.addEventListener&&e.addEventListener(\"load\",function(){e.clearInterval(n)}),e.attachEvent&&e.attachEvent(\"onload\",function(){e.clearInterval(n)})))}(this)")
(def google-analytics "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');ga('create', 'UA-88907311-1', 'auto');ga('send', 'pageview');")

; Actual Head
(defn head []
  (list (title site description)
        (meta-content long-description)
        (scr/inline-script preload-polyfill)
        (scr/inline-script google-analytics)
        (ico/icons apple-icon-sizes android-icon-sizes msft-icon-sizes favicon-sizes)
        (sty/stylesheets css-folder primary-sheet expanded-sheet)
        (sty/stylesheet nil font-awesome-sheet)))


