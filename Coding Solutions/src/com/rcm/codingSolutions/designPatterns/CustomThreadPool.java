package com.rcm.codingSolutions.designPatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomThreadPool {
	
	private List<WorkerTask> _pool;
	private Queue<Runnable> _taskQueue;
	
	public CustomThreadPool(int poolSize) {
		_pool = new ArrayList<WorkerTask>(poolSize);
		_taskQueue = new LinkedList<>();
		createPool(poolSize);
	}
	
	
	public void createPool(int poolSize) {
		
		for(int x = 0; x < poolSize; x++) {
			Thread t = new Thread(new WorkerTask(_taskQueue));
			t.setName("Thread "+x);
			t.start();
			t.setPriority(Thread.MAX_PRIORITY);
		}
		
	}
	
	//TODO : have a submit method to submit tasks to the queue..
	// Execute will start the threads
	// have a method for shutdown, that will lock the queue obj
	
	public void execute(Runnable runnable) {
		_taskQueue.add(runnable);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Thread execution.....");
		CustomThreadPool tp = new CustomThreadPool(4);
		for(int x = 0; x < 25; x++) {
			tp.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Runnable task no "+Math.random());
					
				}
			});
		}
		
		
		
	}

}


class WorkerTask implements Runnable {
	
	private Queue<Runnable> _taskQueue;
	
	public WorkerTask(Queue<Runnable> taskQueue) {
		_taskQueue = taskQueue;
	}
	
	
	public void run() {
		while (true) {
			synchronized (_taskQueue) {
				System.out.println("Run by thread ..." + Thread.currentThread().getName());
				if (!_taskQueue.isEmpty()) {
					Runnable r = _taskQueue.remove();
					r.run();
				} else {
					System.out.println("waiting...");
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
}