goog.provide('jayq.util');
goog.require('cljs.core');
jayq.util.map__GT_js = (function map__GT_js(m){
var out = {};
var seq__7000_7006 = cljs.core.seq.call(null,m);
var chunk__7001_7007 = null;
var count__7002_7008 = 0;
var i__7003_7009 = 0;
while(true){
if((i__7003_7009 < count__7002_7008))
{var vec__7004_7010 = cljs.core._nth.call(null,chunk__7001_7007,i__7003_7009);
var k_7011 = cljs.core.nth.call(null,vec__7004_7010,0,null);
var v_7012 = cljs.core.nth.call(null,vec__7004_7010,1,null);
(out[cljs.core.name.call(null,k_7011)] = v_7012);
{
var G__7013 = seq__7000_7006;
var G__7014 = chunk__7001_7007;
var G__7015 = count__7002_7008;
var G__7016 = (i__7003_7009 + 1);
seq__7000_7006 = G__7013;
chunk__7001_7007 = G__7014;
count__7002_7008 = G__7015;
i__7003_7009 = G__7016;
continue;
}
} else
{var temp__4092__auto___7017 = cljs.core.seq.call(null,seq__7000_7006);
if(temp__4092__auto___7017)
{var seq__7000_7018__$1 = temp__4092__auto___7017;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__7000_7018__$1))
{var c__5522__auto___7019 = cljs.core.chunk_first.call(null,seq__7000_7018__$1);
{
var G__7020 = cljs.core.chunk_rest.call(null,seq__7000_7018__$1);
var G__7021 = c__5522__auto___7019;
var G__7022 = cljs.core.count.call(null,c__5522__auto___7019);
var G__7023 = 0;
seq__7000_7006 = G__7020;
chunk__7001_7007 = G__7021;
count__7002_7008 = G__7022;
i__7003_7009 = G__7023;
continue;
}
} else
{var vec__7005_7024 = cljs.core.first.call(null,seq__7000_7018__$1);
var k_7025 = cljs.core.nth.call(null,vec__7005_7024,0,null);
var v_7026 = cljs.core.nth.call(null,vec__7005_7024,1,null);
(out[cljs.core.name.call(null,k_7025)] = v_7026);
{
var G__7027 = cljs.core.next.call(null,seq__7000_7018__$1);
var G__7028 = null;
var G__7029 = 0;
var G__7030 = 0;
seq__7000_7006 = G__7027;
chunk__7001_7007 = G__7028;
count__7002_7008 = G__7029;
i__7003_7009 = G__7030;
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
log.cljs$lang$applyTo = (function (arglist__7031){
var v = cljs.core.first(arglist__7031);
var text = cljs.core.rest(arglist__7031);
return log__delegate(v, text);
});
log.cljs$core$IFn$_invoke$arity$variadic = log__delegate;
return log;
})()
;
