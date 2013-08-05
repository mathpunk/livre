goog.provide('jayq.util');
goog.require('cljs.core');
jayq.util.map__GT_js = (function map__GT_js(m){
var out = {};
var seq__7067_7073 = cljs.core.seq.call(null,m);
var chunk__7068_7074 = null;
var count__7069_7075 = 0;
var i__7070_7076 = 0;
while(true){
if((i__7070_7076 < count__7069_7075))
{var vec__7071_7077 = cljs.core._nth.call(null,chunk__7068_7074,i__7070_7076);
var k_7078 = cljs.core.nth.call(null,vec__7071_7077,0,null);
var v_7079 = cljs.core.nth.call(null,vec__7071_7077,1,null);
(out[cljs.core.name.call(null,k_7078)] = v_7079);
{
var G__7080 = seq__7067_7073;
var G__7081 = chunk__7068_7074;
var G__7082 = count__7069_7075;
var G__7083 = (i__7070_7076 + 1);
seq__7067_7073 = G__7080;
chunk__7068_7074 = G__7081;
count__7069_7075 = G__7082;
i__7070_7076 = G__7083;
continue;
}
} else
{var temp__4092__auto___7084 = cljs.core.seq.call(null,seq__7067_7073);
if(temp__4092__auto___7084)
{var seq__7067_7085__$1 = temp__4092__auto___7084;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__7067_7085__$1))
{var c__5589__auto___7086 = cljs.core.chunk_first.call(null,seq__7067_7085__$1);
{
var G__7087 = cljs.core.chunk_rest.call(null,seq__7067_7085__$1);
var G__7088 = c__5589__auto___7086;
var G__7089 = cljs.core.count.call(null,c__5589__auto___7086);
var G__7090 = 0;
seq__7067_7073 = G__7087;
chunk__7068_7074 = G__7088;
count__7069_7075 = G__7089;
i__7070_7076 = G__7090;
continue;
}
} else
{var vec__7072_7091 = cljs.core.first.call(null,seq__7067_7085__$1);
var k_7092 = cljs.core.nth.call(null,vec__7072_7091,0,null);
var v_7093 = cljs.core.nth.call(null,vec__7072_7091,1,null);
(out[cljs.core.name.call(null,k_7092)] = v_7093);
{
var G__7094 = cljs.core.next.call(null,seq__7067_7085__$1);
var G__7095 = null;
var G__7096 = 0;
var G__7097 = 0;
seq__7067_7073 = G__7094;
chunk__7068_7074 = G__7095;
count__7069_7075 = G__7096;
i__7070_7076 = G__7097;
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
log.cljs$lang$applyTo = (function (arglist__7098){
var v = cljs.core.first(arglist__7098);
var text = cljs.core.rest(arglist__7098);
return log__delegate(v, text);
});
log.cljs$core$IFn$_invoke$arity$variadic = log__delegate;
return log;
})()
;
