package com.rcm.codingSolutions.Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
	
	public static void main(String[] args) {
		/*System.out.println(firstUniqChar("cc"));
		char x = 0 + 'a';
		System.out.println(String.valueOf(x));*/
		
		Map<String, Integer> map = new HashMap<>();
		map.put("ROOPA", 1);
		map.put("roopa", 2);
		System.out.println(map.get("ROOPA"));
		
		String name = "roo";
		String rr = "ROO";
		System.out.println(name.hashCode());
		System.out.println(rr.toLowerCase().hashCode());
		
	}

	public static int firstUniqChar(String s) {
		int index = 0;
		
		if(s.isEmpty()) {
			return 0;
		} 
		if(s.length() == 1) {
			return 0;
		}
		
		char[] al = new char[26];
		for(int x = 0; x < s.length(); x++) {
			al[s.charAt(x) - 'a']++;
		}
		
		
		
		int firstOc = Integer.MAX_VALUE;
		for(int x = 0; x < al.length; x++) {
			if(al[x] == 1) {
				char y = (char) ((char)x + 'a');
				firstOc = Math.min(firstOc, s.indexOf(String.valueOf(y)));
			}
		}
		
		return firstOc == Integer.MAX_VALUE ? -1 : firstOc;
	}
}
