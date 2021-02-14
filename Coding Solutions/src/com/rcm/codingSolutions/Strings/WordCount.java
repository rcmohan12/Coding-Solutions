package com.rcm.codingSolutions.Strings;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	public static void main(String[] args) {
		String[] words = { "hello", "world", "HELLO", "WORLD" };
//		count(words);
		System.out.println(runLength("yyyybbbbdexxxxxxx"));
//		System.out.println(checkPalindrome("amma"));
	}

	public static String runLength(String str) {
		String op = "";
		int counter = 1;
		
		
		String[] strArr = str.split("");
		for(int x = 1; x < strArr.length; x++) {
			if(strArr[x].equalsIgnoreCase(strArr[x-1])) {
				counter++;
			} else {
				op = op+strArr[x-1]+counter;
				counter = 1;
			}
			if(x==strArr.length-1) {
				op = op+strArr[x-1]+counter;
			}
		}
		
		return op;
	}
	
	public static void count(String[] words) {
		Map<String, Integer> wordMap = new HashMap<>();
		for(String s : words) {
			wordMap.put(s.toLowerCase(), wordMap.getOrDefault(s.toLowerCase(), 0)+1);
		}
		
		for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	public static boolean checkPalindrome(String word) {
		String[] arr = word.split("");
		for(int x=0, y=arr.length-1; x<arr.length/2; x++,y--) {
			if(!arr[x].equals(arr[y])) {
				return false;
			}
		}
		return true;
	}
	
}
 