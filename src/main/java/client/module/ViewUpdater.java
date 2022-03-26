package client.module;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import request.library.*;

public class ViewUpdater implements Runnable{
	
	private BlockingQueue<Product> productIn;
	private HashMap<String,Updater> updaterMap;
	
	public ViewUpdater(BlockingQueue<Product> productIn, HashMap<String,Updater> updaterMap) {
		
		this.productIn = productIn;
		this.updaterMap = updaterMap;
		
	} 
	
	@Override
	public void run() {
		
		while(!this.productIn.isEmpty()) {
			
			if(updaterMap.containsKey(productIn.peek().getTargetComponent())) {
				
				try {
					
					String updaterKey = productIn.peek().getTargetComponent();
					String resultString = productIn.peek().getResultString();
					Updater updaterComponent = updaterMap.get(updaterKey);
					
					updaterComponent.updateElement(resultString);
			
					productIn.take();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		}
	
	}

}
