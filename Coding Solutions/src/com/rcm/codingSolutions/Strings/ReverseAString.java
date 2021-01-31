package com.rcm.codingSolutions.Strings;

public class ReverseAString {
	
	public static void main(String[] args) {
		reverseString(new char[] { 'r', 'o', 'p', 'a' });
	}

	public static void reverseString(char[] s) {
		if (s.length == 0 || s.length == 1) {
			return;
		}
		
		for(int x = 0, y=s.length-1; x < s.length/2; x++, y--) {
			char tmp = s[y];
			s[y] = s[x];
			s[x] = tmp;
		}
		
		for(char i : s) {
			System.out.println(i + " ");
		}
		
	}
}
