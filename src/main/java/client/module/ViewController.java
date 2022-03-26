package client.module;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.SwingWorker;

import client.module.ViewController.TokenizeListener.DetectSentencesListener;
import request.library.*;

public class ViewController {
	
	private ClientView clientView;
	
	private ViewUpdater viewUpdater;
	
	private TokenizeListener tokenizeListener;
	private DetectSentencesListener detectSentencesListener;
	
	private volatile BlockingQueue<Request> requestOut;
	private volatile BlockingQueue<Product> productIn;
	
	private int flowIn;
	private int flowOut;
	private int lastID;
	
	private volatile HashMap<String, Updater> updaterMap;
	
	public ViewController(ClientView clientView) {
		
		this.clientView = clientView;
		
		flowIn = 5;
		flowOut = 5;
		lastID = 0; 
		
		requestOut = new ArrayBlockingQueue<Request>(flowOut);
		productIn = new ArrayBlockingQueue<Product>(flowIn);
		
		setupActionListeners();
		
		updaterMap = new HashMap<String, Updater>();
		setupUpdaterMap();

		viewUpdater = new ViewUpdater(productIn, updaterMap);
		
		Thread viewUpdaterThread = new Thread(viewUpdater);
		viewUpdaterThread.start();
		
	}
	
	public void setupUpdaterMap() {
			
		updaterMap.put("TokenizeListener", tokenizeListener);
		updaterMap.put("DetectSentencesListener", detectSentencesListener);
		
		
	}
	
	public void setupActionListeners() {
		
		tokenizeListener = new TokenizeListener();
		
		this.clientView.addTokenizeListener(tokenizeListener);	
		this.clientView.addDetectSentencesListener(detectSentencesListener);
		
	}
	
	class TokenizeListener extends Updater implements ActionListener {
		
		private String type = "TokenizeText";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Request newRequest = new Request(type, lastID +1);
			
			try {
				
				requestOut.put(newRequest);
				lastID++;
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}		


	
	class DetectSentencesListener extends Updater implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("ololo");
			
		}

	}

	public int getFlowIn() {
		return flowIn;
	}


	public int getFlowOut() {
		return flowOut;
	}



	public BlockingQueue<Request> getRequestOut() {
		return requestOut;
	}



	public BlockingQueue<Product> getProductIn() {
		return productIn;
	}


	public int getLastID() {
		return lastID;
	}


	public HashMap<String, Updater> getUpdaterMap() {
		return updaterMap;
	}
	
}

	public BlockingQueue<Request> getRequestOut() {
		return requestOut;
	}

	public void setRequestOut(BlockingQueue<Request> requestOut) {
		this.requestOut = requestOut;
	}
}