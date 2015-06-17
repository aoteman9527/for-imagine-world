/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text
 * streams. 
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

import org.jjcode.Node;
import org.jjcode.Parser;
import org.jjcode.commands.AudioCommand;
import org.jjcode.commands.BoldCommand;
import org.jjcode.commands.ColorCommand;
import org.jjcode.commands.ImageCommand;
import org.jjcode.commands.ItalicCommand;
import org.jjcode.commands.MailCommand;
import org.jjcode.commands.QuoteCommand;
import org.jjcode.commands.SizeCommand;
import org.jjcode.commands.SubscriptCommand;
import org.jjcode.commands.SuperscriptCommand;
import org.jjcode.commands.URLCommand;
import org.jjcode.commands.UnderlineCommand;
import org.jjcode.commands.VideoCommand;
import org.jjcode.filters.IconFilter;
import org.jjcode.filters.UnicodeFilter;

/**
 * This class handles the process of command registration, pre-processing, and rendering. <br/><br/>
 * It is thread-safe, and meant to be used as a singleton.
 * @author Alexander Hristov
 *
 */

public class RenderEngine {
	/**
	 * Key used to store the locale in which all messages should be expressed. The key-locale pair
	 * should be stored in the hashmap that acts as a generic placeholder for application-data   
	 */
	public static final String LOCALE_KEY = "org.jjcode.messageprovider.locale";
	
	/**
	 * The pre-processing mode allows the application to replace as many codes as possible in order to
	 * speed the final rendering when an actual user requests it. 
	 */
	public static final int MODE_PREPROCESS = 0;
	
	/**
	 * The rendering mode replaces all codes in the data stream
	 */
	public static final int MODE_RENDER = 1;
	
	/**
	 * List of registered command handlers
	 */
  private ArrayList commandHandlers  = new ArrayList();
  
  /**
   * List of registered filters
   */
  private ArrayList filters = new ArrayList();
  
  /**
   * Class to use for retrieving localized messages
   */
  private MessageProvider messageProvider;
  
  /**
   * Hashmap that stores <character-sequence> <corresponding-image> pairs. For example, <br/><br/>
   * 
   * :-)  <-> images/smile.gif
   * 
   */
  private HashMap iconCache = new HashMap();

  /**
   * Retrieves the current message provider
   * @return Message Provider
   * @see org.jjcode.MessageProvider
   */
  public MessageProvider getMessageProvider() {
		return messageProvider;
	}

