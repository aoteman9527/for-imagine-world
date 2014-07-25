<form id="postform" method="post" action="./posting.php?mode=post&amp;f=2&XDEBUG_SESSION_START=netbeans-xdebug" enctype="multipart/form-data">



<div class="panel" id="postingbox">
<div class="inner"><span class="corners-top"><span></span></span>

<h3>Post a new topic</h3>

<script type="text/javascript">
    // <![CDATA[
    onload_functions.push('apply_onkeypress_event()');
    // ]]>
</script>

<fieldset class="fields1">

<dl>
    <dt><label for="icon">Topic icon:</label></dt>
    <dd>
        <label for="icon"><input type="radio" name="icon" id="icon" value="0" checked="checked" tabindex="1"> None</label>
        <label for="icon-1"><input type="radio" name="icon" id="icon-1" value="1" tabindex="1"><img src="./images/icons/misc/fire.gif" width="16" height="16" alt="" title=""></label> <label for="icon-5"><input type="radio" name="icon" id="icon-5" value="5" tabindex="1"><img src="./images/icons/misc/star.gif" width="16" height="16" alt="" title=""></label> <label for="icon-6"><input type="radio" name="icon" id="icon-6" value="6" tabindex="1"><img src="./images/icons/misc/radioactive.gif" width="16" height="16" alt="" title=""></label> <label for="icon-4"><input type="radio" name="icon" id="icon-4" value="4" tabindex="1"><img src="./images/icons/misc/heart.gif" width="16" height="16" alt="" title=""></label> <label for="icon-7"><input type="radio" name="icon" id="icon-7" value="7" tabindex="1"><img src="./images/icons/misc/thinking.gif" width="16" height="16" alt="" title=""></label> <label for="icon-9"><input type="radio" name="icon" id="icon-9" value="9" tabindex="1"><img src="./images/icons/smile/question.gif" width="16" height="16" alt="" title=""></label> <label for="icon-10"><input type="radio" name="icon" id="icon-10" value="10" tabindex="1"><img src="./images/icons/smile/alert.gif" width="16" height="16" alt="" title=""></label> <label for="icon-8"><input type="radio" name="icon" id="icon-8" value="8" tabindex="1"><img src="./images/icons/smile/info.gif" width="16" height="16" alt="" title=""></label> <label for="icon-2"><input type="radio" name="icon" id="icon-2" value="2" tabindex="1"><img src="./images/icons/smile/redface.gif" width="16" height="16" alt="" title=""></label> <label for="icon-3"><input type="radio" name="icon" id="icon-3" value="3" tabindex="1"><img src="./images/icons/smile/mrgreen.gif" width="16" height="16" alt="" title=""></label>
    </dd>
</dl>

<dl style="clear: left;">
    <dt><label for="subject">Subject:</label></dt>
    <dd><input type="text" name="subject" id="subject" size="45" maxlength="60" tabindex="2" value="" class="inputbox autowidth"></dd>
</dl>
<script type="text/javascript">
    // <![CDATA[
    var form_name = 'postform';
    var text_name = 'message';
    var load_draft = false;
    var upload = false;

    // Define the bbCode tags
    var bbcode = new Array();
    var bbtags = new Array('[b]','[/b]','[i]','[/i]','[u]','[/u]','[quote]','[/quote]','[code]','[/code]','[list]','[/list]','[list=]','[/list]','[img]','[/img]','[url]','[/url]','[flash=]', '[/flash]','[size=]','[/size]');
    var imageTag = false;

    // Helpline messages
    var help_line = {
        b: 'Bold text: [b]text[/b]',
        i: 'Italic text: [i]text[/i]',
        u: 'Underline text: [u]text[/u]',
        q: 'Quote text: [quote]text[/quote]',
        c: 'Code display: [code]code[/code]',
        l: 'List: [list][*]text[/list]',
        o: 'Ordered list: e.g. [list=1][*]First point[/list] or [list=a][*]Point a[/list]',
        p: 'Insert image: [img]http://image_url[/img]',
        w: 'Insert URL: [url]http://url[/url] or [url=http://url]URL text[/url]',
        a: 'Inline uploaded attachment: [attachment=]filename.ext[/attachment]',
        s: 'Font colour: [color=red]text[/color]  Tip: you can also use color=#FF0000',
        f: 'Font size: [size=85]small text[/size]',
        y: 'List: Add list element',
        d: 'Flash: [flash=width,height]http://url[/flash]'

    }

    var panels = new Array('options-panel', 'attach-panel', 'poll-panel');
    var show_panel = 'options-panel';


    // ]]>
