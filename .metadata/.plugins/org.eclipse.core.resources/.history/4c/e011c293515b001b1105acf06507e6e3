package com.rcm.codingSolutions.Strings;

public class AnagramMaxValuesToChange {

	public static void main(String[] args) {
		System.out.println(lettersToRemove("173321"));
	}
	
	static int lettersToRemove(String s) {
		int count=0;
		
		String f = s.substring(0, s.length()/2);
		String l = s.substring(s.length()/2);
		int[] hash = new int[10];
		for (int i = 0; i < f.length(); i++) {
            hash[f.charAt(i) - '0']++;
        }
		
		int[] hash2 = new int[10];
		for (int i = 0; i < l.length(); i++) {
            hash2[l.charAt(i) - '0']++;
        }
		
		for(int i =0; i<10; i++) {
			if(hash[i] > hash2[i]) {
				count +=  hash[i] - hash2[i];
			}
		}
				
		return count;
	}
	
}
