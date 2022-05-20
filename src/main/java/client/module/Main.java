package client.module;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;

import local_server.module.Concept;

public class Main {

	public static void main(String[] args) throws InterruptedException, SQLException, UnsupportedEncodingException, IOException {
		
		System.out.println("Client running...");
		
		//MockRequestSender mockRequestSender = new MockRequestSender();
		
		//mockRequestSender.testPostRequest();
		//mockRequestSender.testGetConceptRequest("root");
		//mockRequestSender.testRequests(null);
		
		Console console = System.console();
		
		if(console != null) {
			System.out.println("Console avaliable.");
		}
		else {
			System.out.println("Error: Console not available.");
		}
		
	}

}