</script>
<script type="text/javascript" src="./styles/prosilver/template/editor.js"></script>


<div id="colour_palette" style="display: none;">
    <dl style="clear: left;">
        <dt><label>Font colour:</label></dt>
        <dd>
            <script type="text/javascript">
                // <![CDATA[
                function change_palette()
                {
                    dE('colour_palette');
                    e = document.getElementById('colour_palette');

                    if (e.style.display == 'block')
                    {
                        document.getElementById('bbpalette').value = 'Hide font colour';
                    }
                    else
                    {
                        document.getElementById('bbpalette').value = 'Font colour';
                    }
                }

                colorPalette('h', 15, 10);
                // ]]>
            </script><table cellspacing="1" cellpadding="0" border="0">
            <tbody><tr>
                <td bgcolor="#000000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#000000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#000000" title="#000000"></a></td>
                <td bgcolor="#000040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#000040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#000040" title="#000040"></a></td>
                <td bgcolor="#000080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#000080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#000080" title="#000080"></a></td>
                <td bgcolor="#0000BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0000BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0000BF" title="#0000BF"></a></td>
                <td bgcolor="#0000FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0000FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0000FF" title="#0000FF"></a></td>
                <td bgcolor="#004000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#004000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#004000" title="#004000"></a></td>
                <td bgcolor="#004040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#004040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#004040" title="#004040"></a></td>
                <td bgcolor="#004080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#004080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#004080" title="#004080"></a></td>
                <td bgcolor="#0040BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0040BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0040BF" title="#0040BF"></a></td>
                <td bgcolor="#0040FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0040FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0040FF" title="#0040FF"></a></td>
                <td bgcolor="#008000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#008000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#008000" title="#008000"></a></td>
                <td bgcolor="#008040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#008040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#008040" title="#008040"></a></td>
                <td bgcolor="#008080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#008080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#008080" title="#008080"></a></td>
                <td bgcolor="#0080BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0080BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0080BF" title="#0080BF"></a></td>
                <td bgcolor="#0080FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#0080FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#0080FF" title="#0080FF"></a></td>
                <td bgcolor="#00BF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00BF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00BF00" title="#00BF00"></a></td>
                <td bgcolor="#00BF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00BF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00BF40" title="#00BF40"></a></td>
                <td bgcolor="#00BF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00BF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00BF80" title="#00BF80"></a></td>
                <td bgcolor="#00BFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00BFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00BFBF" title="#00BFBF"></a></td>
                <td bgcolor="#00BFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00BFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00BFFF" title="#00BFFF"></a></td>
                <td bgcolor="#00FF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00FF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00FF00" title="#00FF00"></a></td>
                <td bgcolor="#00FF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00FF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00FF40" title="#00FF40"></a></td>
                <td bgcolor="#00FF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00FF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00FF80" title="#00FF80"></a></td>
                <td bgcolor="#00FFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00FFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00FFBF" title="#00FFBF"></a></td>
                <td bgcolor="#00FFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#00FFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#00FFFF" title="#00FFFF"></a></td>
            </tr>
            <tr>
                <td bgcolor="#400000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#400000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#400000" title="#400000"></a></td>
                <td bgcolor="#400040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#400040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#400040" title="#400040"></a></td>
                <td bgcolor="#400080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#400080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#400080" title="#400080"></a></td>
                <td bgcolor="#4000BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4000BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4000BF" title="#4000BF"></a></td>
                <td bgcolor="#4000FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4000FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4000FF" title="#4000FF"></a></td>
                <td bgcolor="#404000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#404000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#404000" title="#404000"></a></td>
                <td bgcolor="#404040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#404040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#404040" title="#404040"></a></td>
                <td bgcolor="#404080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#404080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#404080" title="#404080"></a></td>
                <td bgcolor="#4040BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4040BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4040BF" title="#4040BF"></a></td>
                <td bgcolor="#4040FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4040FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4040FF" title="#4040FF"></a></td>
                <td bgcolor="#408000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#408000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#408000" title="#408000"></a></td>
                <td bgcolor="#408040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#408040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#408040" title="#408040"></a></td>
                <td bgcolor="#408080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#408080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#408080" title="#408080"></a></td>
                <td bgcolor="#4080BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4080BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4080BF" title="#4080BF"></a></td>
                <td bgcolor="#4080FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#4080FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#4080FF" title="#4080FF"></a></td>
                <td bgcolor="#40BF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40BF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40BF00" title="#40BF00"></a></td>
                <td bgcolor="#40BF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40BF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40BF40" title="#40BF40"></a></td>
                <td bgcolor="#40BF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40BF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40BF80" title="#40BF80"></a></td>
                <td bgcolor="#40BFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40BFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40BFBF" title="#40BFBF"></a></td>
                <td bgcolor="#40BFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40BFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40BFFF" title="#40BFFF"></a></td>
                <td bgcolor="#40FF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40FF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40FF00" title="#40FF00"></a></td>
                <td bgcolor="#40FF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40FF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40FF40" title="#40FF40"></a></td>
                <td bgcolor="#40FF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40FF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40FF80" title="#40FF80"></a></td>
                <td bgcolor="#40FFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40FFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40FFBF" title="#40FFBF"></a></td>
                <td bgcolor="#40FFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#40FFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#40FFFF" title="#40FFFF"></a></td>
            </tr>
            <tr>
                <td bgcolor="#800000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#800000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#800000" title="#800000"></a></td>
                <td bgcolor="#800040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#800040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#800040" title="#800040"></a></td>
                <td bgcolor="#800080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#800080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#800080" title="#800080"></a></td>
                <td bgcolor="#8000BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8000BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8000BF" title="#8000BF"></a></td>
                <td bgcolor="#8000FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8000FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8000FF" title="#8000FF"></a></td>
                <td bgcolor="#804000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#804000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#804000" title="#804000"></a></td>
                <td bgcolor="#804040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#804040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#804040" title="#804040"></a></td>
                <td bgcolor="#804080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#804080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#804080" title="#804080"></a></td>
                <td bgcolor="#8040BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8040BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8040BF" title="#8040BF"></a></td>
                <td bgcolor="#8040FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8040FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8040FF" title="#8040FF"></a></td>
                <td bgcolor="#808000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#808000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#808000" title="#808000"></a></td>
                <td bgcolor="#808040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#808040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#808040" title="#808040"></a></td>
                <td bgcolor="#808080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#808080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#808080" title="#808080"></a></td>
                <td bgcolor="#8080BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8080BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8080BF" title="#8080BF"></a></td>
                <td bgcolor="#8080FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#8080FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#8080FF" title="#8080FF"></a></td>
                <td bgcolor="#80BF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80BF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80BF00" title="#80BF00"></a></td>
                <td bgcolor="#80BF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80BF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80BF40" title="#80BF40"></a></td>
                <td bgcolor="#80BF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80BF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80BF80" title="#80BF80"></a></td>
                <td bgcolor="#80BFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80BFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80BFBF" title="#80BFBF"></a></td>
                <td bgcolor="#80BFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80BFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80BFFF" title="#80BFFF"></a></td>
                <td bgcolor="#80FF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80FF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80FF00" title="#80FF00"></a></td>
                <td bgcolor="#80FF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80FF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80FF40" title="#80FF40"></a></td>
                <td bgcolor="#80FF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80FF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80FF80" title="#80FF80"></a></td>
                <td bgcolor="#80FFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80FFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80FFBF" title="#80FFBF"></a></td>
                <td bgcolor="#80FFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#80FFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#80FFFF" title="#80FFFF"></a></td>
            </tr>
            <tr>
                <td bgcolor="#BF0000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF0000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF0000" title="#BF0000"></a></td>
                <td bgcolor="#BF0040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF0040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF0040" title="#BF0040"></a></td>
                <td bgcolor="#BF0080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF0080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF0080" title="#BF0080"></a></td>
                <td bgcolor="#BF00BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF00BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF00BF" title="#BF00BF"></a></td>
                <td bgcolor="#BF00FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF00FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF00FF" title="#BF00FF"></a></td>
                <td bgcolor="#BF4000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF4000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF4000" title="#BF4000"></a></td>
                <td bgcolor="#BF4040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF4040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF4040" title="#BF4040"></a></td>
                <td bgcolor="#BF4080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF4080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF4080" title="#BF4080"></a></td>
                <td bgcolor="#BF40BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF40BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF40BF" title="#BF40BF"></a></td>
                <td bgcolor="#BF40FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF40FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF40FF" title="#BF40FF"></a></td>
                <td bgcolor="#BF8000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF8000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF8000" title="#BF8000"></a></td>
                <td bgcolor="#BF8040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF8040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF8040" title="#BF8040"></a></td>
                <td bgcolor="#BF8080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF8080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF8080" title="#BF8080"></a></td>
                <td bgcolor="#BF80BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF80BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF80BF" title="#BF80BF"></a></td>
                <td bgcolor="#BF80FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BF80FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BF80FF" title="#BF80FF"></a></td>
                <td bgcolor="#BFBF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFBF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFBF00" title="#BFBF00"></a></td>
                <td bgcolor="#BFBF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFBF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFBF40" title="#BFBF40"></a></td>
                <td bgcolor="#BFBF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFBF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFBF80" title="#BFBF80"></a></td>
                <td bgcolor="#BFBFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFBFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFBFBF" title="#BFBFBF"></a></td>
                <td bgcolor="#BFBFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFBFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFBFFF" title="#BFBFFF"></a></td>
                <td bgcolor="#BFFF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFFF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFFF00" title="#BFFF00"></a></td>
                <td bgcolor="#BFFF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFFF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFFF40" title="#BFFF40"></a></td>
                <td bgcolor="#BFFF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFFF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFFF80" title="#BFFF80"></a></td>
                <td bgcolor="#BFFFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFFFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFFFBF" title="#BFFFBF"></a></td>
                <td bgcolor="#BFFFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#BFFFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#BFFFFF" title="#BFFFFF"></a></td>
            </tr>
            <tr>
                <td bgcolor="#FF0000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF0000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF0000" title="#FF0000"></a></td>
                <td bgcolor="#FF0040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF0040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF0040" title="#FF0040"></a></td>
                <td bgcolor="#FF0080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF0080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF0080" title="#FF0080"></a></td>
                <td bgcolor="#FF00BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF00BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF00BF" title="#FF00BF"></a></td>
                <td bgcolor="#FF00FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF00FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF00FF" title="#FF00FF"></a></td>
                <td bgcolor="#FF4000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF4000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF4000" title="#FF4000"></a></td>
                <td bgcolor="#FF4040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF4040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF4040" title="#FF4040"></a></td>
                <td bgcolor="#FF4080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF4080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF4080" title="#FF4080"></a></td>
                <td bgcolor="#FF40BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF40BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF40BF" title="#FF40BF"></a></td>
                <td bgcolor="#FF40FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF40FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF40FF" title="#FF40FF"></a></td>
                <td bgcolor="#FF8000" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF8000]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF8000" title="#FF8000"></a></td>
                <td bgcolor="#FF8040" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF8040]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF8040" title="#FF8040"></a></td>
                <td bgcolor="#FF8080" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF8080]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF8080" title="#FF8080"></a></td>
                <td bgcolor="#FF80BF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF80BF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF80BF" title="#FF80BF"></a></td>
                <td bgcolor="#FF80FF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FF80FF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FF80FF" title="#FF80FF"></a></td>
                <td bgcolor="#FFBF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFBF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFBF00" title="#FFBF00"></a></td>
                <td bgcolor="#FFBF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFBF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFBF40" title="#FFBF40"></a></td>
                <td bgcolor="#FFBF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFBF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFBF80" title="#FFBF80"></a></td>
                <td bgcolor="#FFBFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFBFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFBFBF" title="#FFBFBF"></a></td>
                <td bgcolor="#FFBFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFBFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFBFFF" title="#FFBFFF"></a></td>
                <td bgcolor="#FFFF00" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFFF00]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFFF00" title="#FFFF00"></a></td>
                <td bgcolor="#FFFF40" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFFF40]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFFF40" title="#FFFF40"></a></td>
                <td bgcolor="#FFFF80" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFFF80]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFFF80" title="#FFFF80"></a></td>
                <td bgcolor="#FFFFBF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFFFBF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFFFBF" title="#FFFFBF"></a></td>
                <td bgcolor="#FFFFFF" style="width: 15px; height: 10px;"><a href="#" onclick="bbfontstyle('[color=#FFFFFF]', '[/color]'); return false;"><img src="images/spacer.gif" width="15" height="10" alt="#FFFFFF" title="#FFFFFF"></a></td>
            </tr>
            </tbody></table>

        </dd>
    </dl>
