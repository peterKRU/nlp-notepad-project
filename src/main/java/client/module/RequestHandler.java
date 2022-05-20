package client.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;

import local_server.module.Concept;
import local_server.module.Definition;
import local_server.module.Note;

public class RequestHandler {
	
	private static HttpURLConnection connection;
	private HashMap<String, String> urlMap;
	
	public RequestHandler() {
		
		urlMap = loadUrlMap();
		
	}
	
	//Implement later
	public void requestGetAll() {
		
	}
	
	//Implement later
	public void requestGetTags() {
		
	}
	
	public Concept requestGetConcept(String conceptTag) throws MalformedURLException {
		
		System.out.println(urlMap.get("getConcept"));
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		String urlString = "http://localhost:8082/web_server/webapi/resource/concept/" + conceptTag; 
		
		System.out.println(urlMap.get("getConcept"));
		
		URL url = new URL(urlString);
		
		try {
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int connectionStatus = connection.getResponseCode();
			System.out.println(connectionStatus);
			
			if(connectionStatus > 299) {
				
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				
			}
			else {
				
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
			}
			
			reader.close();
			
			System.out.println(responseContent.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		
		return null;
	}
	
	public void requestGetDefinitions(Integer parentId) throws MalformedURLException {

//		//System.out.println(urlMap.get("getConcept"));
//		
//		BufferedReader reader;
//		String line;
//		StringBuffer responseContent = new StringBuffer();
//		
//		String urlString = "http://localhost:8082/web_server/webapi/resource/definitions/" + parentId; 
//		
//		//System.out.println(urlMap.get("getConcept"));
//		
//		URL url = new URL(urlString);
//		
//		try {
//			connection = (HttpURLConnection) url.openConnection();
//			
//			connection.setRequestMethod("GET");
//			connection.setConnectTimeout(5000);
//			connection.setReadTimeout(5000);
//			
//			int connectionStatus = connection.getResponseCode();
//			//System.out.println(connectionStatus);
//			
//			if(connectionStatus > 299) {
//				
//				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//				
//				while((line = reader.readLine()) != null) {
//					responseContent.append(line);
//				}
//				
//			}
//			else {
//				
//				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//				
//				while((line = reader.readLine()) != null) {
//					responseContent.append(line);
//				}
//			}
//			
//			
//			reader.close();
//			
//			System.out.println(responseContent.toString());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			connection.disconnect();
//		}

		
	}
	
	public Note requestGetNote(String noteTag) {
		
		return null;
	}
	
	public String requestPostConcept(Concept concept) throws IOException {
		
        URL url = new URL (urlMap.get("postConcept"));
        
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
       
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        
        JsonConverter converter = new JsonConverter();
        
        String jsonInputString = converter.conceptToJson(concept);
        
        try(OutputStream os = connection.getOutputStream()) {
           
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
           
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "utf-8");
        
        BufferedReader reader = new BufferedReader(isr);
        
        
        StringBuilder response = new StringBuilder();
        String responseLine = null;
           
        while ((responseLine = reader.readLine()) != null) {
               
                response.append(responseLine.trim());
           
        	}      
           
        String result = response.toString();
           
        return result;
		
	}
	
	public void requestPostDefinition(Definition definition) {
		
	}
	
	public void requestPostNote(Note note) {
		
	}
	
	public void requestDeleteConcept(String conceptTag) {
		
	}
	
	public void requestDeleteDefinition(String definitionTag) {
		
	}
	
	public void requestDeleteNote(String noteTag) {
		
	}
	
	public HashMap<String, String> loadUrlMap() {
		
		HashMap<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("getAll", "");
		urlMap.put("getTags", "");
		urlMap.put("getConcept", "http://localhost:8082/web_server/webapi/resource/concept/");
		urlMap.put("getConcept", "");
		urlMap.put("getDefinition", "");
		urlMap.put("getNote", "");
		
		urlMap.put("postConcept", "http://localhost:8082/web_server/webapi/resource/concept/create");
		urlMap.put("postDefinition", "");
		urlMap.put("postNote", "");
		
		urlMap.put("deleteConcept", "");
		urlMap.put("deleteDefinition", "");
		urlMap.put("deleteNote", "");
		
		return urlMap;
		
	}
	
}
