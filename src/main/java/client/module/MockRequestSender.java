package client.module;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import local_server.module.Concept;
import local_server.module.Definition;
import local_server.module.Note;

public class MockRequestSender {
	
	public MockRequestSender() {
		
	}
	
	public void testPostRequest() throws IOException {
		
		int root = 0000;
		int id = getRandomNumber(1, 9999);
		Concept concept = new Concept();
		concept.setConceptId(id);
		concept.setParentId(root);
		concept.setConceptTag("elelelele");
		
		RequestHandler requestHandler = new RequestHandler();
		requestHandler.requestPostConcept(concept);
		
	}
	
	public void testGetConceptRequest(String tag) throws MalformedURLException {
		
		RequestHandler requestHandler = new RequestHandler();
		requestHandler.requestGetConcept(tag);
	
	}
	
	public void testAllRequests() {
		
		int id = getRandomNumber(1, 9999);
		
		RequestHandler requestHandler = new RequestHandler();
		
		Concept concept = new Concept();
		Definition definition = new Definition();
		Note note = new Note();
		
		requestHandler.requestGetAll();
		requestHandler.requestGetTags();
		//requestHandler.requestGetConcept("");
		requestHandler.requestGetDefinition("");
		requestHandler.requestGetNote("");
		
		try {
			requestHandler.requestPostConcept(concept);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		requestHandler.requestPostDefinition(definition);
		requestHandler.requestPostNote(note);
		
		requestHandler.requestDeleteConcept("");
		requestHandler.requestDeleteDefinition("");
		requestHandler.requestDeleteNote("");
		
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
}
