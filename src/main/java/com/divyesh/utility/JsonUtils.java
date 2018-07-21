package com.divyesh.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

public class JsonUtils {
	public static Map<String, JSONObject> map = new HashMap<String, JSONObject>();
	public static Map<String, JSONObject> jsonToMap(JSONObject json) {
		Map<String, JSONObject> retMap = new HashMap<>();
		if (null != json) {
			retMap = toMap(json);
		}
		return retMap;
	}

	public static Map<String, JSONObject> toMap(JSONObject object) throws JSONException {
		
		Iterator<String> keysItr = object.keySet().iterator();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);
			if (value instanceof JSONArray) {
				map.put(key, (JSONObject)value);
				toList((JSONArray) value);
			} else if (value instanceof JSONObject) {
				map.put(key, (JSONObject)value);
				toMap((JSONObject) value);
			}
			
		}
		return map;
	}

	public static List<JSONObject> toList(JSONArray array) {
		List<JSONObject> list = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add((JSONObject)value);
		}
		return list;
	}
	
	public static Map<String, Object> toDataMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<>();
		Iterator<String> keysItr = object.keySet().iterator();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			} else if (value instanceof JSONObject) {
				value = toDataMap((JSONObject) value);
			}
				map.put(key,value);
			
		}
		return map;
	}

}
