package com.rcm.codingSolutions.Strings;

public class IndexOf {
	public static void main(String[] args) {
		System.out.println(indexOF("sd", "fbdsfsdfsd"));
	}

	public static int indexOF(String haystack, String needle) {
		int index = -1;
		
		if(haystack.isEmpty() || needle.isEmpty()) {
			return -1;
		}
		
		if(haystack.length() < needle.length()) {
			return -1;
		}
		
		for(int x = 0 ; x <= haystack.length()-needle.length(); x ++) {
			String match = haystack.substring(x, x+needle.length());
			if(match.equals(needle)) {
				return x;
			}
		}
		
		return index;
	}

}
