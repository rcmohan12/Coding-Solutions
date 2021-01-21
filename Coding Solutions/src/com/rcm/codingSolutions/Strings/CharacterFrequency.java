package com.rcm.codingSolutions.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 * Example
 * This is a valid string because frequencies are .
 * This is a valid string because we can remove one  and have  of each character in the remaining string.
 * This string is not valid as we can only remove  occurrence of . That leaves character frequencies of .
 *
 */
public class CharacterFrequency {

	public static void main(String[] args) {
		System.out.println(isValid("aaab"));
    }
	
	public static String isValid(String s) {
		int counter = 0;
		String YES = "YES";
		String NO = "NO";
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		int[] hash = new int[26];
		
		if(s.isEmpty()) return NO;
		
		
		for(int x = 0; x < s.length(); x++) { // O(n)
			hash[s.charAt(x) - 'a']++;
		}
		
		for(int x = 0; x < 25; x++) {
			if(hash[x] != 0) {
				int count = frequencyMap.getOrDefault(hash[x], 0); 
				frequencyMap.put(hash[x], count + 1); 
			}
		}
        
        if(frequencyMap.keySet().size() > 2) {
            return NO;
        } else if(frequencyMap.keySet().size() == 1) {
			return YES;
		}  else {
			
			List<Integer> keys = new ArrayList<>();
			List<Integer> vals = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
				keys.add(entry.getKey());
				vals.add(entry.getValue());
			}
			
			if(((Math.abs(keys.get(0) - keys.get(1)) == 1) && (vals.get(0) ==1 || vals.get(1) == 1))
					|| (keys.get(0) == 1 && vals.get(0) == 1) 
					|| (keys.get(1) == 1 && vals.get(1) == 1)) {
				
			} else {
				return NO;
			}
			
			for(Integer i : frequencyMap.values()) {
                if(i > 1) {
                    counter++;
                }
            }
           
            if(counter > 1) {
                return NO;
            } else {
                return YES;
            }
        }
	}
	
}
