package com.rcm.codingSolutions.Strings;
/**
 * You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

 * Your task is to find the minimum number of required deletions.

 * Example

 * Remove an  at positions  and  to make  in  deletions.
 * 
 *
 */
public class AlternatingCharacters {
	public static void main(String[] args) {
		System.out.println(findMinVal("AAAAABB"));
    }
	
	public static int findMinVal(String s) {
		int count=0;
		
		for(int x=0; x < s.length(); x++) {
			if(x+1<s.length() &&
					s.charAt(x) == s.charAt(x+1)) {
				count++;
			}
		}
		
		return count;
	}
}
