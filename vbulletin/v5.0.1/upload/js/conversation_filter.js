window.vBulletin=window.vBulletin||{};window.vBulletin.phrase=window.vBulletin.phrase||{};window.vBulletin.phrase.precache=window.vBulletin.phrase.precache||[];window.vBulletin.phrase.precache=$.merge(window.vBulletin.phrase.precache,["invalid_request","invalid_search_syntax","invalid_server_response_please_try_again","unknown_error"]);(function(A){vBulletin.conversation=vBulletin.conversation||{};vBulletin.conversation.filter=function(H){var K=this;var C=null;var D=0;var G=false;var B=false;var J='<div class="filter-text" data-filter-name="{0}"><span title="{1}">{2}</span><span class="x vb-icon vb-icon-x-blue"></span></div>';var F="conversation_filter";var L={context:document,autoCheck:false,checkInterval:15000,scrollToTop:null,customFilter:null,onContentLoad:null,closeOverlayOnScroll:true,pagination:null};if(H&&typeof H=="object"){A.extend(L,H)}function E(){A(".toolbar-filter-overlay input[type=radio]",L.context).off("change."+F).on("change."+F,function(){G=true;L.customFilter=null;if(!A(this).data("bypass-filter-display")){I(this)}if(A(".conversation-toolbar-wrapper",L.context).length>1){$toolbarWrappers.filter("."+(A(this).closest(".conversation-toolbar-wrapper").hasClass("top")?"bottom":"top")).find("input[name={0}][value={1}]".format(this.name,this.value)).prop("checked",true)}if(this.value=="conversations_on"){L.autoCheck=true;B=true;D=1}else{clearTimeout(D);B=(this.name=="filter_show")}A(".new-conversations-strip",L.context).hide();K.updatePageNumber(1);K.applyFilters(false)});A(".new-conversations-strip",L.context).off("click."+F).on("click."+F,function(){A(this).hide();B=true;K.updatePageNumber(1);K.applyFilters(false,true)});A(".toolbar-filter",L.context).off("click."+F).on("click."+F,function(R,Q,O){var P=A(this).closest(".conversation-toolbar-wrapper");var N=(P.hasClass("bottom"))?"bottom":"top";if(typeof Q=="undefined"){Q="slow"}var S=A(".filter-wrapper",this).toggleClass("selected");A(".arrow .vb-icon",this).toggleClass("vb-icon-triangle-down-wide vb-icon-triangle-up-wide");A(".toolbar-filter-overlay",P).slideToggle(Q,function(){var T=F+N;if(A(this).is(":visible")){A("body").off("click."+T).on("click."+T,function(Z){var X=".conversation-toolbar-wrapper."+N;if(A(Z.target).closest(".toolbar-filter-overlay").length==0&&A(Z.target).closest(".toolbar-filter").length==0){A("body").off("click."+T);A(window).off("scroll."+T);var Y=(A(Z.target).closest(".toolbar-filter").length>0)?"fast":"slow";A(".conversation-toolbar-wrapper.{0} .conversation-toolbar .toolbar-filter".format(N),L.context).triggerHandler("click."+F,[Y])}});var V=true;if(O!="scroll"){var U=A(".filtered-by",L.context);if(U.length==0||U.is(":hidden")){U=this}var W={};V=vBulletin.isScrolledIntoView(U,W);if(!V){A("html,body").animate({scrollTop:"+="+Math.abs(W.bottom)},"fast",function(){setTimeout(function(){if(L.closeOverlayOnScroll){A(window).off("scroll."+T).on("scroll."+T,function(){A(".conversation-toolbar-wrapper.{0} .conversation-toolbar .toolbar-filter".format(N),L.context).triggerHandler("click."+F,[0,"scroll"])})}},50)})}}if(V){if(L.closeOverlayOnScroll){A(window).off("scroll."+T).on("scroll."+T,function(){A(".conversation-toolbar-wrapper.{0} .conversation-toolbar .toolbar-filter".format(N),L.context).triggerHandler("click."+F,[0,"scroll"])})}}}else{A("body").off("click."+T);A(window).off("scroll."+T)}});if(P.hasClass("bottom")&&A(".arrow .vb-icon",this).hasClass("vb-icon-triangle-up-wide")){var M=A(".conversation-toolbar-wrapper.bottom .toolbar-filter-overlay",L.context);A("html, body").animate({scrollTop:M.offset().top+M.innerHeight()},500)}});A(".filtered-by",L.context).off("click."+F,".x").on("click."+F,".x",function(){var M=A(this).closest(".filtered-by");var Q=A(this).closest(".filter-text");var N=Q.attr("data-filter-name");var P=A();A(".toolbar-filter-overlay .filter-options input[name={0}]".format(N),L.context).prop("checked",false).each(function(){if(this.defaultChecked){P=A(this);return false}});K.updatePageNumber(1);if(P.length==1){P.data("bypass-filter-display",true);P.trigger("click."+F);P.removeData()}else{K.applyFilters(false,true)}Q.remove();var O=M.find(".filter-text").length;if(O==0){M.addClass("hide")}else{if(O==1){M.find(".clear-all").addClass("hide")}}});A(".filtered-by",L.context).off("click."+F,".clear-all").on("click."+F,".clear-all",function(){K.resetFilters();return false});A(".conversation-toolbar .filter-wrapper",L.context).data("object-instance",K);A(".conversation-showmore",L.context).click(function(){var M=parseInt(A('form.toolbar-filter-overlay input[name="pagenum"]',L.context).val());B=false;K.updatePageNumber(M+1);K.applyFilters(false,true,true)})}function I(R){var S=A(".filtered-by",L.context).removeClass("hide").find(".filter-text-wrapper").show();var Q=A(".filter-text[data-filter-name={0}]".format(R.name),S);var O=A(R).next("span").html();var M=A(J.format(R.name,A(R).closest(".filter-options").prev(".filter-header").html()+" - "+O,((R.name=="filter_new_topics"||R.name=="filter_depth"||R.name=="filter_prefix"||(R.value.indexOf("_all")!=-1&&R.value!="time_all"))?(A(R).closest("li").find(".filter-header").html()||"")+" ":"")+O));if(Q.length>0){Q.replaceWith(M)}else{var P=[],N=false;A(".toolbar-filter-overlay > ul > li",L.context).each(function(){P.push(A("input:first",this).attr("name"))});A(".filter-text",S).each(function(){var T=A(this);if(A.inArray(R.name,P)<A.inArray(T.attr("data-filter-name"),P)){T.before(M);N=true;return false}});if(!N){S.append(M)}if(A(".filter-text",S).length>1){S.next(".clear-all").removeClass("hide")}}}E();this.isFilterSelected=function(M){return A('.toolbar-filter-overlay input[value="'+M+'"]',L.context).is(":checked")};this.getSelectedFilters=function(M){var N={},O=M.serializeArray();A.each(O,function(Q,R){if(R.name.slice(-2)=="[]"){var P=R.name.split("[]");N[P[0]]=N[P[0]]||[];N[P[0]].push(R.value)}else{N[R.name]=R.value}});return N};this.resetFilters=function(){var M=A(".conversation-toolbar-wrapper .filtered-by",L.context).addClass("hide");A(".clear-all",M).addClass("hide");A("form.toolbar-filter-overlay",L.context).trigger("reset");A(".filter-text",M).remove();K.updatePageNumber(1);K.applyFilters(false,true);return K};this.forceApplyFilters=function(){if(typeof (K.lastFilters)!="undefined"){delete K.lastFilters}B=true;K.applyFilters(false,true);return K};this.applyFilters=function(S,N,P,R){if(N){clearTimeout(D)}var M=A("form.toolbar-filter-overlay",L.context);var O={filters:(!L.customFilter)?K.getSelectedFilters(M):L.customFilter};if(A.isEmptyObject(O.filters)){return K}if(S){O.filters["checkSince"]=C;O.filters["pagenum"]=1}if(!R){var Q=M.find('input[name="result-id"]').val(0);if(Q.length){O.filters["result-id"]=0}}else{B=true}if(typeof (this.lastFilters)!="undefined"&&vBulletin.areJsonObjectsEqual(this.lastFilters.filters,O.filters)&&!S){return K}this.lastFilters=O;A(".conversation-toolbar-wrapper",L.context).addClass("disabled");A(".conversation-empty",L.context).addClass("invisible");if(S){window.vBulletin.loadingIndicator.suppressNextAjaxIndicator()}A.ajax({type:"post",url:vBulletin.normalizeAjaxUrl(M.attr("action"))||(vBulletin.getAjaxBaseurl()+"/activity/get"),data:(O),dataType:"json",success:function(T){A(".conversation-empty",L.context).addClass("hide");if(!T||T.error||T.errors){console.log("/activity/get failed. result:"+JSON.stringify(T));A(".conversation-list",L.context).addClass("hide");var V="unknown_error";if(!T){V="invalid_server_response_please_try_again"}else{if(T.error){V=T.error}else{if(T.errors){V=T.errors[0][0]}}}V=vBulletin.phrase.get(V);A(".conversation-empty",L.context).html((V||"").replace(/<br\s*\/*>/g," ")).removeClass("hide invisible");return }if(S){if(!G&&T.total>0&&!A("body").hasClass("edit-mode")){A(".new-conversations-strip span",L.context).html(T.total);A(".new-conversations-strip",L.context).fadeIn("slow")}if(A(".conversation-list li.list-item",L.context).length==0){A(".conversation-empty",L.context).removeClass("hide")}}else{A(".new-conversations-strip",L.context).hide();if(((T.total_with_sticky>0)||(T.total>0))&&T.template){if(T.resultId){var W=A('input[name="result-id"]',M).val(T.resultId);if(W.length&&this.lastFilters){this.lastFilters.filters["result-id"]=T.resultId}if(L.pagination){L.pagination.updateResultId(T.resultId)}}if(P){A(".conversation-list",L.context).append(T.template)}else{A(".conversation-empty",L.context).addClass("hide");A(".conversation-list",L.context).html(T.template).removeClass("hide")}if(O.filters["pagenum"]>=O.filters["maxpages"]||O.filters["pagenum"]>=T.pageinfo.totalpages||T.pageinfo.showseemore===false){A(".conversation-showmore",L.context).addClass("hide")}else{A(".conversation-showmore",L.context).removeClass("hide")}}else{if(!P){A(".conversation-empty",L.context).removeClass("hide");A(".conversation-list",L.context).addClass("hide").empty()}}if(T.total_with_sticky==0){A(".conversation-showmore",L.context).addClass("hide")}if(B&&L.scrollToTop){var U=(L.scrollToTop instanceof A)?L.scrollToTop:A(L.scrollToTop);if(U.length>0){A("body,html").animate({scrollTop:U.offset().top},"slow")}}C=T.lastDate;if(typeof L.onContentLoad=="function"){L.onContentLoad.apply(A(".conversation-list",L.context).get(0),[T])}if(T.pageinfo){K.updatePageNumber(T.pageinfo.pagenumber||1);if(L.pagination&&typeof L.pagination.updatePageInfo=="function"){L.pagination.updatePageInfo(T.pageinfo,true)}}if(vBulletin.inlinemod&&typeof vBulletin.inlinemod.init=="function"&&A(".moderationmenu_container",L.context).length>0){vBulletin.inlinemod.init(L.context)}}if(G){G=false}},error:function(V,U,T){console.log("/activity/get failed. error:"+T);if(T!=""){openAlertDialog({title:vBulletin.phrase.get("error"),message:vBulletin.phrase.get("unable_to_contact_server_please_try_again"),iconType:"error"})}},complete:function(){A(".conversation-toolbar-wrapper",L.context).removeClass("disabled");A(".conversation-empty",L.context).removeClass("invisible");if(!G&&L.autoCheck&&D){D=setTimeout(K.checkNewConversations,L.checkInterval)}}});return K};this.updatePageNumber=function(M){M=Number(M);if(M>0){A('form.toolbar-filter-overlay input[name="pagenum"]',L.context).val(M)}return K};this.checkNewConversations=function(){if(!A("body").hasClass("edit-mode")){console.log("Checking for new activity since "+C);K.applyFilters(true)}return K};this.toggleNewConversations=function(M){if(M){L.autoCheck=true;D=setTimeout(K.checkNewConversations,L.checkInterval)}else{L.autoCheck=false;clearTimeout(D)}return K};this.hideFilterOverlay=function(){A(".conversation-toolbar-wrapper .toolbar-filter-overlay",L.context).filter(":visible").each(function(){A(this).prev(".conversation-toolbar").find(".toolbar-filter").triggerHandler("click."+F,[0])});return K};this.getOption=function(M){return L[M]};this.setOption=function(M,N){L[M]=N;return K};if(L.autoCheck){C=pageData.current_server_datetime;D=setTimeout(K.checkNewConversations,L.checkInterval)}}})(jQuery);