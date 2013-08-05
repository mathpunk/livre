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
{var seq__6899_6905 = cljs.core.seq.call(null,attrs);
var chunk__6900_6906 = null;
var count__6901_6907 = 0;
var i__6902_6908 = 0;
while(true){
if((i__6902_6908 < count__6901_6907))
{var vec__6903_6909 = cljs.core._nth.call(null,chunk__6900_6906,i__6902_6908);
var k_6910 = cljs.core.nth.call(null,vec__6903_6909,0,null);
var v_6911 = cljs.core.nth.call(null,vec__6903_6909,1,null);
dom_attr.call(null,elem,k_6910,v_6911);
{
var G__6912 = seq__6899_6905;
var G__6913 = chunk__6900_6906;
var G__6914 = count__6901_6907;
var G__6915 = (i__6902_6908 + 1);
seq__6899_6905 = G__6912;
chunk__6900_6906 = G__6913;
count__6901_6907 = G__6914;
i__6902_6908 = G__6915;
continue;
}
} else
{var temp__4092__auto___6916 = cljs.core.seq.call(null,seq__6899_6905);
if(temp__4092__auto___6916)
{var seq__6899_6917__$1 = temp__4092__auto___6916;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__6899_6917__$1))
{var c__5544__auto___6918 = cljs.core.chunk_first.call(null,seq__6899_6917__$1);
{
var G__6919 = cljs.core.chunk_rest.call(null,seq__6899_6917__$1);
var G__6920 = c__5544__auto___6918;
var G__6921 = cljs.core.count.call(null,c__5544__auto___6918);
var G__6922 = 0;
seq__6899_6905 = G__6919;
chunk__6900_6906 = G__6920;
count__6901_6907 = G__6921;
i__6902_6908 = G__6922;
continue;
}
} else
{var vec__6904_6923 = cljs.core.first.call(null,seq__6899_6917__$1);
var k_6924 = cljs.core.nth.call(null,vec__6904_6923,0,null);
var v_6925 = cljs.core.nth.call(null,vec__6904_6923,1,null);
dom_attr.call(null,elem,k_6924,v_6925);
{
var G__6926 = cljs.core.next.call(null,seq__6899_6917__$1);
var G__6927 = null;
var G__6928 = 0;
var G__6929 = 0;
seq__6899_6905 = G__6926;
chunk__6900_6906 = G__6927;
count__6901_6907 = G__6928;
i__6902_6908 = G__6929;
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
var seq__6934 = cljs.core.seq.call(null,content);
var chunk__6935 = null;
var count__6936 = 0;
var i__6937 = 0;
while(true){
if((i__6937 < count__6936))
{var c = cljs.core._nth.call(null,chunk__6935,i__6937);
var child_6938 = (((c == null))?null:((cljs.core.map_QMARK_.call(null,c))?(function(){throw "Maps cannot be used as content"})():((cljs.core.string_QMARK_.call(null,c))?goog.dom.createTextNode(c):((cljs.core.vector_QMARK_.call(null,c))?crate.core.elem_factory.call(null,c):((cljs.core.seq_QMARK_.call(null,c))?as_content.call(null,parent,c):(cljs.core.truth_(c.nodeName)?c:null))))));
if(cljs.core.truth_(child_6938))
{goog.dom.appendChild(parent,child_6938);
} else
{}
{
var G__6939 = seq__6934;
var G__6940 = chunk__6935;
var G__6941 = count__6936;
var G__6942 = (i__6937 + 1);
seq__6934 = G__6939;
chunk__6935 = G__6940;
count__6936 = G__6941;
i__6937 = G__6942;
continue;
}
} else
{var temp__4092__auto__ = cljs.core.seq.call(null,seq__6934);
if(temp__4092__auto__)
{var seq__6934__$1 = temp__4092__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__6934__$1))
{var c__5544__auto__ = cljs.core.chunk_first.call(null,seq__6934__$1);
{
var G__6943 = cljs.core.chunk_rest.call(null,seq__6934__$1);
var G__6944 = c__5544__auto__;
var G__6945 = cljs.core.count.call(null,c__5544__auto__);
var G__6946 = 0;
seq__6934 = G__6943;
chunk__6935 = G__6944;
count__6936 = G__6945;
i__6937 = G__6946;
continue;
}
} else
{var c = cljs.core.first.call(null,seq__6934__$1);
var child_6947 = (((c == null))?null:((cljs.core.map_QMARK_.call(null,c))?(function(){throw "Maps cannot be used as content"})():((cljs.core.string_QMARK_.call(null,c))?goog.dom.createTextNode(c):((cljs.core.vector_QMARK_.call(null,c))?crate.core.elem_factory.call(null,c):((cljs.core.seq_QMARK_.call(null,c))?as_content.call(null,parent,c):(cljs.core.truth_(c.nodeName)?c:null))))));
if(cljs.core.truth_(child_6947))
{goog.dom.appendChild(parent,child_6947);
} else
{}
{
var G__6948 = cljs.core.next.call(null,seq__6934__$1);
var G__6949 = null;
var G__6950 = 0;
var G__6951 = 0;
seq__6934 = G__6948;
chunk__6935 = G__6949;
count__6936 = G__6950;
i__6937 = G__6951;
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
crate.core.normalize_element = (function normalize_element(p__6953){
var vec__6958 = p__6953;
var tag = cljs.core.nth.call(null,vec__6958,0,null);
var content = cljs.core.nthnext.call(null,vec__6958,1);
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
var vec__6959 = cljs.core.re_matches.call(null,crate.core.re_tag,cljs.core.name.call(null,tag));
var _ = cljs.core.nth.call(null,vec__6959,0,null);
var tag__$1 = cljs.core.nth.call(null,vec__6959,1,null);
var id = cljs.core.nth.call(null,vec__6959,2,null);
var class$ = cljs.core.nth.call(null,vec__6959,3,null);
var vec__6960 = (function (){var vec__6961 = clojure.string.split.call(null,tag__$1,/:/);
var nsp = cljs.core.nth.call(null,vec__6961,0,null);
var t = cljs.core.nth.call(null,vec__6961,1,null);
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
var nsp = cljs.core.nth.call(null,vec__6960,0,null);
var tag__$2 = cljs.core.nth.call(null,vec__6960,1,null);
var tag_attrs = cljs.core.into.call(null,cljs.core.ObjMap.EMPTY,cljs.core.filter.call(null,((function (vec__6959,_,tag__$1,id,class$,vec__6960,nsp,tag__$2){
return (function (p1__6952_SHARP_){
return !((cljs.core.second.call(null,p1__6952_SHARP_) == null));
});})(vec__6959,_,tag__$1,id,class$,vec__6960,nsp,tag__$2))
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
var vec__6963 = crate.core.normalize_element.call(null,tag_def);
var nsp = cljs.core.nth.call(null,vec__6963,0,null);
var tag = cljs.core.nth.call(null,vec__6963,1,null);
var attrs = cljs.core.nth.call(null,vec__6963,2,null);
var content = cljs.core.nth.call(null,vec__6963,3,null);
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
html.cljs$lang$applyTo = (function (arglist__6964){
var tags = cljs.core.seq(arglist__6964);
return html__delegate(tags);
});
html.cljs$core$IFn$_invoke$arity$variadic = html__delegate;
return html;
})()
;
