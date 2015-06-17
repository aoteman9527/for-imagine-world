/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text
 * streams. 
 * 
 * Copyright (c) 2006 Alexander Hristov.
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
package org.jjcode;

import java.util.HashMap;

/**
 * This class represents the common ancestor of all rendering commands. Users wishing to add their own
 * commands to the engine should extend this class. For a really simple command, see BoldCommand.
 * Classes implementing commands MUST be thread safe, as a Rendering engine will create a single instance
 * of each class and use it for all processing.
 * @author Alexander Hristov
 *
 */

public abstract class RenderCommand {
	/**
	 * Name of the CSS class used by all HTML controls that insert the various bbCode sequences in
	 * a field
	 */
	protected String controlClassName="jjCodeButton";
	
	/**
	 * Name of the CSS class used by all bbCode sequences that represent a link, such as [url],[audio],
	 * [video], etc..
	 */
	protected String linkClassName="jjCodeLink";
	/**
	 * Name of the CSS class used by all HTML controls that display a set of lines
	 */
	protected String textControlClassName = "jjCodeText";
	/**
	 * Name of the Javascript function that is called when a bbCode sequence has to be inserted
	 * somewhere. This function receives three parameters - the field name, the sequence to be inserted
	 * before the current cursor position or - if part of the field text is selected - before the beginning
	 * of the selection, and the sequence to be inserted after the current position or after the end
	 * of the selection. <br/><br/>
	 * A sample call to this function would look like: <br/><br/>
	 * <code>jjCodeText("product_review","[b]","[/b]")</code>
	 *  
	 */
	protected String insertFunctionName = "jjPressed";
	
	/**
	 * Name of the Javascript function that is called to show the help text associated with an 
	 * HTML control. This function receives two parameters - the help field name and the help message.</br></br>
	 * A sample call to this function would look like:<br/><br/>
	 * <code>jjHelp("product_review_help","The [b] code makes the selection show in bold")</code>
	 */
	protected String helpFunctionName = "jjHelp";
	
	/**
	 * The with of the HTML buttons that insert bbCodes 
	 */
	protected String controlFontWidth = "40";
	
	/**
	 * The root key for the localized messages. This key is prepended to all message keys used by the
	 * system.
	 */
	protected String rootMessageKey = "core.jjcodes.";
	
	protected RenderEngine engine;
	protected MessageProvider mp;

	/**
	 * Specifies whether the provided token is recognized by this class. The parser will provide
	 * the command token with all its delimiters and parameters, for example "[b]" for the bold command, or
	 * "[url=http://www.ahristov.com]" for a hyperlink. Classes that define new types of commands will override
	 * this method, returning true when the rendering engine passes them a sequence that they recognize.  
	 * @param token Command sequence from the stream. The sequence will start with a '[' character and end
	 * with a ']' character
	 * @return true if the class recognizes and can process this command, false otherwise. 
	 */
  public abstract boolean recognized(String token);