</div>

<div id="format-buttons">
    <input type="button" class="button2" accesskey="b" name="addbbcode0" value=" B " style="font-weight:bold; width: 30px" onclick="bbstyle(0)" title="Bold text: [b]text[/b]">
    <input type="button" class="button2" accesskey="i" name="addbbcode2" value=" i " style="font-style:italic; width: 30px" onclick="bbstyle(2)" title="Italic text: [i]text[/i]">
    <input type="button" class="button2" accesskey="u" name="addbbcode4" value=" u " style="text-decoration: underline; width: 30px" onclick="bbstyle(4)" title="Underline text: [u]text[/u]">

    <input type="button" class="button2" accesskey="q" name="addbbcode6" value="Quote" style="width: 50px" onclick="bbstyle(6)" title="Quote text: [quote]text[/quote]">

    <input type="button" class="button2" accesskey="c" name="addbbcode8" value="Code" style="width: 40px" onclick="bbstyle(8)" title="Code display: [code]code[/code]">
    <input type="button" class="button2" accesskey="l" name="addbbcode10" value="List" style="width: 40px" onclick="bbstyle(10)" title="List: [list][*]text[/list]">
    <input type="button" class="button2" accesskey="o" name="addbbcode12" value="List=" style="width: 40px" onclick="bbstyle(12)" title="Ordered list: e.g. [list=1][*]First point[/list] or [list=a][*]Point a[/list]">
    <input type="button" class="button2" accesskey="y" name="addlistitem" value="[*]" style="width: 40px" onclick="bbstyle(-1)" title="List item: [*]text">

    <input type="button" class="button2" accesskey="p" name="addbbcode14" value="Img" style="width: 40px" onclick="bbstyle(14)" title="Insert image: [img]http://image_url[/img]">

    <input type="button" class="button2" accesskey="w" name="addbbcode16" value="URL" style="text-decoration: underline; width: 40px" onclick="bbstyle(16)" title="Insert URL: [url]http://url[/url] or [url=http://url]URL text[/url]">

    <select name="addbbcode20" onchange="bbfontstyle('[size=' + this.form.addbbcode20.options[this.form.addbbcode20.selectedIndex].value + ']', '[/size]');this.form.addbbcode20.selectedIndex = 2;" title="Font size: [size=85]small text[/size]">
        <option value="50">Tiny</option>
        <option value="85">Small</option>
        <option value="100" selected="selected">Normal</option>

        <option value="150">Large</option>

        <option value="200">Huge</option>

    </select>
    <input type="button" class="button2" name="bbpalette" id="bbpalette" value="Font colour" onclick="change_palette();" title="Font colour: [color=red]text[/color]  Tip: you can also use color=#FF0000">

