package client.module;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

public class ConfigManager {
	
	private HashMap<String, String> configMap;
	
	public ConfigManager(String configFilePath) throws IOException {
		
		configMap = new HashMap<String,String>();
		
		loadConfig(configFilePath, configMap);
		
	}
	
	public void loadConfig(String configFilePath, HashMap<String, String> configMap) throws IOException {
		
		JsonConverter jsonConverter = new JsonConverter();
		//File config = new File("files/config.json");
		File configFile = new File(configFilePath);
		
		JsonNode configNode = JsonConverter.mapper.readTree(configFile);
		
		ArrayList<String> configKeys = jsonConverter.getKeysArray(configFile);
		
		for(int i = 0; i < configKeys.size(); i++) {
			
			configMap.put(configKeys.get(i), configNode.get(configKeys.get(i)).asText());
			
		}
		
	}
	
	public String getValue(String key) {
		
		String value = "";
		
		try {
			value = configMap.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public void updateValue(String key, String newValue) {
		
	}
	
}