  /**
   * Specifies whether commands recognized by this class can be rendered before there is a real need for
   * delivering the contents. This is useful if an application wants to gain some speed by minimizing the
   * amount of commands processed when a specific user views a document. For example, there are commands
   * that are rendered always in the same way, regardless of the time, location, document and/or viewing
   * user. <br /><br />
   * For example, [b] (bold), [i] (italics), etc.. always render as &lt;b&gt;, &lt;i&gt;, or some other
   * fixed sequence. Thus, an application could choose to pre-render these sequence and store the
   * rendered result instead of the source code, thus gaining speed when delivering the document
   * to multiple users. If the class implements such an 'agnostic' command, it should return true
   * in this method. Returning true does <iu>not</i> mean that the command will be actually pre-processed, as this
   * depends on how the system is configured.
   * <br /><br />
   * There are commands which cannot be pre-processed. For example, the obvious [time] or [date] cannot
   * be pre-rendered. However, there are also more subtle cases. For example, the command :-) which is
   * rendered as an image of a smiling face cannot be pre-rendered because the help text (or ALT attribute)
   * of the image is locale-dependant, thus requiring access to the configuration of the specific user
   * viewing the document. For such commands, this method should return false.<br/> 
   * As a rule of thumb, if your command uses MessageProvider then it PROBABLY cannot be pre-processed (unless
   * you don't care about localization)
   * 
   * @return true if the command can be rendered and the result stored for later delivery, false ohterwise.
   */
  public abstract boolean preProcessingAllowed();
  
  
  /**
   * This method renders a subtree. The node passed as parameter is the node representing the command, and
   * its children represent whatever was found between the starting point of the command and its ending
   * point. Classes that define new types of commands must override this method and render the contents
   * appopriately. <br /><br />
   * @param tree The node to be rendered. Guaranteed to be a COMMAND node, and guaranteed also to be
   * a command that the class has previously recognized.  
   * @param info Application-dependant information. This is a generic HashMap that the application passes to the 
   * rendering engine, which in turn passes it to all commands. However, the library itself does not make
   * any specific use of it. Think of this parameter as a generic placeholder.
   * @return The rendered subtree
   */
  public abstract StringBuffer render(Node tree,int mode,HashMap info);
  
  
  /**
   * This method is used for creating live editors that allow the use of the current command.
   * Returns a sequence that represents a user widget that, when pressed, inserts the current command
   * in the specified field. For example, this method could render an HTML button. <br /><br />
   * Have in mind that this method may be called several times per document, for example if there are
   * several HTML fields that allow bbCodes on the same page.   
   * @param fieldName Name of the HTML input box where the command sequence must be inserted
   * @param helpFieldName Name of the HTML element that displays help information for this field.  
   * @param info Generic application-specific information
   * @return A sequence that is inserted near the field that will be edited, and that represents a user
   * control that when activated, generates the command sequence. The returned buffer may be empty if
   * no such control is possible or implemented, but it may not be null.
   * @see #renderControlHeader(HashMap)
   */
  public abstract StringBuffer renderControl(String fieldName, String helpFieldName, HashMap info);

  /**
   * This method is used for creating live editors that allow the use of the current command.
   * Returns a sequence that is included at the top of the document, one single time regardless of
   * how many input fields using this control exist. For example, this method could return a sequence
   * inserting a generic JavaScript snippet. It is guaranteed that this method will be called at most
   * once per document.
   * @param info Generic application-specific information
   * @return A sequence (may be empty, but not null) to be inserted at the beginning of the rendered
   * document.  
   * @see #render(Node, int, HashMap)
   */
  public StringBuffer renderControlHeader(HashMap info) {
  	return new StringBuffer();
  }
  

  /**
   * A helper method that renders an HTML button with a base "generic" style and an additional style
   * depending on the button. When the button is pressed, it invokes a javascript function that inserts
   * a configurable bbcode sequence in an edit field. Also, when the mouse is over the button, a
   * configurable help message pops up. 
   * @param labelKey Key of the label to show on the button. May not be null.
   * @param helpKey Key of the help text. May not be null.
   * @param insertSequenceStart Sequence to insert in the editing field before the position of the cursor or
   * the selected text. May not be null
   * @param insertSequenceEnd Sequence to insert in the editing field after the position of the cursor
   * or after the selected text. May not be null
   * @param fieldName Name of the HTML field that is being edited
   * @param helpFieldName Name of the HTML field that displays help texts
   * @param style Additional style to apply to the button. May be null
   * @param hotKey Accessibility key to set. May be null.
   * @param info Generic application-dependant information
   * @return An (X)HTML sequence containing the rendered control 
   */
  protected StringBuffer renderButtonControl(
  		String labelKey, String helpKey, String insertSequenceStart, String insertSequenceEnd, 
  		String fieldName, String helpFieldName, String style, String hotKey, HashMap info) {
  	StringBuffer sb = new StringBuffer();
    sb.append("<input type=\"button\" class=\"");
    sb.append(controlClassName);
    sb.append("\"");
    if (hotKey !=null) {
    	sb.append("accesskey=\"");
    	sb.append(hotKey);
    	sb.append("\"");
    }
    sb.append(" value=\" ");
    sb.append(mp.getMessage(info,rootMessageKey+labelKey));
    sb.append("\" style=\"width: ");
    sb.append(controlFontWidth);
    sb.append("px; ");
    if (style != null) {
      sb.append(style);
    }
    sb.append("\" onClick=\"");
    sb.append(insertFunctionName);
    sb.append("('");
    sb.append(fieldName);
    sb.append("','");
    sb.append(insertSequenceStart);
    sb.append("','");
    sb.append(insertSequenceEnd);
    sb.append("')\" onMouseOver=\"");
    sb.append(helpFunctionName);
    sb.append("('");
    sb.append(helpFieldName);
    sb.append("','");
    sb.append(mp.getMessage(info,rootMessageKey+helpKey));
    sb.append(" ')\" />");
    return sb;
  }

  
  /**
   * Requests from the engine to render a node. This method should be used only for rendering nodes
   * that are NOT recognized by this class - usually children.  
   * @param node Node to be rendered
   * @param mode Rendering mode
   * @param info Generic application-specific information
   * @return The rendered tree.
   */
  public StringBuffer renderChildren(Node node, int mode, HashMap info) {
    return engine.renderChildren(node,mode,info);
  }

