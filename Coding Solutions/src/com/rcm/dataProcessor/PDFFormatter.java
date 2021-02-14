package com.rcm.dataProcessor;

public class PDFFormatter extends FromattingDecorator {

	public PDFFormatter(Data data) {
		super(data);
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
		System.out.println("Formatting and serializing as XL");
	}

}