</div>


<div id="smiley-box">

    <strong>Smilies</strong><br>

    <a href="#" onclick="insert_text(':D', true); return false;"><img src="./images/smilies/icon_e_biggrin.gif" width="15" height="17" alt=":D" title="Very Happy"></a>

    <a href="#" onclick="insert_text(':)', true); return false;"><img src="./images/smilies/icon_e_smile.gif" width="15" height="17" alt=":)" title="Smile"></a>

    <a href="#" onclick="insert_text(';)', true); return false;"><img src="./images/smilies/icon_e_wink.gif" width="15" height="17" alt=";)" title="Wink"></a>

    <a href="#" onclick="insert_text(':(', true); return false;"><img src="./images/smilies/icon_e_sad.gif" width="15" height="17" alt=":(" title="Sad"></a>

    <a href="#" onclick="insert_text(':o', true); return false;"><img src="./images/smilies/icon_e_surprised.gif" width="15" height="17" alt=":o" title="Surprised"></a>

    <a href="#" onclick="insert_text(':shock:', true); return false;"><img src="./images/smilies/icon_eek.gif" width="15" height="17" alt=":shock:" title="Shocked"></a>

    <a href="#" onclick="insert_text(':?', true); return false;"><img src="./images/smilies/icon_e_confused.gif" width="15" height="17" alt=":?" title="Confused"></a>

    <a href="#" onclick="insert_text('8-)', true); return false;"><img src="./images/smilies/icon_cool.gif" width="15" height="17" alt="8-)" title="Cool"></a>

    <a href="#" onclick="insert_text(':lol:', true); return false;"><img src="./images/smilies/icon_lol.gif" width="15" height="17" alt=":lol:" title="Laughing"></a>

    <a href="#" onclick="insert_text(':x', true); return false;"><img src="./images/smilies/icon_mad.gif" width="15" height="17" alt=":x" title="Mad"></a>

    <a href="#" onclick="insert_text(':P', true); return false;"><img src="./images/smilies/icon_razz.gif" width="15" height="17" alt=":P" title="Razz"></a>

    <a href="#" onclick="insert_text(':oops:', true); return false;"><img src="./images/smilies/icon_redface.gif" width="15" height="17" alt=":oops:" title="Embarrassed"></a>

    <a href="#" onclick="insert_text(':cry:', true); return false;"><img src="./images/smilies/icon_cry.gif" width="15" height="17" alt=":cry:" title="Crying or Very Sad"></a>

    <a href="#" onclick="insert_text(':evil:', true); return false;"><img src="./images/smilies/icon_evil.gif" width="15" height="17" alt=":evil:" title="Evil or Very Mad"></a>

    <a href="#" onclick="insert_text(':twisted:', true); return false;"><img src="./images/smilies/icon_twisted.gif" width="15" height="17" alt=":twisted:" title="Twisted Evil"></a>

    <a href="#" onclick="insert_text(':roll:', true); return false;"><img src="./images/smilies/icon_rolleyes.gif" width="15" height="17" alt=":roll:" title="Rolling Eyes"></a>

    <a href="#" onclick="insert_text(':!:', true); return false;"><img src="./images/smilies/icon_exclaim.gif" width="15" height="17" alt=":!:" title="Exclamation"></a>

    <a href="#" onclick="insert_text(':?:', true); return false;"><img src="./images/smilies/icon_question.gif" width="15" height="17" alt=":?:" title="Question"></a>

    <a href="#" onclick="insert_text(':idea:', true); return false;"><img src="./images/smilies/icon_idea.gif" width="15" height="17" alt=":idea:" title="Idea"></a>

    <a href="#" onclick="insert_text(':arrow:', true); return false;"><img src="./images/smilies/icon_arrow.gif" width="15" height="17" alt=":arrow:" title="Arrow"></a>

    <a href="#" onclick="insert_text(':|', true); return false;"><img src="./images/smilies/icon_neutral.gif" width="15" height="17" alt=":|" title="Neutral"></a>

    <a href="#" onclick="insert_text(':mrgreen:', true); return false;"><img src="./images/smilies/icon_mrgreen.gif" width="15" height="17" alt=":mrgreen:" title="Mr. Green"></a>

    <a href="#" onclick="insert_text(':geek:', true); return false;"><img src="./images/smilies/icon_e_geek.gif" width="17" height="17" alt=":geek:" title="Geek"></a>

    <a href="#" onclick="insert_text(':ugeek:', true); return false;"><img src="./images/smilies/icon_e_ugeek.gif" width="17" height="18" alt=":ugeek:" title="Uber Geek"></a>
    <hr>
    <a href="./faq.php?mode=bbcode">BBCode</a> is <em>ON</em><br>

    [img] is <em>ON</em><br>
    [flash] is <em>OFF</em><br>
    [url] is <em>ON</em><br>

    Smilies are <em>ON</em>

