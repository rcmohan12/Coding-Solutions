package com.rcm.codingSolutions.LargeInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentlyOccuringElements {
	
	
	static Map<String, Element> map = new HashMap<>();
	static List<Element> list = new ArrayList<Element>();
	
	public static void main(String[] args) {
		String input = "This is is is is is is a a a a a a a a a a a a a a a a test string that i am using to test my code.";
		String[] split = input.split(" ");
		System.out.println("word count :"+split.length);
		for(String word : split) {  // O(n)
			if(map.containsKey(word)) {  // O(1)
				Element ee = map.get(word);
				ee.setCount(ee.getCount()+1);
			} else {
				map.put(word, new Element(word, 1)); // O(1)
			}
		}
		
		List<Element> valList = new ArrayList<Element>(map.values());
		List<Element> sortedList = valList.stream().sorted(Comparator.comparingInt(Element::getCount).reversed()).limit(4).collect(Collectors.toList());
		
		for(Element e : sortedList) {
			System.out.println(e);
		}
		
		System.out.println("Total no. of objects created.."+Element.noOfObjects);
	
	}
	
}

class Element {
	
	public  String word;
	public  int count;
	
	static int noOfObjects = 0; 
	  
    // Instead of performing increment in the constructor 
    // instance block is preferred to make this program generic. 
    { 
        noOfObjects += 1; 
    } 
	
	public Element(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public  String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public boolean equals(Object o) {
		Element e = (Element) o;
		return this.word.equals(e.getWord()) ;
	}
	
	@Override
	public int hashCode() {
		return count;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "Name :"+ word + " Count :"+count;
	}
	
}

