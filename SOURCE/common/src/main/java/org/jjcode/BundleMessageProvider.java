/*
 * JJCode - A Java library for rendering bbCodes and similar artifacts in text streams.
 * Copyright (c) 2006 Alexander Hristov .
 * 
 * This library is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU Lesser General Public License as published by the Free Software Foundation; 
 * either version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this library; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 *
 */
package org.jjcode;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class represents a message provider that derives its messages from a resource bundle.
 * This class is thread-safe and is intented to be used as a singleton.
 * 
 * @author Alexander Hristov
 *
 */
public class BundleMessageProvider extends MessageProvider {
	private String bundleBaseName;
	private HashMap resourceBundles;
	
	
	/**
	 * Creates a new provider using the specified name as a base name for the message files
	 * @param bundleBaseName Base name of the different message files
	 */
	public BundleMessageProvider(String bundleBaseName) {
		this.bundleBaseName = bundleBaseName;
		resourceBundles = new HashMap();
	}
	
	/**
	 * Retrieves a ResourceBundle for the specified locale. If the resource bundle was accessed
	 * previously, then it is reused. If this is the first time this locale is referenced, then
	 * the resource bundle is loaded and stored for future use.
	 * @param locale Locale whose resource bundle is to be retrieved
	 * @return The requested resource bundle
	 */
	protected synchronized ResourceBundle getBundleForLocale(Locale locale) {
		ResourceBundle rb = (ResourceBundle)resourceBundles.get(locale);
		if (rb == null) {
			rb = ResourceBundle.getBundle(bundleBaseName,locale);
			resourceBundles.put(locale,rb);
		}
		return rb;
	}
	
	
	public String getMessage(HashMap context, String messageId, Object[] params) {
		Locale locale = (Locale)context.get(RenderEngine.LOCALE_KEY);
		ResourceBundle rb = getBundleForLocale(locale);
		String message = rb.getString(messageId);
		if (params == null || params.length == 0) return message;
		for (int i = 0; i < params.length; i++) {
			message = message.replaceAll("\\{"+i+"\\}",params[i].toString());
		}
		return message;
	}


}
