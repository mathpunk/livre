goog.provide('crate.core');
goog.require('cljs.core');
goog.require('clojure.string');
goog.require('goog.dom');
crate.core.xmlns = cljs.core.PersistentArrayMap.fromArray(["\uFDD0:xhtml","http://www.w3.org/1999/xhtml","\uFDD0:svg","http://www.w3.org/2000/svg"], true);
crate.core.elem_id = cljs.core.atom.call(null,0);
crate.core.group_id = cljs.core.atom.call(null,0);
crate.core.dom_attr = (function() {
var dom_attr = null;
var dom_attr__2 = (function (elem,attrs){
if(cljs.core.truth_(elem))
{if(!(cljs.core.map_QMARK_.call(null,attrs)))
{return elem.getAttribute(cljs.core.name.call(null,attrs));
} else
{var seq__6944_6950 = cljs.core.seq.call(null,attrs);
var chunk__6945_6951 = null;
var count__6946_6952 = 0;
var i__6947_6953 = 0;
while(true){
if((i__6947_6953 < count__6946_6952))
{var vec__6948_6954 = cljs.core._nth.call(null,chunk__6945_6951,i__6947_6953);
var k_6955 = cljs.core.nth.call(null,vec__6948_6954,0,null);
var v_6956 = cljs.core.nth.call(null,vec__6948_6954,1,null);
dom_attr.call(null,elem,k_6955,v_6956);
{
var G__6957 = seq__6944_6950;
var G__6958 = chunk__6945_6951;
var G__6959 = count__6946_6952;
var G__6960 = (i__6947_6953 + 1);
seq__6944_6950 = G__6957;
chunk__6945_6951 = G__6958;
count__6946_6952 = G__6959;
i__6947_6953 = G__6960;
continue;
}
} else
{var temp__4092__auto___6961 = cljs.core.seq.call(null,seq__6944_6950);
if(temp__4092__auto___6961)
{var seq__6944_6962__$1 = temp__4092__auto___6961;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__6944_6962__$1))
{var c__5589__auto___6963 = cljs.core.chunk_first.call(null,seq__6944_6962__$1);
{
var G__6964 = cljs.core.chunk_rest.call(null,seq__6944_6962__$1);
var G__6965 = c__5589__auto___6963;
var G__6966 = cljs.core.count.call(null,c__5589__auto___6963);
var G__6967 = 0;
seq__6944_6950 = G__6964;
chunk__6945_6951 = G__6965;
count__6946_6952 = G__6966;
i__6947_6953 = G__6967;
continue;
}
} else
{var vec__6949_6968 = cljs.core.first.call(null,seq__6944_6962__$1);
var k_6969 = cljs.core.nth.call(null,vec__6949_6968,0,null);
var v_6970 = cljs.core.nth.call(null,vec__6949_6968,1,null);
dom_attr.call(null,elem,k_6969,v_6970);
{
var G__6971 = cljs.core.next.call(null,seq__6944_6962__$1);
var G__6972 = null;
var G__6973 = 0;
var G__6974 = 0;
seq__6944_6950 = G__6971;
chunk__6945_6951 = G__6972;
count__6946_6952 = G__6973;
i__6947_6953 = G__6974;
continue;
}
}
} else
{}
}
break;
}
return elem;
}
} else
{return null;
}
});
var dom_attr__3 = (function (elem,k,v){
elem.setAttribute(cljs.core.name.call(null,k),v);
return elem;
});
dom_attr = function(elem,k,v){
switch(arguments.length){
case 2:
return dom_attr__2.call(this,elem,k);
case 3:
return dom_attr__3.call(this,elem,k,v);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
dom_attr.cljs$core$IFn$_invoke$arity$2 = dom_attr__2;
dom_attr.cljs$core$IFn$_invoke$arity$3 = dom_attr__3;
return dom_attr;
})()
;
crate.core.as_content = (function as_content(parent,content){
var seq__6979 = cljs.core.seq.call(null,content);
var chunk__6980 = null;
var count__6981 = 0;
var i__6982 = 0;
while(true){
if((i__6982 < count__6981))
{var c = cljs.core._nth.call(null,chunk__6980,i__6982);
var child_6983 = (((c == null))?null:((cljs.core.map_QMARK_.call(null,c))?(function(){throw "Maps cannot be used as content"})():((cljs.core.string_QMARK_.call(null,c))?goog.dom.createTextNode(c):((cljs.core.vector_QMARK_.call(null,c))?crate.core.elem_factory.call(null,c):((cljs.core.seq_QMARK_.call(null,c))?as_content.call(null,parent,c):(cljs.core.truth_(c.nodeName)?c:null))))));
if(cljs.core.truth_(child_6983))
{goog.dom.appendChild(parent,child_6983);
} else
{}
{
var G__6984 = seq__6979;
var G__6985 = chunk__6980;
var G__6986 = count__6981;
var G__6987 = (i__6982 + 1);
seq__6979 = G__6984;
chunk__6980 = G__6985;
count__6981 = G__6986;
i__6982 = G__6987;
continue;
}
} else
{var temp__4092__auto__ = cljs.core.seq.call(null,seq__6979);
if(temp__4092__auto__)
{var seq__6979__$1 = temp__4092__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__6979__$1))
{var c__5589__auto__ = cljs.core.chunk_first.call(null,seq__6979__$1);
{
var G__6988 = cljs.core.chunk_rest.call(null,seq__6979__$1);
var G__6989 = c__5589__auto__;
var G__6990 = cljs.core.count.call(null,c__5589__auto__);
var G__6991 = 0;
seq__6979 = G__6988;
chunk__6980 = G__6989;
count__6981 = G__6990;
i__6982 = G__6991;
continue;
}
} else
{var c = cljs.core.first.call(null,seq__6979__$1);
var child_6992 = (((c == null))?null:((cljs.core.map_QMARK_.call(null,c))?(function(){throw "Maps cannot be used as content"})():((cljs.core.string_QMARK_.call(null,c))?goog.dom.createTextNode(c):((cljs.core.vector_QMARK_.call(null,c))?crate.core.elem_factory.call(null,c):((cljs.core.seq_QMARK_.call(null,c))?as_content.call(null,parent,c):(cljs.core.truth_(c.nodeName)?c:null))))));
if(cljs.core.truth_(child_6992))
{goog.dom.appendChild(parent,child_6992);
} else
{}
{
var G__6993 = cljs.core.next.call(null,seq__6979__$1);
var G__6994 = null;
var G__6995 = 0;
var G__6996 = 0;
seq__6979 = G__6993;
chunk__6980 = G__6994;
count__6981 = G__6995;
i__6982 = G__6996;
continue;
}
}
} else
{return null;
}
}
break;
}
});
/**
* Regular expression that parses a CSS-style id and class from a tag name.
*/
crate.core.re_tag = /([^\s\.#]+)(?:#([^\s\.#]+))?(?:\.([^\s#]+))?/;
/**
* Ensure a tag vector is of the form [tag-name attrs content].
*/
crate.core.normalize_element = (function normalize_element(p__6998){
var vec__7003 = p__6998;
var tag = cljs.core.nth.call(null,vec__7003,0,null);
var content = cljs.core.nthnext.call(null,vec__7003,1);
if(!((function (){var or__3943__auto__ = cljs.core.keyword_QMARK_.call(null,tag);
if(or__3943__auto__)
{return or__3943__auto__;
} else
{var or__3943__auto____$1 = (tag instanceof cljs.core.Symbol);
if(or__3943__auto____$1)
{return or__3943__auto____$1;
} else
{return cljs.core.string_QMARK_.call(null,tag);
}
}
})()))
{throw [cljs.core.str(tag),cljs.core.str(" is not a valid tag name.")].join('');
} else
{}
var vec__7004 = cljs.core.re_matches.call(null,crate.core.re_tag,cljs.core.name.call(null,tag));
var _ = cljs.core.nth.call(null,vec__7004,0,null);
var tag__$1 = cljs.core.nth.call(null,vec__7004,1,null);
var id = cljs.core.nth.call(null,vec__7004,2,null);
var class$ = cljs.core.nth.call(null,vec__7004,3,null);
var vec__7005 = (function (){var vec__7006 = clojure.string.split.call(null,tag__$1,/:/);
var nsp = cljs.core.nth.call(null,vec__7006,0,null);
var t = cljs.core.nth.call(null,vec__7006,1,null);
var ns_xmlns = crate.core.xmlns.call(null,cljs.core.keyword.call(null,nsp));
if(cljs.core.truth_(t))
{return cljs.core.PersistentVector.fromArray([(function (){var or__3943__auto__ = ns_xmlns;
if(cljs.core.truth_(or__3943__auto__))
{return or__3943__auto__;
} else
{return nsp;
}
})(),t], true);
} else
{return cljs.core.PersistentVector.fromArray([(new cljs.core.Keyword("\uFDD0:xhtml")).call(null,crate.core.xmlns),nsp], true);
}
})();
var nsp = cljs.core.nth.call(null,vec__7005,0,null);
var tag__$2 = cljs.core.nth.call(null,vec__7005,1,null);
var tag_attrs = cljs.core.into.call(null,cljs.core.ObjMap.EMPTY,cljs.core.filter.call(null,((function (vec__7004,_,tag__$1,id,class$,vec__7005,nsp,tag__$2){
return (function (p1__6997_SHARP_){
return !((cljs.core.second.call(null,p1__6997_SHARP_) == null));
});})(vec__7004,_,tag__$1,id,class$,vec__7005,nsp,tag__$2))
,cljs.core.PersistentArrayMap.fromArray(["\uFDD0:id",(function (){var or__3943__auto__ = id;
if(cljs.core.truth_(or__3943__auto__))
{return or__3943__auto__;
} else
{return null;
}
})(),"\uFDD0:class",(cljs.core.truth_(class$)?clojure.string.replace.call(null,class$,/\./," "):null)], true)));
var map_attrs = cljs.core.first.call(null,content);
if(cljs.core.map_QMARK_.call(null,map_attrs))
{return cljs.core.PersistentVector.fromArray([nsp,tag__$2,cljs.core.merge.call(null,tag_attrs,map_attrs),cljs.core.next.call(null,content)], true);
} else
{return cljs.core.PersistentVector.fromArray([nsp,tag__$2,tag_attrs,content], true);
}
});
crate.core.parse_content = (function parse_content(elem,content){
var attrs = cljs.core.first.call(null,content);
if(cljs.core.map_QMARK_.call(null,attrs))
{crate.core.dom_attr.call(null,elem,attrs);
return cljs.core.rest.call(null,content);
} else
{return content;
}
});
crate.core.create_elem = (function create_elem(nsp,tag){
return document.createElementNS(nsp,tag);
});
crate.core.elem_factory = (function elem_factory(tag_def){
var vec__7008 = crate.core.normalize_element.call(null,tag_def);
var nsp = cljs.core.nth.call(null,vec__7008,0,null);
var tag = cljs.core.nth.call(null,vec__7008,1,null);
var attrs = cljs.core.nth.call(null,vec__7008,2,null);
var content = cljs.core.nth.call(null,vec__7008,3,null);
var elem = crate.core.create_elem.call(null,nsp,tag);
crate.core.dom_attr.call(null,elem,cljs.core.merge.call(null,attrs,cljs.core.PersistentArrayMap.fromArray(["\uFDD0:crateId",cljs.core.swap_BANG_.call(null,crate.core.elem_id,cljs.core.inc)], true)));
crate.core.as_content.call(null,elem,content);
return elem;
});
/**
* @param {...*} var_args
*/
crate.core.html = (function() { 
var html__delegate = function (tags){
var res = cljs.core.map.call(null,crate.core.elem_factory,tags);
if(cljs.core.truth_(cljs.core.second.call(null,res)))
{return res;
} else
{return cljs.core.first.call(null,res);
}
};
var html = function (var_args){
var tags = null;
if (arguments.length > 0) {
  tags = cljs.core.array_seq(Array.prototype.slice.call(arguments, 0),0);
} 
return html__delegate.call(this, tags);
};
html.cljs$lang$maxFixedArity = 0;
html.cljs$lang$applyTo = (function (arglist__7009){
var tags = cljs.core.seq(arglist__7009);
return html__delegate(tags);
});
html.cljs$core$IFn$_invoke$arity$variadic = html__delegate;
return html;
})()
;
