package client.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import local_server.module.Concept;

public class JsonConverter {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public JsonConverter() {
		
	}
	
	public String conceptToJson(Concept concept) throws JsonProcessingException {
		
        String jsonString = mapper.writeValueAsString(concept);
            
		return jsonString;
		
	}
	
	public Concept jsonToConcept(String jsonString) throws JsonProcessingException {
		
        //String jsonString = mapper.writeValueAsString(concept);
        Concept concept = mapper.readValue(jsonString, Concept.class);
        //Car car = objectMapper.readValue(json, Car.class);
        
		return concept;
		
	}
	
}
