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
package org.jjcode;

import java.util.HashMap;

/**
 * This class represents a Filter. When rendering a data stream, the stream may include certain sequences
 * that have to be replaced when rendering, but that unlike commands, do not start and end with a specific character 
 * sequence (aka delimiter). Examples of such sequences are typically emoticons and in general sequences
 * that are replaced by images. <br/><br/>
 * 
 * A filtering class is a class that is passed the data stream and which has to substitute all character
 * sequences it handles. Many different filters can be registered, each one handling a specific set
 * of character sequences. <br/><br/>
 * 
 * The library includes a generic IconFilter that replaces all icons with their
 * corresponding images, but more can be added. <br/><br/>
 * 
 * Filter classes must be thread-safe, since they are used as singletons.
 * 
 * @see org.jjcode.filters.IconFilter
 * 
 * 
 * @author Alexander Hristov
 *
 */

public abstract class RenderFilter {
	
	/**
	 * Rendering engine to use
	 */
	protected RenderEngine engine;
	
	/**
	 * Message provider to use
	 */
	protected MessageProvider messageProvider;
	
	/**
	 * Utility function that replaces all occurences of the searched string with a replacement one. The JDK
	 * replaceAll() function is not used, because the searched string is always interpreted literally, and
	 * may contain any kind of symbols
	 * @param original String in which to perform the search
	 * @param search String to search for
	 * @param replace String to be used as a replacement
	 * @return A new string in which all occurrences of the searched string have been replaced by the
	 * substitute
	 */
	public String replaceAll(String original, String search, String replace) {
		StringBuffer result = new StringBuffer();
		while (true) {
			int pos = original.indexOf(search);
			if (pos == -1) break;
			result.append(original.substring(0,pos)+replace);
			original = original.substring(pos+search.length());
		}
		result.append(original);
		return result.toString();
	}
	
	/**
	 * Retrieves the rendering engine used by this filter
	 * @return Rendering engine used by this filter
	 */
	public RenderEngine getEngine() {
		return engine;
	}

	
	/**
	 * Sets the rendering engine to be used by this filter
	 * @param engine Rendering engine to use
	 */
	public void setEngine(RenderEngine engine) {
		this.engine = engine;
	}	
	
	/**
	 * Filters a data stream
	 * @param contents Stream to be filtered
	 * @param info Application-dependant placeholder.
	 * @return The filtered data stream
	 */
  public abstract StringBuffer render(StringBuffer contents, HashMap info);

  /**
   * <i>Description copied from org.jjcode.RenderCommand.preProcessingAllowed()</i><br/><br/>
   * 
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
   * @see org.jjcode.RenderCommand#preProcessingAllowed()
   */
  public abstract boolean preProcessingAllowed();

  /**
   * Retrieves the message provider that this filter uses
   * @return MessageProvider used
   */
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	/**
	 * Sets the message provider to use
	 * @param messageProvider New message provider to use
	 */
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}  
}
