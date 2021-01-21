package com.rcm.codingSolutions.Strings;

import java.util.Arrays;

public class AnagramMaxValuesToRemove {
	
	public static void main(String[] args) {
		System.out.println(makeAnagram("roo", "rooooopa"));
    }
	
	static int makeAnagram(String first, String second) {

		int[] hash = new int[26];
		Arrays.fill(hash, 0);
		for (int i = 0; i < first.length(); i++) {
			hash[first.charAt(i) - 'a']++;
		}
		for (int i = 0; i < second.length(); i++) {
			hash[second.charAt(i) - 'a']--;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (hash[i] != 0)
				count += Math.abs(hash[i]);
		}
		return count;

	}
    
    public static String rev(String str) {
    	return new StringBuilder(str).reverse().toString();
    }
	
}