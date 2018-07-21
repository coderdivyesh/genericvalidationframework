package com.divyesh.conversion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.divyesh.constants.Constants;
import com.divyesh.utility.JsonUtils;

public class ContextLoader {

	private static Object data;
	private static Object config;

	public static Object getData() {
		try {
			data = new JSONParser().parse(new FileReader(Constants.DATA_FILE_URI));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static Map<String, JSONObject> getConfigMap(){
		Map<String, JSONObject> configMap=null;
		try{
			config= new JSONParser().parse(new FileReader(Constants.CONFIG_FILE_URI));
			JSONObject configData=(JSONObject)config;
			configMap=JsonUtils.jsonToMap(configData);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configMap;
	}
}