  /**
   * Returns the rendering engine using this command 
   * @return Rendering engine using this command.
   */
  public RenderEngine getEngine() {
		return engine;
	}

  /**
   * Sets the rendering engine to use
   * @param engine Rendering engine to use
   */
	public void setEngine(RenderEngine engine) {
		this.engine = engine;
		mp = engine.getMessageProvider();
	}
	
	/**
	 * Sets the message provider to use
	 * @param mp New message provider to use from now on
	 */
	public void setMessageProvider(MessageProvider mp) {
		this.mp = mp;
	}

	/**
	 * Retrieves the CSS class name for buttons
	 * @return CSS class name for buttons
	 * @see #controlClassName
	 */
	public String getControlClassName() {
		return controlClassName;
	}

	/**
	 * Sets the CSS class name for buttons
	 * @param controlClassName CSS class name for buttons
	 * @see #controlClassName
	 */
	public void setControlClassName(String controlClassName) {
		this.controlClassName = controlClassName;
	}

	/**
	 * Retrieves the button width in pixels
	 * @return button width in pixels
	 * @see #controlFontWidth
	 */
	public String getControlFontWidth() {
		return controlFontWidth;
	}

	/**
	 * Sets the button width in pixels
	 * @param controlFontWidth button width in pixels
	 * @see #controlFontWidth
	 */
	public void setControlFontWidth(String controlFontWidth) {
		this.controlFontWidth = controlFontWidth;
	}

	/**
	 * Retrieves the name of the javascript help function
	 * @return Name of the javascript help function
	 * @see #helpFunctionName
	 */
	public String getHelpFunctionName() {
		return helpFunctionName;
	}

	/**
	 * Sets the name of the javascript help function
	 * @param helpFunctionName Name of the javascript help function
	 * @see #helpFunctionName
	 */
	public void setHelpFunctionName(String helpFunctionName) {
		this.helpFunctionName = helpFunctionName;
	}

	/**
	 * Retrieves the name of the javascript bbcode insertion function
	 * @return Name of the javascript bbcode insertion function
	 * @see #insertFunctionName
	 */
	public String getInsertFunctionName() {
		return insertFunctionName;
	}

	/**
	 * Sets the name of the javascript bbcode insertion function
	 * @param insertFunctionName Name of the javascript insertion function
	 * @see #insertFunctionName
	 */
	public void setInsertFunctionName(String insertFunctionName) {
		this.insertFunctionName = insertFunctionName;
	}

	/**
	 * Retrieves the CSS class name for bbcode links
	 * @return CSS class name for bbcode links
	 * @see #linkClassName
	 */
	public String getLinkClassName() {
		return linkClassName;
	}

	/**
	 * Sets the CSS class name for bbcode links
	 * @param linkClassName CSS class name for bbcode links
	 * @see #linkClassName
	 */
	public void setLinkClassName(String linkClassName) {
		this.linkClassName = linkClassName;
	}

	/**
	 * Retrieves the root key used by all messages 
	 * @return root key
	 * @see #rootMessageKey
	 */
	public String getRootMessageKey() {
		return rootMessageKey;
	}

	/**
	 * Sets the root key to be used by all messages
	 * @param rootMessageKey root key to use
	 * @see #rootMessageKey
	 */
	public void setRootMessageKey(String rootMessageKey) {
		this.rootMessageKey = rootMessageKey;
	}

	/**
	 * Retrieves the CSS class name for text-based controls
	 * @return CSS class name
	 * @see #textControlClassName
	 */
	public String getTextControlClassName() {
		return textControlClassName;
	}

	/**
	 * Sets the CSS class name for text-based controls
	 * @param textControlClassName CSS class name
	 * @see #textControlClassName
	 */
	public void setTextControlClassName(String textControlClassName) {
		this.textControlClassName = textControlClassName;
	}
  
  
}
