package com.krastanow;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import client.module.ConfigManager;
import client.module.ConsoleManager;
import local_server.module.Concept;
import local_server.module.Definition;
import local_server.module.Note;

public class ConsoleManagerTest {
	
	@Test
	@DisplayName("Should return True if connection with server is established")
	public void shouldVerifyConnection() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		boolean assumption = consoleManager.verifyServerConnection();
		
		Assumptions.assumeTrue(assumption);
	}
	
	@Test
	@DisplayName("Should return Application Version as String")
	public void shouldReturnVersion() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		ConfigManager configManager = new ConfigManager("config/config.json");
		
		boolean assertion = (consoleManager.showVersion().equals(configManager.getValue("APPLICATION_VERSION")));
		
		Assertions.assertTrue(assertion);
	}
	
	@Test
	@DisplayName("Should return a non-empty ArrayList of available commands as String objects")
	public void shouldReturnAvailableCommands() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		
		boolean assertion = !consoleManager.showAvailableCommands().isEmpty();
		
		Assertions.assertTrue(assertion);
	}
	
	@Test
	@DisplayName("Should post Concept object (id: random, parent: root, tag: UnitTestConcept6969) and return status 201")
	public void shouldPostTestConcept() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		Concept concept = new Concept();
		
		Integer id = concept.getRandomNumber(0, 9999);
		concept.setConceptId(id);
		concept.setParentId(0000);
		concept.setConceptTag("UnitTestConcept6969");
		
		String response = consoleManager.createConcept(concept);
		
		boolean assertValidResponse = (response.equals("201"));
		boolean assertValidId = (concept.getConceptId() == id);
		boolean assertValidParentId = concept.getParentId() == 0000;
		boolean assertValidTag = concept.getConceptTag().equals("UnitTestConcept6969");
		
		Assertions.assertTrue(assertValidResponse);
		Assertions.assertTrue(assertValidId);
		Assertions.assertTrue(assertValidParentId);
		Assertions.assertTrue(assertValidTag);
		
	}
	
	@Test
	@DisplayName("Should post Definition object (id: random, parent: UnitTestConcept6969, tag: UnitTestDefinition6969, payload: ololo) and return status 201;\r\n"
			+ "")
	public void shouldPostTestDefinition() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		Definition definition = new Definition();
		
		String response = consoleManager.createDefinition();
		
		boolean assertion = (response.equals("201"));
		Assertions.assertTrue(assertion);
		
	}
	
	@Test
	@DisplayName("Should post Definition object (id: random, parent: UnitTestConcept6969, tag: UnitTestNote6969, payload: elele) return status 201")
	public void shouldPostTestNote() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		Note note = new Note();
		
		String response = consoleManager.createNote();
		
		boolean assertion = (response.equals("201"));
		Assertions.assertTrue(assertion);
		
	}
	
	@Test
	@DisplayName("Should return String representation of the UnitTestConcept6969 Concept object")
	public void shouldReturnTestConceptAsString() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		
		String response = consoleManager.getConcept();
		
		boolean assertion = response.equals("UnitTestConcept6969");
		
		
		Assertions.assertTrue(assertion);
		
	}
	
	@Test
	@DisplayName("Should delete Concept entry and return status 200")
	public void shouldDeleteTestConcept() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		
		String response = consoleManager.deleteConcept();
		
		boolean assertion = (response.equals("200"));
		Assertions.assertTrue(assertion);
		
	}
	
	@Test
	@DisplayName("Should delete Definition entry and return status 200")
	public void shouldDeleteTestDefinition() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		
		String response = consoleManager.deleteNote();
		
		boolean assertion = (response.equals("200"));
		Assertions.assertTrue(assertion);
		
	}
	
	@Test
	@DisplayName("Should delete Note entry and return status 200")
	public void shouldDeleteTestNote() throws IOException {
		
		ConsoleManager consoleManager = new ConsoleManager();
		
		String response = consoleManager.deleteNote();
		
		boolean assertion = (response.equals("200"));
		Assertions.assertTrue(assertion);
		
	}
	
}
