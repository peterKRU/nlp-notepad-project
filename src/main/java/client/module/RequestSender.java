package client.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import local_server.module.*;

public class RequestSender {
	
	private static HttpURLConnection connection;
	private HashMap<String, String> urlMap;
	
	public RequestSender() {
		
		urlMap = new HashMap<String, String>();
		
		urlMap.put("getAll", "");
		urlMap.put("getTags", "");
		urlMap.put("getConcept", "");
		urlMap.put("getConcept", "");
		
	}
	
	public String sendPostRequest(Concept concept) throws UnsupportedEncodingException, IOException {
		
        URL url = new URL ("http://localhost:8082/web_server/webapi/product/test");
        
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
       
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        //connection.setDoInput(true);
       
       
        //String jsonInputString = convertToJsonString(concept);
        
        String jsonInputString = "{\"conceptId\":1999,\"parentId\":0,\"conceptTag\":\"ololo\"}";
        
        try(OutputStream os = connection.getOutputStream()) {
           
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
           
        }
       
        InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "utf-8");
        
        BufferedReader reader = new BufferedReader(isr);
        
        
        StringBuilder response = new StringBuilder();
        String responseLine = null;
           
        while ((responseLine = reader.readLine()) != null) {
               
                response.append(responseLine.trim());
           
        	}      
           
        System.out.println(response.toString());
           
        String result = response.toString();
           
        return result;

	}
	
	public String convertToJsonString(Concept concept) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(concept);
            
		return jsonString;
		
	}
	
	public void sendTestRequest() throws MalformedURLException {
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		URL url = new URL("http://localhost:8082/web_server/webapi/product");
		
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
		
	}
	
	public void sendTestRequestAlternative(String url){
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenApply(RequestSender::parse)
			.join();
		
	}
	
	public static String parse(String responseBody) {
		JSONArray responseArray = new JSONArray(responseBody);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i = 0; i < responseArray.length(); i++) {
			JSONObject jsonObject = responseArray.getJSONObject(i);
			
			Integer productID = jsonObject.getInt("productID");
			String productType = jsonObject.getString("productType");
			
			stringBuilder.append(productID.toString());
			stringBuilder.append(": ");
			stringBuilder.append(productType);
			stringBuilder.append("; ");
			
		}
		
		String responseString = stringBuilder.toString();
		System.out.println(responseString);
		
		return responseString;
		
	}
	
}
