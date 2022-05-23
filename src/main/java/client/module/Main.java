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
		
		ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.runConsole();
		
	}

	
}
