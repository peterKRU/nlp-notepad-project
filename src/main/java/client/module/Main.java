package client.module;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;

import local_server.module.Concept;

public class Main {

	public static void main(String[] args) throws InterruptedException, SQLException, UnsupportedEncodingException, IOException {
		
		String[] availableCommands = {"version: shows current version", "get concept + tag: pulls concept with the specified tag from repository", "post concept: posts new concept to repository"};
		
		System.out.println("console: Client running...");
		
		MockRequestSender mockRequestSender = new MockRequestSender();
		
		//mockRequestSender.testPostRequest();
		//mockRequestSender.testGetConceptRequest("root");
		//mockRequestSender.testRequests(null);
		
		RequestHandler requestHandler = new RequestHandler();
		
        Scanner scanner = new Scanner(System.in);
        System.out.print(":");
        String command = scanner.nextLine();
        
        while(true) {
        	
        	if(command.equals("ololo version")) {
        		System.out.println("console: version 1.0.0");
        		command = scanner.nextLine();
        		continue;
        	}
        	else if(command.equals("ololo available commands")) {
        		
        		System.out.println("console: Available commands: ");
        		
        		for(int i = 0; i < availableCommands.length; i++) {
        			System.out.println("----" + availableCommands[i]);
        		}
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	else if(command.equals("ololo post concept")) {
        		
        		Concept concept = new Concept();
        		System.out.println("tag? ");
        		String tag = scanner.nextLine();
        		concept.setConceptTag(tag);
        		concept.setConceptId(mockRequestSender.getRandomNumber(0, 9999));
        		concept.setParentId(0000);
        		String response = requestHandler.requestPostConcept(concept);
        		
        		System.out.println("server: " + response);
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	else if(command.equals("ololo get concept")) {
        		System.out.println("tag? ");
        		String tag = scanner.nextLine();
        		System.out.print("server: ");
        		requestHandler.requestGetConcept(tag);
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	else if(command.equals("ololo exit")) {
            	System.out.println("console: Terminating...");
            	System.exit(0);
        	}
        	else {
        		System.out.println("console: " + "Command not recognized: '" + command + "'");
        		command = scanner.nextLine();
        	}
        }
        
		
	}

	
}