  /**
   * Sets the current message provider. Also modifies the message provider of all registered
   * commands and filters, setting it to the new one.
   * @param messageProvider Message provider to use from now on
   */
	public synchronized void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
		for (int i = 0; i < commandHandlers.size(); i++) {
		  RenderCommand handler = (RenderCommand)commandHandlers.get(i);
			handler.setMessageProvider(messageProvider);
		}
		for (int i = 0; i < filters.size(); i++) {
		  RenderFilter filter  = (RenderFilter)filters.get(i);
			filter.setMessageProvider(messageProvider);
		}
		
	}

	/**
	 * Registers a new command handler. The system does not check for duplicated registrations.
	 * @param handler New command handler.
	 */
	public synchronized void registerHandler(Object handler) {
    if (handler instanceof RenderCommand) {
    	((RenderCommand)handler).setEngine(this);
      commandHandlers.add((RenderCommand)handler);
    }
    if (handler instanceof RenderFilter) {
    	((RenderFilter)handler).setEngine(this);
      filters.add(handler);
    }
  }
	
	/**
	 * Scans all regsitered commands classes and returns the one that recoginizes the specified token, or null
	 * if no such command class exists
	 * @param token Token to be recognized, complete with opening and closing delimiters (for example, [b]), and
	 * full parameters (if applicable)
	 * @return A RenderCommand instance which can handle the specified command, or null if none of the
	 * registered commands recognizes the sequence
	 */
  public RenderCommand findHandler(String token) {
    for (int i = 0; i < commandHandlers.size();i++) {
      RenderCommand cmd = (RenderCommand)commandHandlers.get(i);
      if (cmd.recognized(token.toLowerCase()))
        return cmd;
    }
    return null;
  }

  /**
   * Parse and render a string. 
   * @param s String to be processed
   * @param mode Rendering mode (either MODE_PREPROCESS or MODE_RENDER). If you need the final result
   * without any unresolved codes or character sequences, use MODE_RENDER. If instead you want to
   * replace as many codes as possible and store the result in order to improve rendering speed when it
   * is actually needed, use MODE_PREPROCESS.
   * @param info Generic application-dependant placeholder, which will be in turn passed on to all commands
   * and filters. The JJCode system itself does not use this parameter
   * @return Resulting string 
   */
  public String render(String s, int mode, HashMap info) {
    StringBuffer source = new StringBuffer(s);
    for (int i = 0; i < filters.size(); i++){
      RenderFilter filter = (RenderFilter)filters.get(i);
      if (mode == MODE_PREPROCESS && !filter.preProcessingAllowed()) 
      	continue;
      source = filter.render(source,info);
    }

    Parser p = new Parser();
    Node root = p.parse(source.toString());
    return renderChildren(root,mode,info).toString();
  }
  
  /**
   * Convenience method that parses and renders a string passing the specified locale.
   * @param s String to be processed
   * @param mode Rendering mode (@see #render(String, int, HashMap) for a description)
   * @param locale Locale to use
   * @return The resulting string
   */
  public String render(String s, int mode, Locale locale) {
  	HashMap context = new HashMap();
  	context.put(LOCALE_KEY,locale);
  	return render(s,mode,context);
  }

  
  /**
   * Renders a subtree
   * @param parent root of the subtree to be rendered
   * @param mode Rendering mode
   * @param info Generic application-dependant placeholder, which in turn will be passed on to all
   * commands.
   * @return The result of the processing
   */
  public StringBuffer renderChildren(Node parent, int mode, HashMap info) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < parent.getChildCount(); i++) {
      Node child = parent.getChild(i);
      switch (child.getType()) {
        case Node.TYPE_LITERAL : sb.append( child.getValue() ); break;
        case Node.TYPE_COMMAND :
          RenderCommand cmd = findHandler(child.getValue());
          if (cmd == null) {
          	sb.append( renderChildren(child,mode, info));
          	continue;
          }
          if (!cmd.preProcessingAllowed() && mode == MODE_PREPROCESS) {
          	 sb.append(child.getValue());
          	 sb.append(renderChildren(child,mode, info));
          	 sb.append("[/");
          	 sb.append(child.getTag());
          	 sb.append("]");
          	 continue;
          }
          sb.append( cmd.render(child,mode,info) );
             
      }
    }
    return sb;
  }


  /**
   * Retrieves the registered commands
   * @return List of registered command handlers. May be empty.
   */
  public ArrayList getCommands() {
    return commandHandlers;
  }

  /**
   * Adds an icon to the icon cache
   * @param icon Icon to be added
   */
  public void addIcon(Icon icon) {
  	synchronized(iconCache) { iconCache.put(icon.id,icon); }
  }
  
  /**
   * Retrieves the icon corresponding to a specific character sequence
   * @param id Character sequence whose icon is to be retrieved (for example, ":-)")
   * @return Icon corresponding to this character sequence, or null if no such icon is found
   */
  public Icon getIcon(String id) {
  	return (Icon)iconCache.get(id);
  }
  
  /**
   * Retrieves the list of character sequences which have a corresponding icon 
   * @return Set of icon keys
   */
  public Set getIcons() {
  	return iconCache.keySet();
  }
  
  /**
   * Shorthand method for registering all standard commands and filters
   */
  public void registerAll() {
    registerHandler(new BoldCommand());
    registerHandler(new ColorCommand());
    registerHandler(new ItalicCommand());
    registerHandler(new MailCommand());
    registerHandler(new QuoteCommand());
    registerHandler(new SizeCommand());
    registerHandler(new SubscriptCommand());
    registerHandler(new SuperscriptCommand());
    registerHandler(new UnderlineCommand());
    registerHandler(new URLCommand());
    registerHandler(new ImageCommand());
    registerHandler(new AudioCommand());
    registerHandler(new VideoCommand());
    
    registerHandler(new UnicodeFilter());
    registerHandler(new IconFilter());
  	
  }
  

}
