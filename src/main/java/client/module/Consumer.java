package client.module;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import request.library.*;

public class Consumer implements Runnable{
	
	private BlockingQueue<Request> queue;
	
	public Consumer(BlockingQueue<Request> queue) {
		
		this.queue = queue;
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			Request element;
			try {
				element = this.queue.take();
				System.out.println("consumed: " + element);
				
				System.out.println("Running...");
				for(int i = 0; i < 10; i++) {
					
					Thread.sleep(100);
					System.out.println(i);
					
				}
				System.out.println("Done.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
