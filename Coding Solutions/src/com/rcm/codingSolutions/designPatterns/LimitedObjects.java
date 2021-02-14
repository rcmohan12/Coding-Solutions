package com.rcm.codingSolutions.designPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LimitedObjects {
	
	private static List<LimitedObjects> _list = new ArrayList<>();
	
	private static final int _MAX_OBJECTS = 10;
	
	private LimitedObjects() {
		
	}
	
	public static LimitedObjects getInstance() {
		LimitedObjects obj;
		
		if(_list.size() < 10) {
			obj = new LimitedObjects();
			_list.add(obj);
		} else {
			obj = _list.get(new Random().ints(0, _MAX_OBJECTS-1).findFirst().getAsInt());
		}
		
		return obj;
	}

	
	public static void main(String[] args) {
		List<LimitedObjects> testList = new ArrayList<LimitedObjects>();
		
		for(int x = 0; x < 100; x++) {
			LimitedObjects o = getInstance();
			if(!testList.contains(o)) {
				testList.add(o);
			} 
		}
		
		System.out.println("how many finally? "+testList.size());
		System.out.println("how many finally in main? "+_list.size());
	}
}
