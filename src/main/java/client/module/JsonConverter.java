package client.module;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import local_server.module.Concept;

public class JsonConverter {
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	public JsonConverter() {
		
	}
	
	public ArrayList<String> getKeysArray(File file) throws IOException {
		
		ArrayList<String> keysArray = new ArrayList<String>();
		JsonNode jsonNode = mapper.readTree(file);
	    
		Iterator<String> iterator = jsonNode.fieldNames();
		iterator.forEachRemaining(e -> keysArray.add(e));
		
		return keysArray;
	}
	
	public String conceptToJson(Concept concept) throws JsonProcessingException {
		
        String jsonString = mapper.writeValueAsString(concept);
            
		return jsonString;
		
	}
	
	
}
