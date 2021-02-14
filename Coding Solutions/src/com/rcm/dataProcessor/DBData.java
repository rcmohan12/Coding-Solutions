package com.rcm.dataProcessor;

public class DBData implements Data {

	@Override
	public void readData() {
		System.out.println("Reading data from the DB");
		
	}

	@Override
	public void processData() {
		System.out.println("Start processing data");
	}

	
	@Override
	public void formatData() {
		System.out.println("start Formatting");
	}
	
}
