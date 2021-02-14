package com.rcm.codingSolutions.designPatterns;

public class Singleton {
	
	private static Singleton _singleton;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		
		if(_singleton == null) {
			_singleton = new Singleton();
		}
		
		return _singleton;
	}
	

}

class TestSingleton {
	public static void main(String[] args) {
		
		Singleton one = Singleton.getInstance();
		Singleton two = Singleton.getInstance();
		if(one.equals(two)) {
			System.out.println("It works...");
		}
		
		
	}
}
 