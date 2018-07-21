package com.divyesh.validator;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;

import com.divyesh.conversion.ContextLoader;
import com.divyesh.exception.InvalidKeyword;
import com.divyesh.exception.MissedConfiguration;
import com.divyesh.keywords.register.MaxLength;
import com.divyesh.keywords.register.MinLength;
import com.divyesh.keywords.register.Register;
import com.divyesh.utility.JsonUtils;

public class Validator {

	public static boolean validate(Object obj) {
		boolean flag=false;
		JSONObject data =(JSONObject) obj;
		Map<String,Object> dataMap=JsonUtils.toDataMap(data);
		Map<String, JSONObject> configMap=ContextLoader.getConfigMap();
		Iterator<String> dataItr= dataMap.keySet().iterator();
		while(dataItr.hasNext()){
			String key=dataItr.next();
			Object value=data.get(key);
			JSONObject configObject = configMap.get(key);
			Iterator<String> configItr= configObject.keySet().iterator();
			try{
				if(!configItr.hasNext()){
					throw new MissedConfiguration("configuration is missing");
				}
			}
			catch(MissedConfiguration e){
				System.out.println(e.getMessage());
			}
			try{
				while(configItr.hasNext()){
					String configKey=configItr.next();
					Object confValue=configObject.get(configKey);
					if(configKey.equalsIgnoreCase("maxLength")){
						flag=MaxLength.getInstance().validate(value,confValue);
					}else if(configKey.equalsIgnoreCase("minLength")){
						flag=MinLength.getInstance().validate(value,confValue);
					}else{
						throw new InvalidKeyword("Key is missed in configuration file");
					}
					if(!flag){
						System.out.println("Data is not valid");
						break;
					}else{
						System.out.println("Data is validated");
					}
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		
		
		return false;
	}
	
}
