package com.rcm.dataProcessor;

public class XLProcessor extends ProcessorDecorator{

	public XLProcessor(Data data) {
		super(data);
	}

	@Override
	public void readData() {
		data.readData();
	}

	@Override
	public void processData() {
		data.processData();
		System.out.println("Processing XL data");
	}

	
	@Override
	public void formatData() {
		data.formatData();
	}
	

}
