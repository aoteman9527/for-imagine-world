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
 * Implements the [color] bbcode sequence. This sequence changes the color of the text inside it<br/><br/>
 * <b>Syntax</b>: [color=<i>any valid HTML color</i>] contents [/color]. <br/></br>
 * <b>Example</b>:<code> [color=red] This is red! [/color] <br/><br/></code>
 * <b>Contents</b>: The [color] command allows any kind of nested contents<br/><br/>
 * <b>Pre-processed</b>: Yes <br/><br/>
 * <b>Messages</b>:  <br/><code>
 *  core.jjcodes.color <br/> 
 * 	core.jjcodes.color.black<br/>
 * 	core.jjcodes.color.darkred<br/>
 * 	core.jjcodes.color.red<br/>
 *  core.jjcodes.color.orange<br/>
 *  core.jjcodes.color.brown<br/>
 *  core.jjcodes.color.yellow<br/>
 *  core.jjcodes.color.green<br/>
 *  core.jjcodes.color.olive<br/>
 *  core.jjcodes.color.cyan<br/>
 *  core.jjcodes.color.blue<br/>
 *  core.jjcodes.color.darkblue<br/>
 *  core.jjcodes.color.indigo<br/>
 *  core.jjcodes.color.violet<br/>
 *  core.jjcodes.color.white<br/>
 *  core.jjcodes.color.black<br/>  
 * </code><br/><br/>
 * <b>CSS styles</b>: <code>jjCodeButton, jjCodeText</code> <br/><br/>
 * @author Alexander Hristov
 *
 */
public class ColorCommand extends RenderCommand {
	protected   String[] colors = {"black","darkred","red","orange","brown","yellow","green","olive","cyan","blue","darkblue","indigo","violet","white","black" };

  public boolean recognized(String token) {
    return token.startsWith("[color");
  }

  public StringBuffer render(Node tree, int mode, HashMap info) {
    String token = tree.getValue();
    int equal = token.indexOf("=");
    String color = "black";
    if (equal != -1 && equal != token.length()-2)
      color = token.substring(equal+1,token.length()-1);
    
    StringBuffer sb = new StringBuffer();
    sb.append("<span style='color:");
    sb.append(color);
    sb.append("'>");
    sb.append(renderChildren(tree,mode,info));
    sb.append("</span>");
    return sb;
  }


  public StringBuffer renderControl(String fieldName, String helpFieldName, HashMap info) {
    StringBuffer sb = new StringBuffer();
    sb.append("<span class=\"");
    sb.append(textControlClassName);
    sb.append("\"> &nbsp;");
    sb.append(mp.getMessage(info,rootMessageKey+"color"));
    sb.append(" <select class='");
    sb.append(controlClassName);
    sb.append("' name='color' onChange=\"");
    sb.append(insertFunctionName);
    sb.append("('"+fieldName+"','[color='+this.options[this.selectedIndex].value+']','[/color]')\" ");
    sb.append("onMouseOver=\"");
    sb.append(helpFunctionName);
    sb.append("('"+helpFieldName+"','"+mp.getMessage(info,rootMessageKey+"color.help")+"')\">");
    for (int i = 0; i < colors.length; i++) {
      String messageId = rootMessageKey+"color."+colors[i];
      sb.append("<option style=\"color:");
      sb.append(colors[i]);
      sb.append("; font-weight:bold; background-color: #FAFAFA\" value=\"");
      sb.append(colors[i]);
      sb.append("\" class=\"");
      sb.append(textControlClassName);
      sb.append("\">");
      sb.append(mp.getMessage(info,messageId));
      sb.append("</option>");
    }
    sb.append("</select></span>");
    return sb;
  }

	public boolean preProcessingAllowed() {
		return true;
	}

}
