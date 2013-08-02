goog.provide('jayq.core');
goog.require('cljs.core');
goog.require('jayq.util');
goog.require('jayq.util');
goog.require('clojure.string');
jayq.core.crate_meta = (function crate_meta(func){
return func.prototype._crateGroup;
});
jayq.core.__GT_selector = (function __GT_selector(sel){
if(cljs.core.string_QMARK_.call(null,sel))
{return sel;
} else
{if(cljs.core.fn_QMARK_.call(null,sel))
{return [cljs.core.str("[crateGroup="),cljs.core.str(jayq.core.crate_meta.call(null,sel)),cljs.core.str("]")].join('');
} else
{if(cljs.core.keyword_QMARK_.call(null,sel))
{return cljs.core.name.call(null,sel);
} else
{if("\uFDD0:else")
{return sel;
} else
{return null;
}
}
}
}
});
/**
* @param {...*} var_args
*/
jayq.core.$ = (function() { 
var $__delegate = function (sel,p__6950){
var vec__6952 = p__6950;
var context = cljs.core.nth.call(null,vec__6952,0,null);
if(cljs.core.not.call(null,context))
{return jQuery(jayq.core.__GT_selector.call(null,sel));
} else
{return jQuery(jayq.core.__GT_selector.call(null,sel),context);
}
};
var $ = function (sel,var_args){
var p__6950 = null;
if (arguments.length > 1) {
  p__6950 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return $__delegate.call(this, sel, p__6950);
};
$.cljs$lang$maxFixedArity = 1;
$.cljs$lang$applyTo = (function (arglist__6953){
var sel = cljs.core.first(arglist__6953);
var p__6950 = cljs.core.rest(arglist__6953);
return $__delegate(sel, p__6950);
});
$.cljs$core$IFn$_invoke$arity$variadic = $__delegate;
return $;
})()
;
jQuery.prototype.cljs$core$IReduce$ = true;
jQuery.prototype.cljs$core$IReduce$_reduce$arity$2 = (function (this$,f){
return cljs.core.ci_reduce.call(null,jayq.core.coll,f,cljs.core.first.call(null,this$),cljs.core.count.call(null,this$));
});
jQuery.prototype.cljs$core$IReduce$_reduce$arity$3 = (function (this$,f,start){
return cljs.core.ci_reduce.call(null,jayq.core.coll,f,start,jayq.core.i);
});
jQuery.prototype.cljs$core$ILookup$ = true;
jQuery.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this$,k){
var or__3943__auto__ = this$.slice(k,(k + 1));
if(cljs.core.truth_(or__3943__auto__))
{return or__3943__auto__;
} else
{return null;
}
});
jQuery.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this$,k,not_found){
return cljs.core._nth.call(null,this$,k,not_found);
});
jQuery.prototype.cljs$core$ISequential$ = true;
jQuery.prototype.cljs$core$IIndexed$ = true;
jQuery.prototype.cljs$core$IIndexed$_nth$arity$2 = (function (this$,n){
if((n < cljs.core.count.call(null,this$)))
{return this$.slice(n,(n + 1));
} else
{return null;
}
});
jQuery.prototype.cljs$core$IIndexed$_nth$arity$3 = (function (this$,n,not_found){
if((n < cljs.core.count.call(null,this$)))
{return this$.slice(n,(n + 1));
} else
{if((void 0 === not_found))
{return null;
} else
{return not_found;
}
}
});
jQuery.prototype.cljs$core$ICounted$ = true;
jQuery.prototype.cljs$core$ICounted$_count$arity$1 = (function (this$){
return this$.size();
});
jQuery.prototype.cljs$core$ISeq$ = true;
jQuery.prototype.cljs$core$ISeq$_first$arity$1 = (function (this$){
return this$.slice(0,1);
});
jQuery.prototype.cljs$core$ISeq$_rest$arity$1 = (function (this$){
if((cljs.core.count.call(null,this$) > 1))
{return this$.slice(1);
} else
{return cljs.core.list.call(null);
}
});
jQuery.prototype.cljs$core$ISeqable$ = true;
jQuery.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this$){
if(cljs.core.truth_(this$.get(0)))
{return this$;
} else
{return null;
}
});
jQuery.prototype.call = (function() {
var G__6954 = null;
var G__6954__2 = (function (_,k){
return cljs.core._lookup.call(null,this,k);
});
var G__6954__3 = (function (_,k,not_found){
return cljs.core._lookup.call(null,this,k,not_found);
});
G__6954 = function(_,k,not_found){
switch(arguments.length){
case 2:
return G__6954__2.call(this,_,k);
case 3:
return G__6954__3.call(this,_,k,not_found);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
return G__6954;
})()
;
jayq.core.anim = (function anim(elem,props,dur){
return elem.animate(jayq.util.map__GT_js.call(null,props),dur);
});
jayq.core.text = (function text($elem,txt){
return $elem.text(txt);
});
jayq.core.css = (function css($elem,opts){
if(cljs.core.keyword_QMARK_.call(null,opts))
{return $elem.css(cljs.core.name.call(null,opts));
} else
{return $elem.css(jayq.util.map__GT_js.call(null,opts));
}
});
/**
* @param {...*} var_args
*/
jayq.core.attr = (function() { 
var attr__delegate = function ($elem,a,p__6955){
var vec__6957 = p__6955;
var v = cljs.core.nth.call(null,vec__6957,0,null);
var a__$1 = cljs.core.name.call(null,a);
if(cljs.core.not.call(null,v))
{return $elem.attr(a__$1);
} else
{return $elem.attr(a__$1,v);
}
};
var attr = function ($elem,a,var_args){
var p__6955 = null;
if (arguments.length > 2) {
  p__6955 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 2),0);
} 
return attr__delegate.call(this, $elem, a, p__6955);
};
attr.cljs$lang$maxFixedArity = 2;
attr.cljs$lang$applyTo = (function (arglist__6958){
var $elem = cljs.core.first(arglist__6958);
arglist__6958 = cljs.core.next(arglist__6958);
var a = cljs.core.first(arglist__6958);
var p__6955 = cljs.core.rest(arglist__6958);
return attr__delegate($elem, a, p__6955);
});
attr.cljs$core$IFn$_invoke$arity$variadic = attr__delegate;
return attr;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.data = (function() { 
var data__delegate = function ($elem,k,p__6959){
var vec__6961 = p__6959;
var v = cljs.core.nth.call(null,vec__6961,0,null);
var k__$1 = cljs.core.name.call(null,k);
if(cljs.core.not.call(null,v))
{return $elem.data(k__$1);
} else
{return $elem.data(k__$1,v);
}
};
var data = function ($elem,k,var_args){
var p__6959 = null;
if (arguments.length > 2) {
  p__6959 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 2),0);
} 
return data__delegate.call(this, $elem, k, p__6959);
};
data.cljs$lang$maxFixedArity = 2;
data.cljs$lang$applyTo = (function (arglist__6962){
var $elem = cljs.core.first(arglist__6962);
arglist__6962 = cljs.core.next(arglist__6962);
var k = cljs.core.first(arglist__6962);
var p__6959 = cljs.core.rest(arglist__6962);
return data__delegate($elem, k, p__6959);
});
data.cljs$core$IFn$_invoke$arity$variadic = data__delegate;
return data;
})()
;
jayq.core.add_class = (function add_class($elem,cl){
var cl__$1 = cljs.core.name.call(null,cl);
return $elem.addClass(cl__$1);
});
jayq.core.remove_class = (function remove_class($elem,cl){
var cl__$1 = cljs.core.name.call(null,cl);
return $elem.removeClass(cl__$1);
});
jayq.core.append = (function append($elem,content){
return $elem.append(content);
});
jayq.core.prepend = (function prepend($elem,content){
return $elem.prepend(content);
});
jayq.core.remove = (function remove($elem){
return $elem.remove();
});
/**
* @param {...*} var_args
*/
jayq.core.hide = (function() { 
var hide__delegate = function ($elem,p__6963){
var vec__6965 = p__6963;
var speed = cljs.core.nth.call(null,vec__6965,0,null);
var on_finish = cljs.core.nth.call(null,vec__6965,1,null);
return $elem.hide(speed,on_finish);
};
var hide = function ($elem,var_args){
var p__6963 = null;
if (arguments.length > 1) {
  p__6963 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return hide__delegate.call(this, $elem, p__6963);
};
hide.cljs$lang$maxFixedArity = 1;
hide.cljs$lang$applyTo = (function (arglist__6966){
var $elem = cljs.core.first(arglist__6966);
var p__6963 = cljs.core.rest(arglist__6966);
return hide__delegate($elem, p__6963);
});
hide.cljs$core$IFn$_invoke$arity$variadic = hide__delegate;
return hide;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.show = (function() { 
var show__delegate = function ($elem,p__6967){
var vec__6969 = p__6967;
var speed = cljs.core.nth.call(null,vec__6969,0,null);
var on_finish = cljs.core.nth.call(null,vec__6969,1,null);
return $elem.show(speed,on_finish);
};
var show = function ($elem,var_args){
var p__6967 = null;
if (arguments.length > 1) {
  p__6967 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return show__delegate.call(this, $elem, p__6967);
};
show.cljs$lang$maxFixedArity = 1;
show.cljs$lang$applyTo = (function (arglist__6970){
var $elem = cljs.core.first(arglist__6970);
var p__6967 = cljs.core.rest(arglist__6970);
return show__delegate($elem, p__6967);
});
show.cljs$core$IFn$_invoke$arity$variadic = show__delegate;
return show;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.fade_out = (function() { 
var fade_out__delegate = function ($elem,p__6971){
var vec__6973 = p__6971;
var speed = cljs.core.nth.call(null,vec__6973,0,null);
var on_finish = cljs.core.nth.call(null,vec__6973,1,null);
return $elem.fadeOut(speed,on_finish);
};
var fade_out = function ($elem,var_args){
var p__6971 = null;
if (arguments.length > 1) {
  p__6971 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return fade_out__delegate.call(this, $elem, p__6971);
};
fade_out.cljs$lang$maxFixedArity = 1;
fade_out.cljs$lang$applyTo = (function (arglist__6974){
var $elem = cljs.core.first(arglist__6974);
var p__6971 = cljs.core.rest(arglist__6974);
return fade_out__delegate($elem, p__6971);
});
fade_out.cljs$core$IFn$_invoke$arity$variadic = fade_out__delegate;
return fade_out;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.fade_in = (function() { 
var fade_in__delegate = function ($elem,p__6975){
var vec__6977 = p__6975;
var speed = cljs.core.nth.call(null,vec__6977,0,null);
var on_finish = cljs.core.nth.call(null,vec__6977,1,null);
return $elem.fadeIn(speed,on_finish);
};
var fade_in = function ($elem,var_args){
var p__6975 = null;
if (arguments.length > 1) {
  p__6975 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return fade_in__delegate.call(this, $elem, p__6975);
};
fade_in.cljs$lang$maxFixedArity = 1;
fade_in.cljs$lang$applyTo = (function (arglist__6978){
var $elem = cljs.core.first(arglist__6978);
var p__6975 = cljs.core.rest(arglist__6978);
return fade_in__delegate($elem, p__6975);
});
fade_in.cljs$core$IFn$_invoke$arity$variadic = fade_in__delegate;
return fade_in;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.slide_up = (function() { 
var slide_up__delegate = function ($elem,p__6979){
var vec__6981 = p__6979;
var speed = cljs.core.nth.call(null,vec__6981,0,null);
var on_finish = cljs.core.nth.call(null,vec__6981,1,null);
return $elem.slideUp(speed,on_finish);
};
var slide_up = function ($elem,var_args){
var p__6979 = null;
if (arguments.length > 1) {
  p__6979 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return slide_up__delegate.call(this, $elem, p__6979);
};
slide_up.cljs$lang$maxFixedArity = 1;
slide_up.cljs$lang$applyTo = (function (arglist__6982){
var $elem = cljs.core.first(arglist__6982);
var p__6979 = cljs.core.rest(arglist__6982);
return slide_up__delegate($elem, p__6979);
});
slide_up.cljs$core$IFn$_invoke$arity$variadic = slide_up__delegate;
return slide_up;
})()
;
/**
* @param {...*} var_args
*/
jayq.core.slide_down = (function() { 
var slide_down__delegate = function ($elem,p__6983){
var vec__6985 = p__6983;
var speed = cljs.core.nth.call(null,vec__6985,0,null);
var on_finish = cljs.core.nth.call(null,vec__6985,1,null);
return $elem.slideDown(speed,on_finish);
};
var slide_down = function ($elem,var_args){
var p__6983 = null;
if (arguments.length > 1) {
  p__6983 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return slide_down__delegate.call(this, $elem, p__6983);
};
slide_down.cljs$lang$maxFixedArity = 1;
slide_down.cljs$lang$applyTo = (function (arglist__6986){
var $elem = cljs.core.first(arglist__6986);
var p__6983 = cljs.core.rest(arglist__6986);
return slide_down__delegate($elem, p__6983);
});
slide_down.cljs$core$IFn$_invoke$arity$variadic = slide_down__delegate;
return slide_down;
})()
;
jayq.core.bind = (function bind($elem,ev,func){
return $elem.bind(cljs.core.name.call(null,ev),func);
});
jayq.core.find = (function find($elem,selector){
return $elem.find(cljs.core.name.call(null,selector));
});
jayq.core.trigger = (function trigger($elem,ev){
return $elem.trigger(cljs.core.name.call(null,ev));
});
jayq.core.delegate = (function delegate($elem,sel,ev,func){
return $elem.delegate(jayq.core.__GT_selector.call(null,sel),cljs.core.name.call(null,ev),func);
});
jayq.core.inner = (function inner($elem,v){
return $elem.html(v);
});
jayq.core.empty = (function empty($elem){
return $elem.empty();
});
/**
* @param {...*} var_args
*/
jayq.core.val = (function() { 
var val__delegate = function ($elem,p__6987){
var vec__6989 = p__6987;
var v = cljs.core.nth.call(null,vec__6989,0,null);
if(cljs.core.truth_(v))
{return $elem.val(v);
} else
{return $elem.val();
}
};
var val = function ($elem,var_args){
var p__6987 = null;
if (arguments.length > 1) {
  p__6987 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return val__delegate.call(this, $elem, p__6987);
};
val.cljs$lang$maxFixedArity = 1;
val.cljs$lang$applyTo = (function (arglist__6990){
var $elem = cljs.core.first(arglist__6990);
var p__6987 = cljs.core.rest(arglist__6990);
return val__delegate($elem, p__6987);
});
val.cljs$core$IFn$_invoke$arity$variadic = val__delegate;
return val;
})()
;
jayq.core.queue = (function queue($elem,callback){
return $elem.queue(callback);
});
jayq.core.dequeue = (function dequeue(elem){
return jayq.core.$.call(null,elem).dequeue();
});
jayq.core.xhr = (function xhr(p__6991,content,callback){
var vec__6993 = p__6991;
var method = cljs.core.nth.call(null,vec__6993,0,null);
var uri = cljs.core.nth.call(null,vec__6993,1,null);
var params = jayq.util.map__GT_js.call(null,cljs.core.PersistentArrayMap.fromArray(["\uFDD0:type",clojure.string.upper_case.call(null,cljs.core.name.call(null,method)),"\uFDD0:data",jayq.util.map__GT_js.call(null,content),"\uFDD0:success",callback], true));
return jQuery.ajax(uri,params);
});
