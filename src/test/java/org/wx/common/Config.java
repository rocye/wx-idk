package org.wx.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class Config {
	private static ResourceBundle resources = null;
	private static Map propertyMap = new HashMap();

	private static void getBundle() {
		if (resources == null)
			resources = ResourceBundle.getBundle("application", Locale.getDefault());
	}

	public static String getAttribute(String name) {
		String value = (String) propertyMap.get(name);
		if (value == null) {
			getBundle();
			if (resources != null) {
				try {
					value = resources.getString(name);
				} catch (MissingResourceException exception) {
					return null;
				}
			}
		}
		return value;
	}

	public static Map getAttributesMap(String name) {
		Map map = (Map) propertyMap.get(name);
		if (map == null) {
			getBundle();
			try {
				String keyStr = resources.getString(name);
				String[] keys = (String[]) null;
				if (keyStr != null) {
					keys = keyStr.split(",");
				}
				map = new HashMap();
				if (keys != null) {
					for (int i = 0; i < keys.length; i++) {
						String value = resources
								.getString(name + "." + keys[i]);
						map.put(keys[i], value);
					}
				}
				propertyMap.put(name, map);
			} catch (MissingResourceException exception) {
				return null;
			}
		}
		return map;
	}

	public static Set getAttributesSet(String name) {
		Set set = (Set) propertyMap.get(name);
		if (set == null) {
			set = new HashSet();
			getBundle();
			try {
				String value = resources.getString(name);
				String[] ips = (String[]) null;
				if (value != null) {
					ips = value.split(",");
				}
				if (ips != null) {
					for (int i = 0; i < ips.length; i++) {
						set.add(ips[i]);
					}
				}
				propertyMap.put(name, set);
			} catch (MissingResourceException exception) {
				return null;
			}
		}
		return set;
	}

	public static void remove() {
		resources = null;
		propertyMap.clear();
	}

	public static void main(String[] args) {
		System.out.println(getAttribute("sessionOperator.class.name"));
	}
}