</div>

<div id="message-box">
    <textarea name="message" id="message" rows="15" cols="76" tabindex="4" onselect="storeCaret(this);" onclick="storeCaret(this);" onkeyup="storeCaret(this);" onfocus="initInsertions();" class="inputbox"></textarea>
</div>
</fieldset>


<span class="corners-bottom"><span></span></span></div>
</div>

<div class="panel bg2">
    <div class="inner"><span class="corners-top"><span></span></span>
        <fieldset class="submit-buttons">

            <input type="hidden" name="lastclick" value="1406264489">
            <input type="submit" accesskey="k" tabindex="7" name="save" value="Save draft" class="button2">&nbsp;
            <input type="submit" tabindex="5" name="preview" value="Preview" class="button1" onclick="document.getElementById('postform').action += '#preview';">&nbsp;
            <input type="submit" accesskey="s" tabindex="6" name="post" value="Submit" class="button1 default-submit-action">&nbsp;

        </fieldset>

        <span class="corners-bottom"><span></span></span></div>
</div>

<div id="tabs">
    <ul>
        <li id="options-panel-tab" class="activetab"><a href="#tabs" onclick="subPanels('options-panel'); return false;"><span>Options</span></a></li>
        <li id="attach-panel-tab" class=""><a href="#tabs" onclick="subPanels('attach-panel'); return false;"><span>Upload attachment</span></a></li><li id="poll-panel-tab" class=""><a href="#tabs" onclick="subPanels('poll-panel'); return false;"><span>Poll creation</span></a></li>
    </ul>
