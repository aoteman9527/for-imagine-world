window.vBulletin=window.vBulletin||{};window.vBulletin.phrase=window.vBulletin.phrase||{};window.vBulletin.phrase.precache=window.vBulletin.phrase.precache||[];window.vBulletin.phrase.precache=$.merge(window.vBulletin.phrase.precache,["vote_failed","vote_now","votes"]);window.vBulletin.options=window.vBulletin.options||{};window.vBulletin.options.precache=window.vBulletin.options.precache||[];window.vBulletin.options.precache=$.merge(window.vBulletin.options.precache,["maxpolloptions"]);(function(A){A(document).ready(function(){function E(I){var H=window.vBulletin.options.get("maxpolloptions"),G=(H>3)?3:H;I.off("click",'[name="viewpollresults"]').on("click",'[name="viewpollresults"]',function(L){L.preventDefault();var K=A(this).attr("data-nodeid"),J=A(this).closest("form");A.get(vBulletin.getAjaxBaseurl()+"/poll/get",{nodeid:K},function(M){B(J,M)},"json")});I.off("click",'[name="backtopoll"]').on("click",'[name="backtopoll"]',function(K){K.preventDefault();var J=A(this).parents(".list-item-body").eq(0);J.find("div.pollresults").addClass("hide");J.find("form.poll").show()});I.off("click","a#addanswer").on("click","a#addanswer",function(K){var L=A(".polloptioncontainer:first").clone(),J=A(".polloptioncontainer:not(:hidden)",I).length;L.css("display","table").find("input").attr("name","polloptions[new][]").val("").placeholder().prop("disabled",false);A(this).prev(".polloption-list").append(L.css("display","")).find(".polloptioncontainer:last input").focus();if(J+1==H){A(this).hide()}return false});I.off("click",".polloptioncontainer button.remove").on("click",".polloptioncontainer button.remove",function(){var J=A(".polloptioncontainer:not(:hidden)",I).length;A(this).closest(".polloptioncontainer").remove();A("a#addanswer",I).show();return false});I.off("click",".pollsettings .timeout input").on("click",".pollsettings .timeout input",function(J){A(this).closest(".polloptions-container").next(".datepickercontainer")[this.checked?"removeClass":"addClass"]("hide")});I.off("submit.formpoll","form.poll").on("submit.formpoll","form.poll",function(M){M.preventDefault();var J=A(this);var L=J.find('[name="polloptionid"]:checked').val();var K=[];J.find('[name="polloptionids[]"]:checked').each(function(){K.push(A(this).val())});A.post(vBulletin.normalizeAjaxUrl(J.attr("action")),{polloptionid:L,"polloptionids[]":K},function(O){if(O==false){openAlertDialog({title:vBulletin.phrase.get("vote_now"),message:vBulletin.phrase.get("vote_failed"),iconType:"warning"})}else{B(J,O);var N=J.parent();A("div.pollresults",N).find('[name="backtopoll"]').remove()}},"json")});A(document).off("click",".pollresults-data .voter-icon").on("click",".pollresults-data .voter-icon",function(){var J=A(this);if(J.find(".voters").is(":visible")){return false}A(".pollresults-data tr td.pollvoter-cell .voter-icon .voters").hide();var M=J.attr("data-node-id");var L=J.attr("data-polloption-id");var K=J.closest("form");A.get(vBulletin.getAjaxBaseurl()+"/poll/get-voters",{nodeid:M,polloptionid:L},function(N){if(N){if(!N.error){C(K,N,L,J)}else{D({message:N.error,type:"error"},J)}}else{D({message:"Error retrieving voters.",type:"error"},J)}},"json")});A(document).off("click",".pollresults-data .voter-icon .voters").on("click",".pollresults-data .voter-icon .voters",function(){e.stopPropagation();return true});if(A(".polloptioncontainer.new",I).length>0){for(var F=0;F<G-1;F++){A("a#addanswer",I).click()}if(G==H){A("a#addanswer",I).hide()}}}vBulletin.conversation.bindEditFormEventHandlers("poll");function D(H,G){var I=G.find(".voters");if(H.message){var F=A("<span />").addClass(H.type).text(H.message);I.html(F)}else{I.html(H.voters)}I.fadeIn("slow");A("body").on("click.voterpopup",function(J){if(A(J.target).closest(".voter-icon").length==0){I.hide();A("body").off("click.voterpopup")}})}function C(F,H,K,I){var M=false;if(H.options){B(F,H);var J=H.options[K];if(J){M=true;if(!A.isEmptyObject(J.votersinfo)){var L=[];for(var G in J.votersinfo){L.push('<a href="{0}">{1}</a>'.format(pageData.baseurl+J.votersinfo[G].profileUrl,J.votersinfo[G].username))}D({voters:L.join(", ")},I)}else{D({message:"No one has voted for this option yet. Be the first one to vote.",type:"note"},I)}}}if(!M){D({message:"Error retrieving voters.",type:"error"},I)}}function B(G,K){var F=G.parent();var H=K.options;for(var I in H){var J=A(".pollresults-option-"+H[I].polloptionid);J.find(".title").html(JShtmlEncode(H[I].title));J.find(".bar-container .bar").css("width",H[I].percentage+"%");J.find(".percentage").html(H[I].percentage+"%");J.find(".votes span").html(H[I].votes);if(H[I].votes>1){J.find(".votes label").html(vBulletin.phrase.get("votes"))}}A(".pollresults .pollvote-count span",F).html(K.poll_votes);if(K.poll_votes>1){A(".pollresults .pollvote-count label",F).html(vBulletin.phrase.get("votes"))}G.hide();A("div.pollresults",F).removeClass("hide")}E(A("body"))})})(jQuery);