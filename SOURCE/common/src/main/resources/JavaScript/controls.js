function jjHelp(helpFieldName, msg) {
	document.getElementById(helpFieldName).value = msg;
}

function emoticon(fieldName,text) {
  field = document.getElementById(fieldName)
	field.value = field.value+text;
}

function jjPressed(fieldName, startTag,endTag) {
  field = document.getElementById(fieldName)
	field.value = field.value+startTag+" "+endTag;
}