</div>

<div class="panel bg3" id="options-panel" style="display: block;">
    <div class="inner"><span class="corners-top"><span></span></span>

        <fieldset class="fields1">

            <div><label for="disable_bbcode"><input type="checkbox" name="disable_bbcode" id="disable_bbcode"> Disable BBCode</label></div>

            <div><label for="disable_smilies"><input type="checkbox" name="disable_smilies" id="disable_smilies"> Disable smilies</label></div>

            <div><label for="disable_magic_url"><input type="checkbox" name="disable_magic_url" id="disable_magic_url"> Do not automatically parse URLs</label></div>

            <div><label for="attach_sig"><input type="checkbox" name="attach_sig" id="attach_sig" checked="checked"> Attach a signature (signatures can be altered via the UCP)</label></div>

            <div><label for="notify"><input type="checkbox" name="notify" id="notify"> Notify me when a reply is posted</label></div>

        </fieldset>
        <?php
            define('IN_PHPBB', true);
            $phpbb_root_path = (defined('PHPBB_ROOT_PATH')) ? PHPBB_ROOT_PATH : './';
            $phpEx = substr(strrchr(__FILE__, '.'), 1);
            include($phpbb_root_path . 'common.' . $phpEx);

            // Start session management
            $user->session_begin();
            $auth->acl($user->data);

            $now = time();
            $form_name="posting";
            $token_sid = ($user->data['user_id'] == ANONYMOUS && !empty($config['form_token_sid_guests'])) ? $user->session_id : '';
            $token = sha1($now . $user->data['user_form_salt'] . $form_name . $token_sid);

        ?>
        <input type="hidden" name="creation_time" value="<?php echo $now; ?>">
        <input type="hidden" name="form_token" value="<?php echo $token; ?>">

        <span class="corners-bottom"><span></span></span></div>
