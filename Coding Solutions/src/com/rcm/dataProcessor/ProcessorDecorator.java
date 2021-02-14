package com.rcm.dataProcessor;

public abstract class ProcessorDecorator implements Data {
	public Data data;
	public ProcessorDecorator(Data data) {
		this.data = data;
	}
	
	@Override
	public void readData() {
		data.readData();
	}

	@Override
	public void processData() {
		data.processData();
	}

	
	@Override
	public void formatData() {
		data.formatData();
	}
	
}
