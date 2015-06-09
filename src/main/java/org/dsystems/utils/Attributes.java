package org.dsystems.utils;

import java.util.HashMap;

public class Attributes extends HashMap<String, Object> {


	private static final long serialVersionUID = 1L;

	public String getValue(String key) {
		Object value = this.get(key);
		if (value != null)
			return value.toString();
		else
			return null;
	}

	public void putValue(String key, String value) {
		this.put(key, value);
		
	}
}
