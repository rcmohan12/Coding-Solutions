package com.rcm.codingSolutions.Threads;

public class OddEvenThread {

	public static void main(String[] args) { 
		
		NumberPrinter num = new NumberPrinter(10);
		
		Thread t1 = new Thread(()-> num.printOdd());
		Thread t2 = new Thread(()-> num.printEven());

		t1.setName("Thread 1");
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
		
		System.out.println("Fin");
		
	}
	
}


class NumberPrinter {
	
	private int maxCount;
	
	private int counter = 1;
	
	public NumberPrinter(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public void printOdd() {
		synchronized (this) 
        { 
			while (counter < maxCount) {
				// if the number is even we wait
				while(counter%2 == 0) {
					try {
						wait();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				System.out.println(Thread.currentThread().getName() + " : " +counter + " "); 
				counter++;
				notify();
			}
        }
		
	}
	
	public void printEven() {
		synchronized (this) 
        { 
			while (counter < maxCount) {
				while(counter%2 == 1) {
					try {
						wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " +counter + " "); 
				counter++;
				notify();
			}
        }
	}
	
}
