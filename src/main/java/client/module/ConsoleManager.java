package client.module;

import java.io.IOException;
import java.util.Scanner;

import local_server.module.Concept;
import local_server.module.Definition;
import local_server.module.Note;

public class ConsoleManager {
	
	private ConfigManager configManager;
	
	public ConsoleManager() throws IOException {
		
		configManager = new ConfigManager("config/config.json");
		
	}
	
	public boolean runConsole() throws IOException {
				
		System.out.println("console: Client running...");
		System.out.println("console: connecting to Server...");
		
		if(verifyServerConnection()) {
			
			System.out.println("console: connected to Server.");
		
		}
		else {
			System.out.println("console: ERROR: failed to connect to Server.");
		}
		
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
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo get all")) {
        		
          		getAllElements();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo get tags")) {
        		
          		getTags();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo get concept")) {
        		//System.out.println("tag? ");
        		String tag = scanner.nextLine();
        		System.out.print("server: ");
        		//requestHandler.requestGetConcept(tag);
        		//requestHandler.requestGetDefinitions(null);
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo get definition")) {
        		
          		getDefinition();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo get note")) {
        		
          		getNote();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo post concept")) {
        		
        		Concept concept = new Concept();
        		
        		createConcept(concept);
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo post definition")) {
        		
        		Definition definition = new Definition();
        		
        		createDefinition();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo post note")) {
        		
        		Note note = new Note();
        		
        		createNote();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	//
        	else if(command.equals("ololo delete concept")) {
        		
        		deleteConcept();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo delete definition")) {
        		
        		deleteDefinition();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo delete note")) {
        		
        		deleteNote();
        		
        		command = scanner.nextLine();
        		continue;
        	}
        	
        	else if(command.equals("ololo exit")) {
            	
        		exitClient();
        	}
        	
        	else {
        		System.out.println("console: " + "Command not recognized: '" + command + "'");
        		command = scanner.nextLine();
        	}
        }
	}
	
	public Boolean verifyServerConnection() {
		
		return true;
	}
	
	public String showVersion() {
		
		String version = configManager.getValue("APPLICATION_VERSION");
		
		return version;
	}
	
	public String showAvailableCommands() {
		
		return null;
	}
	
	public void exitClient() {
		
		System.out.println("console: Terminating...");
		System.exit(0);
	
	}
	
	public String getAllElements() {
		
		return null;
	}
	
	public String getTags() {
		
		return null;
	}
	
	public String getConcept() {
		
		return null;
	}
	
	public String getDefinition() {
		
		return null;
	}
	
	public String getNote() {
		
		return null;
	}
	
	public String createConcept(Concept concept) {
		
		return null;
	}
	
	public String createDefinition() {
		
		return null;
	}
	
	public String createNote() {
		
		return null;
	}
	
	public String deleteConcept() {
		
		return null;
	}
	
	public String deleteDefinition() {
		
		return null;
	}
	
	public String deleteNote() {
		
		return null;
	}
	
}
