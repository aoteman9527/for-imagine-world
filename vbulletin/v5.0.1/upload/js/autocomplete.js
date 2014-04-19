window.vBulletin=window.vBulletin||{};window.vBulletin.phrase=window.vBulletin.phrase||{};window.vBulletin.phrase.precache=window.vBulletin.phrase.precache||[];window.vBulletin.phrase.precache=$.merge(window.vBulletin.phrase.precache,[]);var vBulletin_Autocomplete=function(T,a){var B=$(T),Y=a.apiClass||null,K=a.apiFunction||"getAutocomplete",c=a.delay||500,b=a.minLength||3,X=a.maxItems||false,F=B.attr("name")||"autocompleteElements",I=a.containerClass||"entry-field",J=a.placeholderText,M=[],A=B.parent(".autocomplete-container"),e=A.find(".autocompleteHelper"),Z=false,R=false,P=B.siblings(".autocomplete-box"),H=a.beforeAdd||false,G=a.afterAdd||false,E=a.beforeDelete||false,C=a.afterDelete||false,N=this,W=a.editorContext||null,V=function(){if(A.length==0){B.wrap('<div class="autocomplete-container" />');A=B.parent(".autocomplete-container");A.addClass(I).on("mousedown",function(k){var i=this;setTimeout(function(){var l=$(".autocompleteHelper:visible",i);if(l.length>0){l[0].focus()}},10);return false})}if(P.length==0){P=$("<div />").addClass("autocomplete-box").insertBefore(B)}if(e.length==0){e=$('<input type="text" name="autocompleteHelper" />').addClass("autocompleteHelper").attr("placeholder",function(){return J?J:null}).attr("maxlength",function(){return B.attr("maxlength")?B.attr("maxlength"):null}).insertAfter(P)}e.attr("tabindex",B.attr("tabindex")||0);e.off("keydown").on("keydown",function(k){if(k.which==13){var i=$(k.target).val();if(i.length>=b){Q(i,true,k)}}});e.off("blur").on("blur",function(i){Z=window.setTimeout(function(){if(!R){var k=e.val();if(k.length>=b){Q(k,true,i)}}R=false;Z=false},200)});e.off("focus").on("focus",function(i){R=Z?true:false;return false});var g=["font-family","font-size","font-weight","font-style","color","border","line-height","height"];var h;for(h=0;h<g.length;++h){A.css(g[h],B.css(g[h]))}var f='<input type="hidden" name="'+F+'"';if(B.attr("id")){f+=' id="'+B.attr("id")+'"'}if(B.attr("class")){f+=' class="'+B.attr("class")+'"'}if(B.attr("data-value")){var j=B.attr("data-value").split(",")}f+=" />";B.replaceWith(f);B=A.find('[name="'+F+'"]');e.autocomplete({delay:c,minLength:b,search:function(i,k){console.log("searching for "+this.value)},source:function(i,k){console.log("getting source for "+i.term);vBulletin.AJAX({url:vBulletin.getAjaxBaseurl()+"/ajax/api/"+Y+"/"+K,data:({searchStr:i.term}),success:function(m){console.log("got source for "+i.term+":");if(m&&$.isArray(m.suggestions)){var l=[];$.each(m.suggestions,function(n,o){if(W&&W.type=="tags"){l.push({label:o.title,value:pageData.userid})}else{l.push({label:o.title,value:o.value})}});k(l)}else{console.log("/ajax/api/"+Y+"/"+K+" successful, but response was not an array");openAlertDialog({title:vBulletin.phrase.get("error"),message:vBulletin.phrase.get("invalid_server_response_please_try_again"),iconType:"error"})}},error_phrase:"error_getting_suggestions"})},select:function(k,i){N.addElement(i.item.label,i.item.value);e.val("");k.preventDefault()},focus:function(k,i){e.val(i.item.label);k.preventDefault()}});P.delegate(".element-x","click",function(n){var l=$(this).closest(".autocomplete");var k=l.find(".element-text").text().toLowerCase();var i=[];var m=false;$(M).each(function(o,p){if(p.label.toLowerCase()==k){m=p}else{i.push(p)}});if(typeof E=="function"){if(!E.call(this,m.label,m.data)){return false}}M=i;l.remove();d();if(typeof C=="function"){C.call(this,m.label,m.data)}});A.off("click").on("click",function(i){if(!$(i.target).hasClass("ui-autocomplete-input")){$(".ui-autocomplete-input",$(this)).focus()}return false});if(j){U.call(this,j)}},L=function(j,i){if(j==""){return false}if(typeof H=="function"){if(!H.call(this,j,i)){return false}}var h=true;$(M).each(function(l,m){if(m.label==j){h=false}});if(!h){return false}if(X){if(M.length>=X){return false}}var k=$("<div />").addClass("element-x vb-icon vb-icon-x-blue").text("X");var f=$("<div />").addClass("element-text").text(j);var g=$("<div />").addClass("autocomplete").append(f).append(k).appendTo(P);M.push({label:j,value:i});d();if(typeof G=="function"){G.call(this,j,i)}P.show();return true},U=function(h){var f=h.length,g;for(g=0;g<f;++g){L(h[g])}},S=function(f){O();U(f)},O=function(){P.html("");e.val("");M=[];d()},d=function(){var f=[];$(M).each(function(g,h){f.push(h.label)});B.val(f.join(","))},D=function(){return b},Q=function(h,f,g){if(W){switch(W.type){case"tags":W.context.addTag(h);break;default:break}}else{N.addElement(h,h);e.val("")}if(typeof f!=="undefined"&&typeof g!=="undefined"){g.preventDefault();return false}};V.call(this);this.addElement=function(g,f){return L.call(this,g,f)};this.addElements=function(f){U.call(this,f)};this.setElements=function(f){S.call(this,f)};this.getElements=function(){return M};this.getLabels=function(){var f=[];$(M).each(function(g,h){f.push(h.label)});return f};this.getValues=function(){var f=[];$(M).each(function(g,h){f.push(h.value)});return f};this.getInputField=function(){return e};this.clearElements=function(){return O.call(this)};this.countElements=function(){return $(M).length};this.getMinLength=function(){return D()}};