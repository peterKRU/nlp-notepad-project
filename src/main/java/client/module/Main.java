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
		
		System.out.println("Client running...");
		
		//MockRequestSender mockRequestSender = new MockRequestSender();
		
		//mockRequestSender.testPostRequest();
		//mockRequestSender.testGetConceptRequest("root");
		//mockRequestSender.testRequests(null);
		
		Console console = System.console();
		
		while(true) {
			
			if(console != null) {
				
				console.writer().println("Console avaliable.");
				System.out.println("...");
				
				String inputCommand = console.readLine();
				
				if(inputCommand == "1") {
					System.out.println("ololo");
				}
				else if(inputCommand == "exit") {
					
					System.out.println("Terminating Console...");
					break;
				}
				
			}
			else {
				System.err.println("Error: Console not available.");
				break;
			}
			
		}
		
		
	}

}
