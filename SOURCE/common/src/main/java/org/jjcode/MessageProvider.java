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

import java.util.HashMap;

/**
 * Class representing a localized message provider. This class allows the library to be
 * completely context-agnostic : it can use messages from a database, from a resource bundle, etc...
 * @author Alexander Hristov
 *
 */
public abstract class MessageProvider {
	
	/**
	 * Returns a localized message. 
	 * @param context Application-dependant context information. Mainly used to
	 * derive the locale to use and the location of the resources 
	 * @param messageId Id (or key) of the messaage
	 * @param params - If the id points to a parametrized message, this array contains the list of parameters.
	 * May be null, or empty.
	 * @return Localized text message
	 */
  public abstract String getMessage(HashMap context,String messageId, Object[] params);
  
  /**
   * Retrieves a localized message
   * @param context Application-dependant context information
   * @param messageId key of the message
   * @return Localized text message
   * @see #getMessage(HashMap, String, Object[])
   */
  public String getMessage(HashMap context, String messageId) {
  	return getMessage(context,messageId, null);
  }

  /**
   * Retrieves a single-parameter localized message
   * @param context Application-dependant context information
   * @param messageId key of the message
   * @param param Parameter to pass to the message
   * @return Localized text message
   * @see #getMessage(HashMap, String, Object[])
   */  
  public String getMessage(HashMap context, String messageId, Object param) {
  	return getMessage(context,messageId, new Object[]{param});
  }

  /**
   * Retrieves a double-parameter localized message
   * @param context Application-dependant context information
   * @param messageId key of the message
   * @param param1 First parameter to pass to the message
   * @param param2 Second parameter to pass to the message
   * @return Localized text message
   * @see #getMessage(HashMap, String, Object[])
   */  
  public String getMessage(HashMap context, String messageId, Object param1, Object param2) {
  	return getMessage(context,messageId, new Object[]{param1,param2});
  }
  
  /**
   * Retrieves a localized message with three parameters
   * @param context Application-dependant context information
   * @param messageId key of the message
   * @param param1 First parameter to pass to the message
   * @param param2 Second parameter to pass to the message
   * @param param3 Third parameter to pass to the message
   * @return Localized text message
   * @see #getMessage(HashMap, String, Object[])
   */  
  public String getMessage(HashMap context, String messageId, Object param1, Object param2, Object param3) {
  	return getMessage(context,messageId, new Object[]{param1,param2,param3});
  }  
  
}
