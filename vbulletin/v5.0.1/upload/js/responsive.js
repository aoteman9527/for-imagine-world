var Responsive={bodyWidth:0,scrollToFixedBreakPoint:480};var $Rx=Responsive;$(function(){$(".blogAdminActive").click(function(A){$(this).parent().toggleClass("expanded")});Modernizr.addTest("firefox",function(){return !!navigator.userAgent.match(/firefox/i)});Modernizr.addTest("opera",function(){return !!navigator.userAgent.match(/opera/i)})});Responsive.DocReady={load:function(){$("#searchForm").addClass("desktopSearch");$Rx.ChannelTabBar.initMainMenu();$Rx.MediaQueries.setResizeEvent();$Rx.MediaQueries.handleResizeEvent();$Rx.ListToSelect.registerChangeEvents();$Rx.Footer.registerChangeEvents();$Rx.Profile.clonePrivateMessageButton();$Rx.ChannelContent.cloneNewTopicButton();$Rx.SocialGroups.cloneButtons();$Rx.Profile.cloneButtons();$Rx.Debug.wrap();$Rx.ConversationContent.checkForSignature();$Rx.Touch.override();setTimeout($Rx.ListToSelect.registerSyncMenuEvents,100)}};$(document).ready(function(){$Rx.DocReady.load()});Responsive.Touch={override:function(){var B="touch";if($("html").hasClass(B)){var F="no-touch";var E=navigator.userAgent.toLowerCase();var A="Firefox".toLowerCase();var D=E.indexOf(A);var G="Windows NT 6.1".toLowerCase();var C=E.indexOf(G);if(D!==-1&&C!==-1){$("html").removeClass(B).addClass(F)}}}};Responsive.Modal={init:function(){if($(".sgIconUploader").length){var B=["ui-dialog","ui-widget","ui-widget-content","ui-corner-all","ui-draggable","ui-resizable"];var A="body div."+B.join(".");if(!$(A).hasClass("rx-modal")){$(A).addClass("rx-modal")}}setTimeout(this.setRadioState,100)},setRadioState:function(){$("input:radio[name=sgIconToggle]:visible:first").click()}};Responsive.Debug={wrap:function(){var B="debug-information";var A="debug-information-wrapper";if($("#"+B).length&&!$("#"+A).length){$("#"+B).wrap('<div id="'+A+'" />')}}};Responsive.ListToSelect={handleSelectChangeHome:function(){var C=$("div.activity-stream-widget > .widget-header > .module-title.left > select").get(0);var B=C.selectedIndex;var A="div.activity-stream-widget > .widget-header > .module-title.left > ul [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeProfileSubscriptions:function(){var C=$(".subscriptionsContainer > .subscribeTabs > div.widget-tabs-nav > select").get(0);var B=C.selectedIndex;var A=".subscriptionsContainer > .subscribeTabs > ul.widget-tabs-nav [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeForum:function(){var C=$("div.channel-content-widget > .widget-content > .channel-conversation-list-wrapper > .widget-tabs-nav > select").get(0);var B=C.selectedIndex;var A="div.channel-content-widget > .widget-content > .channel-conversation-list-wrapper > .widget-tabs-nav > ul.ui-tabs-nav [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeForumElse:function(){var C=$("div.channel-content-widget > .widget-header > .module-title.left > select").get(0);var B=C.selectedIndex;var A="div.channel-content-widget > .widget-header > .module-title.left > ul [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeBlog:function(){var C=$("div.blog-channel-content-widget > .widget-content > .channel-conversation-list-wrapper > select").get(0);var B=C.selectedIndex;var A="div.blog-channel-content-widget > .widget-content > .channel-conversation-list-wrapper > .widget-tabs-nav > ul.ui-tabs-nav [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeBlogElse:function(){var C=$("div.blog-channel-content-widget > .widget-header > .module-title.left > select").get(0);var B=C.selectedIndex;var A="div.blog-channel-content-widget > .widget-header > .module-title.left > ul [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeBlogNewEntry:function(){var C=$("div.blog-channel-content-widget > .channel-conversation-list-wrapper > .widget-tabs-nav > select").get(0);var B=C.selectedIndex;var A="div.blog-channel-content-widget > .channel-conversation-list-wrapper > .widget-tabs-nav > ul [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},handleSelectChangeProfile:function(){var C=$("div.profile-widget > .widget-content > .profile-container > .widget-tabs > .widget-tabs-nav > select").get(0);var B=C.selectedIndex;var A="div.profile-widget > .widget-content > .profile-container > .widget-tabs > ul [href="+C.options[B].value+"]";$Rx.ListToSelect.selectTab(A)},selectTab:function(A){$(A).click()},registerChangeEvents:function(){this.registerSelectChangeHome();this.registerSelectChangeForum();this.registerSelectChangeForumElse();this.registerSelectChangeBlog();this.registerSelectChangeBlogElse();this.registerSelectChangeBlogNewEntry();this.registerSelectChangeProfile();this.registerSelectChangeProfileSubscriptions()},registerSelectChangeHome:function(){$("div.activity-stream-widget > .widget-header > .module-title.left > select").on("change",this.handleSelectChangeHome)},registerSelectChangeForum:function(){$("div.channel-content-widget > .widget-content > .channel-conversation-list-wrapper > .widget-tabs-nav > select").on("change",this.handleSelectChangeForum)},registerSelectChangeForumElse:function(){$("div.channel-content-widget > .widget-header > .module-title.left > select").on("change",this.handleSelectChangeForumElse)},registerSelectChangeBlog:function(){$("div.blog-channel-content-widget > .widget-content > .channel-conversation-list-wrapper > select").on("change",this.handleSelectChangeBlog)},registerSelectChangeBlogElse:function(){$("div.blog-channel-content-widget > .widget-header > .module-title.left > select").on("change",this.handleSelectChangeBlogElse)},registerSelectChangeBlogNewEntry:function(){$("div.blog-channel-content-widget > .channel-conversation-list-wrapper > .widget-tabs-nav > select").on("change",this.handleSelectChangeBlogNewEntry)},registerSelectChangeProfile:function(){$("div.profile-widget> .widget-content > .profile-container > .widget-tabs > .widget-tabs-nav > select").on("change",this.handleSelectChangeProfile)},registerSelectChangeProfileSubscriptions:function(){$(".subscriptionsContainer > .subscribeTabs > div.widget-tabs-nav > select").on("change",this.handleSelectChangeProfileSubscriptions)},tabSelected:function(D){var B=this;if(D.length){var A=D.first();var C=A.parent().parent();A.find("a").each(function(){B.setSelectedListItem(C,$(this).attr("href"))})}},setSelectedListItem:function(C,A){var B=C.children("select").length?C.children("select"):C.find("div.widget-header > select");B.each(function(){if($(this).find("option[value='"+A+"']")){$(this).find("option[value='"+A+"']").attr("selected","selected")}})},registerSyncMenuEvents:function(){$("ul.ui-tabs-nav > li.ui-state-default a").on("click",function(){$Rx.ListToSelect.tabSelected($(this).closest("li"))});$(".widget-tabs-nav ul.ui-tabs-nav li.ui-tabs-selected a").each(function(){$Rx.ListToSelect.tabSelected($(this).closest("li"))})}};Responsive.Facade={addFacadeControlToToolbar:function(I,F,D,J){var C=$(I);var A=$(F);var B=$(D);if(C.length&&!A.length&&B.length){var G=B[0];var H=$(G).clone();if(J){for(var E=0;E<J;E++){this.addClickEvent(H,existingButtonSet,J[E])}}else{this.addClickEvent(H,G)}C.append(H)}},addClickEvent:function(C,B,A){if(A){C.find(A).on("click",function(){B.find(A).click()})}else{C.on("click",function(){B.click()})}},addNewConversationToolbarToDOM:function(D,B){var C="#"+D+" .conversation-toolbar-wrapper .conversation-toolbar."+B;if(!$($(C)).length){var A='<div class="conversation-toolbar '+B+'"><ul class="toolset-left"><li></li></ul></div>';$("#"+D+" .conversation-toolbar-wrapper").prepend(A)}}};Responsive.Profile={styleSidebarContent:function(){$(".profile-info-item").removeClass()},clonePrivateMessageButton:function(){var C=".conversation-toolbar > ul > li > a.pm_button";var B=".profile_sidebar_content > .profileContainer";var A=".profile_sidebar_content > .profileContainer > div.pm-button-container > a.pm-button";if($(C).length){if($(B).length){if(!$(A).length){var E=$(C).clone();var D=$("<div class='pm-button-container'></div>").append(E);$(B).append(D)}}}},cloneButtons:function(){this.cloneTabButtons("subscription");this.cloneTabButtons("subscriber")},cloneTabButtons:function(D){var F=D+"sTab";var E=D+"s-totalcount";var A=$("#"+F+" .conversation-toolbar .toolset-left .back-button");var C=$("#"+F+" .conversation-toolbar");var B=$("#"+F+" .conversation-toolbar.rx-facade-back-to-profile");if(A.length&&!B.length){C.addClass("rx-desktop");$Rx.Facade.addNewConversationToolbarToDOM(F,"rx-facade-"+D+"-count");$Rx.Facade.addFacadeControlToToolbar("#"+F+" .conversation-toolbar.rx-facade-"+D+"-count ul.toolset-left li","#"+F+" .conversation-toolbar.rx-facade-"+D+"-count ul.toolset-left li ."+E,"#"+F+" .conversation-toolbar .toolset-left ."+E);$Rx.Facade.addNewConversationToolbarToDOM(F,"rx-facade-back-to-profile");$Rx.Facade.addFacadeControlToToolbar("#"+F+" .conversation-toolbar.rx-facade-back-to-profile ul.toolset-left li","#"+F+" .conversation-toolbar.rx-facade-back-to-profile ul.toolset-left li .back-button","#"+F+" .conversation-toolbar .toolset-left .back-button");$Rx.Facade.addFacadeControlToToolbar("#"+F+" .conversation-toolbar.rx-facade-"+D+"-count ul.toolset-left li","#"+F+" .conversation-toolbar.rx-facade-back-to-profile ul.toolset-left li .rx-ignore","#"+F+" .conversation-toolbar .toolset-left .rx-ignore")}},};Responsive.ChannelContent={cloneNewTopicButton:function(){var C="#activity-stream-tab .conversation-toolbar .toolset-left button.new-conversation-btn";var B=".channel-content-widget .channel-controls";var A=".channel-content-widget .channel-controls > button.new-conversation-btn";if($(C).length){if($(B).length){if(!$(A).length){var D=$(C).clone();D.attr("id","rx-facade-new-conversation-btn");D.on("click",function(){$(C).click()});$(B).append(D)}}}}};Responsive.SocialGroups={cloneButtons:function(){if($("#groups-tab .conversation-toolbar .toolset-left div.button-set").length){$Rx.Facade.addNewConversationToolbarToDOM("groups-tab","rx-facade-show-groups");$Rx.Facade.addFacadeControlToToolbar("#groups-tab .conversation-toolbar.rx-facade-show-groups ul.toolset-left li","#groups-tab .conversation-toolbar.rx-facade-show-groups ul.toolset-left li div.button-set","#groups-tab .conversation-toolbar .toolset-left div.button-set",["button.showAll","button.showMy"]);$Rx.Facade.addNewConversationToolbarToDOM("groups-tab","rx-facade-create-groups");$Rx.Facade.addFacadeControlToToolbar("#groups-tab .conversation-toolbar.rx-facade-create-groups ul.toolset-left li","#groups-tab .conversation-toolbar.rx-facade-create-groups ul.toolset-left li button.add-sg","#groups-tab .conversation-toolbar .toolset-left button.add-sg")}}};Responsive.Search={cloneTagsLink:function(){if(!$("#rx-tags-column").length){var C=$(".form-row-tags");var A=$(".form-row-tags > .field_column");var D=$(".tag-editor-wrapper > span.add-tag-link");var B=D.clone();B.on("click",function(){$(".tag-editor-wrapper > span.add-tag-link").click()});A.css("display","block");D.css("display","none");C.append("<div id='rx-tags-column' class='field_column'></div>");B.appendTo($("#rx-tags-column"))}}};Responsive.Footer={menuItemCount:0,menuItemCountLimit:5,handleSelectChange:function(){var C=$("li.rx-list-to-select > select").get(0);var B=C.selectedIndex;var A=C.options[B].value;if(A!==""){window.location=A}},registerChangeEvents:function(){this.setMenuItemCount();this.setMenuClasses();this.registerSelectChange()},setMenuClasses:function(){if($Rx.Footer.menuItemCount>$Rx.Footer.menuItemCountLimit){$("#footer-tabbar > ul.right").addClass("rx-menu-limit-exceeded");$("#footer-tabbar > ul.left > li.rx-list-to-select").addClass("rx-menu-limit-exceeded")}else{$("#footer-tabbar > ul.right").addClass("rx-menu-limit-ok");$("#footer-tabbar > ul.left > li.rx-list-to-select").addClass("rx-menu-limit-ok")}},setMenuItemCount:function(){$Rx.Footer.menuItemCount=$("#footer-tabbar > ul.right > li").length},registerSelectChange:function(){$("li.rx-list-to-select > select").on("change",this.handleSelectChange)}};Responsive.MediaQueries={init:function(){$Rx.bodyWidth=$("#vb-page-body").width()},setResizeEvent:function(){var A=this.handleResizeEvent;$(window).resize(function(){A()})},handleResizeEvent:function(){if($("#vb-page-body").width()!=$Rx.bodyWidth){$Rx.bodyWidth=$("#vb-page-body").width();if(Modernizr.mq("only screen and (max-width: 479px)")){window.vBulletin.scrollToFixed();$(".private-message-widget-layout .section-0").insertAfter(".private-message-widget-layout .section-1")}if(Modernizr.mq("only screen and (min-width: 480px)")){$(".private-message-widget-layout .section-1").insertAfter(".private-message-widget-layout .section-0")}if(Modernizr.mq("only screen and (max-width: 599px)")){$("#pmFloatingBarContent .toolset.left").detach().prependTo("#privateMessageContainer").addClass("clearfix")}if(Modernizr.mq("only screen and (min-width: 600px)")){$("#privateMessageContainer .toolset.left").detach().prependTo("#pmFloatingBarContent").removeClass("clearfix")}if(Modernizr.mq("only screen and (max-width: 990px)")){var A=$Rx.ConversationToolbar.selector;if($(A).length&&$(A+".mobile-search").length===0){$Rx.ConversationToolbar.createMobileView()}}if(Modernizr.mq("only screen and (max-width: 767px)")){if(!$Rx.ChannelTabBar.isMobileMenu){$Rx.ChannelTabBar.showMobileSearchForm()}$Rx.ChannelTabBar.create();$("#mobile-main-menu").css("display","block");$Rx.Search.cloneTagsLink();$Rx.Profile.styleSidebarContent()}if(Modernizr.mq("only screen and (min-width: 768px)")){if($Rx.ChannelTabBar.isMobileMenu){$Rx.ChannelTabBar.showDesktopSearchForm()}$("#mobile-main-menu").css("display","none")}if(Modernizr.mq("only screen and (max-width: 479px)")){$Rx.Debug.wrap()}}}};Responsive.ChannelTabBar={sectionItemsSelector:"#channel-tabbar ul li.section-item",initMainMenu:function(){$("#mobile-main-menu").each(function(){$(this).find(".main-menu-control-sections").on("click",function(){$Rx.ChannelTabBar.toggle("sections")});$(this).find(".mobile-search span").on("click",function(){$Rx.ChannelTabBar.toggle("search")})})},isMobileMenu:false,getMobileSearchForm:function(){var B=$("form.desktopSearch").attr("action");var A='<form method="get" class="right mobile mobileSearch" action="'+B+'" id="searchForm"><fieldset><div class="search-inputs"><input type="text" autocomplete="off" class="textbox search-term" placeholder="Search..." id="q" name="q"></div></fieldset></form>';return A},showMobileSearchForm:function(){var C=$("form.mobileSearch");var B=$("form.desktopSearch");var A=$("form.mobileSearch input.search-term");var D=$("form.desktopSearch input.search-term");if(C.length){C.attr("id","searchForm");A.attr("id","q")}if(B.length){B.attr("id","searchFormDesktop");D.attr("id","qDesktop")}this.showCollapsed();$Rx.ChannelTabBar.isMobileMenu=true},showDesktopSearchForm:function(){var C=$("form.mobileSearch");var B=$("form.desktopSearch");var A=$("form.mobileSearch input.search-term");var D=$("form.desktopSearch input.search-term");if(C.length){C.attr("id","searchFormMobile");A.attr("id","qMobile")}if(B.length){B.attr("id","searchForm");D.attr("id","q")}this.showExpanded();$Rx.ChannelTabBar.isMobileMenu=false},create:function(){if(!$("form.mobileSearch").length){var A=this.getMobileSearchForm();$("#mobile-main-menu-search").append(A);this.showMobileSearchForm();$($Rx.ChannelTabBar.sectionItemsSelector).each(function(){var B=$(this).find("a").attr("href");$(this).click(function(){window.location=B})})}},toggle:function(F){if(F==="search"){var D=$("#mobile-main-menu-search");var E=$("#mobile-main-menu-sections");if(D.css("display")==="none"){E.css("display","none");D.css("display","inline-block")}else{var G=$("#mobile-main-menu-search input");var C=$(G[0]).val();if(C!==""){var A=$("#mobile-main-menu-search form");A[0].submit()}else{D.css("display","none");E.css("display","inline-block")}}}else{if(F==="sections"){var B=$($Rx.ChannelTabBar.sectionItemsSelector);if(B.length){if(B.eq(0).css("display")==="none"){this.showExpanded()}else{this.showCollapsed()}}}}},showExpanded:function(){$($Rx.ChannelTabBar.sectionItemsSelector).css("display","block");this.removeCollapsedClass()},showCollapsed:function(){$($Rx.ChannelTabBar.sectionItemsSelector).css("display","none");this.addCollapsedClass()},removeCollapsedClass:function(){$("#mobile-main-menu-sections div.main-menu-control-sections").removeClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-menu-icon span.icon").removeClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-icon .icon").removeClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-title").removeClass("collapsed")},addCollapsedClass:function(){$("#mobile-main-menu-sections div.main-menu-control-sections").addClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-menu-icon .icon").addClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-icon .icon").addClass("collapsed");$("#mobile-main-menu-sections div.main-menu-control-sections .sections-title").addClass("collapsed")}};Responsive.ConversationContent={checkForSignature:function(){$(".conversation-content .videoscontainer").each(function(){if(!$(this).siblings("div.post-signature").length){$(this).addClass("no-signature")}})}};Responsive.ConversationToolbar={selector:".conversation-view > .conversation-toolbar-wrapper > .conversation-toolbar",createMobileView:function(){var A=$Rx.ConversationToolbar.selector;var B=A+".desktop";var C=$(A);C.addClass("desktop");if($(B).find("button.post-reply-btn").length){$("<div>").addClass("conversation-toolbar mobile-search").insertAfter(C);this.copyElementsToMobileSearchToolbar()}},copyElementsToMobileSearchToolbar:function(){var D=$Rx.ConversationToolbar.selector;var B=D+".desktop";var L=D+".mobile-search";var F=$(B);var A=$(L);A.css("display","none");var E=F.find("button.post-reply-btn").clone(true,true).removeAttr("id");var K=$("<ul>").addClass("toolset-left");var H=$("<li>").addClass("post-buttonset split-button");var I=$("<div>").addClass("split-button-wrapper button primary light");var J=$("<div>").addClass("button-set left");J.append(E);I.append(J);H.append(I);K.append(H);A.append(K);var C=$("<ul>").addClass("toolset-right");var G=F.find("li.toolbar-search").clone(true,true);G.find("button").removeAttr("id");C.append(G);A.append(C)}};