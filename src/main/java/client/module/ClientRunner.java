package client.module;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import request.library.*;

public class ClientRunner {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		

	}
	
	public static void runView() {
		
		ClientView clientView = new ClientView();
		ViewController viewController = new ViewController(clientView);	
			
		Consumer consumer = new Consumer(viewController.getRequestOut());
		Thread consumerThread = new Thread(consumer);
		
		consumerThread.start();
		
	}
	
	public static void runWithoutView() throws InterruptedException{
		
		System.out.println("Starting...");
		
		for(int i = 0; i < 20; i++) {
			
			Thread.sleep(100);
			System.out.println(i);
		
		}
		
		System.out.println("Running...");
		
	}
	
}
