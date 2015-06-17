/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text
 * streams. Copyright (c) 2006 Alexander Hristov.
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 */
package org.jjcode.commands;


import java.util.HashMap;

import org.jjcode.Node;
import org.jjcode.RenderCommand;

/**
 * Handles the [size] command for changing the size of the font within the delimited region  <br/><br/>
 * <b>Syntax</b>: <code>[size=nn] large text [/size] </code> <br/></br>
 * <b>Example</b>:<code> [size=14] This text uses a 14 pt font [/size] <br/><br/></code>
 * <b>Contents</b>: The [size] command allows any kind of nested contents <br/><br/>
 * <b>Messages</b>:  <code><br/>
 * core.jjcodes.size<br/>
 * core.jjcodes.size.help<br/>
 * core.jjcodes.size.minuscule<br/>
 * core.jjcodes.size.small<br/>
 * core.jjcodes.size.normal<br/>
 * core.jjcodes.size.big<br/>
 * core.jjcodes.size.huge<br/>
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton</code> <br/><br/> 
 * <b>Pre-processed</b>: Yes 
 * 
 * @author Alexander Hristov
 *
 */
public class SizeCommand extends RenderCommand {
	
	public String[] sizes = {"7","9","12","18","24"};
	public String[] names = {"size.minuscule","size.small","size.normal","size.big","size.huge"};
	
  public boolean recognized(String token) {
    return token.startsWith("[size");
  }

  public StringBuffer render(Node node, int mode,HashMap info) {
    String token = node.getValue().toString();
    int equal = token.indexOf("=");
    String size = "12";
    if (equal != -1)
      size = token.substring(equal+1,token.length()-1);
    StringBuffer sb = new StringBuffer();
    sb.append("<span style='font-size:");
    sb.append(size);
    sb.append("pt'>");
    sb.append(renderChildren(node,mode,info));
    sb.append("</span>");
    return sb;
  }

  public StringBuffer renderControl(String fieldName,String helpFieldName, HashMap info) {
    StringBuffer sb = new StringBuffer();
    sb.append("<span class=\"");
    sb.append(textControlClassName);
    sb.append("\">");
    sb.append(mp.getMessage(info,rootMessageKey+"size"));
    sb.append(" <select class='");
    sb.append(controlClassName);
    sb.append("' name=\"size\" onChange=\"");
    sb.append(insertFunctionName);
    sb.append("('"+fieldName+"','[size='+this.options[this.selectedIndex].value+']','[/size]')\" ");
    sb.append(" onMouseOver=\"");
    sb.append(helpFunctionName);
    sb.append("('"+helpFieldName+"','"+mp.getMessage(info,rootMessageKey+"size.help")+"')\">");
    for (int i = 0; i < sizes.length;i++) {
    	sb.append("<option value=\"");
    	sb.append(sizes[i]);
    	sb.append("\" class=\"");
    	sb.append(textControlClassName);
    	sb.append("\">");
    	sb.append(mp.getMessage(info,rootMessageKey+names[i]));
    	sb.append("</option>");    	
    }
    sb.append("</select></span>");
    return sb;
  }

	public boolean preProcessingAllowed() {
		return true;
	}
}
