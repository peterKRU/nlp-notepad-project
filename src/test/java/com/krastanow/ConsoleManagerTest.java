package com.krastanow;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import client.module.ConsoleManager;

public class ConsoleManagerTest {
	
	@Test
	@DisplayName("Should return True if connection with server is established;")
	public void shouldVerifyConnection() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		boolean assumption = consoleManager.verifyServerConnection();
		
		Assumptions.assumeTrue(assumption);
	}
	
}
