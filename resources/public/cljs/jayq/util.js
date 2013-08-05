goog.provide('jayq.util');
goog.require('cljs.core');
jayq.util.map__GT_js = (function map__GT_js(m){
var out = {};
var seq__7022_7028 = cljs.core.seq.call(null,m);
var chunk__7023_7029 = null;
var count__7024_7030 = 0;
var i__7025_7031 = 0;
while(true){
if((i__7025_7031 < count__7024_7030))
{var vec__7026_7032 = cljs.core._nth.call(null,chunk__7023_7029,i__7025_7031);
var k_7033 = cljs.core.nth.call(null,vec__7026_7032,0,null);
var v_7034 = cljs.core.nth.call(null,vec__7026_7032,1,null);
(out[cljs.core.name.call(null,k_7033)] = v_7034);
{
var G__7035 = seq__7022_7028;
var G__7036 = chunk__7023_7029;
var G__7037 = count__7024_7030;
var G__7038 = (i__7025_7031 + 1);
seq__7022_7028 = G__7035;
chunk__7023_7029 = G__7036;
count__7024_7030 = G__7037;
i__7025_7031 = G__7038;
continue;
}
} else
{var temp__4092__auto___7039 = cljs.core.seq.call(null,seq__7022_7028);
if(temp__4092__auto___7039)
{var seq__7022_7040__$1 = temp__4092__auto___7039;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__7022_7040__$1))
{var c__5544__auto___7041 = cljs.core.chunk_first.call(null,seq__7022_7040__$1);
{
var G__7042 = cljs.core.chunk_rest.call(null,seq__7022_7040__$1);
var G__7043 = c__5544__auto___7041;
var G__7044 = cljs.core.count.call(null,c__5544__auto___7041);
var G__7045 = 0;
seq__7022_7028 = G__7042;
chunk__7023_7029 = G__7043;
count__7024_7030 = G__7044;
i__7025_7031 = G__7045;
continue;
}
} else
{var vec__7027_7046 = cljs.core.first.call(null,seq__7022_7040__$1);
var k_7047 = cljs.core.nth.call(null,vec__7027_7046,0,null);
var v_7048 = cljs.core.nth.call(null,vec__7027_7046,1,null);
(out[cljs.core.name.call(null,k_7047)] = v_7048);
{
var G__7049 = cljs.core.next.call(null,seq__7022_7040__$1);
var G__7050 = null;
var G__7051 = 0;
var G__7052 = 0;
seq__7022_7028 = G__7049;
chunk__7023_7029 = G__7050;
count__7024_7030 = G__7051;
i__7025_7031 = G__7052;
continue;
}
}
} else
{}
}
break;
}
return out;
});
jayq.util.wait = (function wait(ms,func){
return setTimeout(func, ms);
});
/**
* @param {...*} var_args
*/
jayq.util.log = (function() { 
var log__delegate = function (v,text){
var vs = ((cljs.core.string_QMARK_.call(null,v))?cljs.core.apply.call(null,cljs.core.str,v,text):v);
return console.log(vs);
};
var log = function (v,var_args){
var text = null;
if (arguments.length > 1) {
  text = cljs.core.array_seq(Array.prototype.slice.call(arguments, 1),0);
} 
return log__delegate.call(this, v, text);
};
log.cljs$lang$maxFixedArity = 1;
log.cljs$lang$applyTo = (function (arglist__7053){
var v = cljs.core.first(arglist__7053);
var text = cljs.core.rest(arglist__7053);
return log__delegate(v, text);
});
log.cljs$core$IFn$_invoke$arity$variadic = log__delegate;
return log;
})()
;
