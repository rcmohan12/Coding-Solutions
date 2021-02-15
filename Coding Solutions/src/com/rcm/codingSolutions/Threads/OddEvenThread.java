package com.rcm.codingSolutions.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThread {

	public static void main(String[] args) { 
		
//		NumberPrinter num = new NumberPrinter(10);
		NumberPrint num = new NumberPrint(10);
		
		Thread t1 = new Thread(()-> num.printOdd());
		Thread t2 = new Thread(()-> num.printEven());

		t1.setName("Thread 1");
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
		
		System.out.println("Fin");
		
	}
	
}

class NumberPrint {
private int maxCount;
	
	private int counter = 1;
	
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	public NumberPrint(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public void printOdd() {
		lock.lock();

		try {
			while(counter < maxCount) {
				if(counter%2 == 0) {
					try {
						c1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " +counter + " "); 
				counter++;
				c2.signal();
			}
		} finally  {
			lock.unlock();
		}
		
	}
	
	public void printEven() {
		lock.lock();

		try {
			while(counter < maxCount) {
				if(counter%2 == 1) {
					try {
						c2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " +counter + " "); 
				counter++;
				c1.signal();
			}
		} finally  {
			lock.unlock();
		}
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