</div>

<div class="panel bg3" id="attach-panel" style="display: none;">
    <div class="inner"><span class="corners-top"><span></span></span>

        <p>If you wish to attach one or more files enter the details below.</p>

        <fieldset class="fields2">
            <dl>
                <dt><label for="fileupload">Filename:</label></dt>
                <dd>
                    <input type="file" name="fileupload" id="fileupload" maxlength="262144" value="" class="inputbox autowidth">
                    <input type="submit" name="add_file" value="Add the file" class="button2" onclick="upload = true;">
                </dd>
            </dl>
            <dl>
                <dt><label for="filecomment">File comment:</label></dt>
                <dd><textarea name="filecomment" id="filecomment" rows="1" cols="40" class="inputbox autowidth"></textarea></dd>
            </dl>
        </fieldset>

        <span class="corners-bottom"><span></span></span></div>
</div><div class="panel bg3" id="poll-panel" style="display: none;">
    <div class="inner"><span class="corners-top"><span></span></span>


        <p>If you do not want to add a poll to your topic leave the fields blank.</p>


        <fieldset class="fields2">

            <dl>
                <dt><label for="poll_title">Poll question:</label></dt>
                <dd><input type="text" name="poll_title" id="poll_title" maxlength="255" value="" class="inputbox"></dd>
            </dl>
            <dl>
                <dt><label for="poll_option_text">Poll options:</label><br><span>Place each option on a new line. You may enter up to <strong>10</strong> options.</span></dt>
                <dd><textarea name="poll_option_text" id="poll_option_text" rows="5" cols="35" class="inputbox"></textarea></dd>
            </dl>

            <hr class="dashed">

            <dl>
                <dt><label for="poll_max_options">Options per user:</label></dt>
                <dd><input type="text" name="poll_max_options" id="poll_max_options" size="3" maxlength="3" value="1" class="inputbox autowidth"></dd>
                <dd>This is the number of options each user may select when voting.</dd>
            </dl>
            <dl>
                <dt><label for="poll_length">Run poll for:</label></dt>
                <dd><label for="poll_length"><input type="text" name="poll_length" id="poll_length" size="3" maxlength="3" value="0" class="inputbox autowidth"> Days</label></dd>
                <dd>Enter 0 or leave blank for a never ending poll.</dd>
            </dl>


            <hr class="dashed">

            <dl>
                <dt><label for="poll_vote_change">Allow re-voting:</label></dt>
                <dd><label for="poll_vote_change"><input type="checkbox" id="poll_vote_change" name="poll_vote_change"> If enabled users are able to change their vote.</label></dd>
            </dl>

        </fieldset>

        <span class="corners-bottom"><span></span></span></div>
</div>

</form>