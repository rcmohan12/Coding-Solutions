package com.rcm.codingSolutions.Strings;

import java.util.Arrays;

/**
 * A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

s = mnonopoo
{m, n, o, n, o, p, o, o, non, ono, opo, oo}

 *
 */
public class SpecialStringAgain {
	public static void main(String[] args) {
		System.out.println(substrCount(9, "aaaabaaaa"));
    }
	
	static long substrCount(int n, String s) {
		// initialize counter to n because each character is a
	    // palindromic string
	    int counter = s.length();
					
	    // to count consecutive characters that are the same
	    int consec = 1;
					
	    // the middle index of a 3-character symmetry,
	    // assigned only once detected
	    int midIndex = -1;
					
	    // compare with previous character so start with i=1
	    for (int i = 1; i < n; i++) {
	        if (s.charAt(i) == s.charAt(i-1)) {
	            // Condition 1: All of the characters are the same
	            // For n consecutive characters that are the same,
	            // we have this formula:
	            // Number of palindromic strings =
	            //     (n-1) + (n-2) + ... + (n-(n-1))
	            counter += consec;
	            consec++;
	                
	            // Condition 2: All characters except the middle one
	            // are the same
	            if (midIndex > 0) {
	                // check for symmetry on both sides
	                // of the midIndex
	                if ((midIndex-consec) > 0 && s.charAt(midIndex-consec) == s.charAt(i)) {
	                    counter++;
	                } else {
	                    // no more possibility of palindromic string
	                    // with this midIndex
	                    midIndex = -1; 
	                }
	            }
	        } else {
	            // reset consecutive chars counter to 1
	            consec = 1;
	                
	            // check for a 3-character symmetry
	            if (((i-2) >= 0) && s.charAt(i-2) == s.charAt(i)) {
	                counter++; // 3-char symmetry is detected
	                    
	                // to check if the next characters are the same
	                // and symmetrical along the midIndex
	                midIndex = i-1;
	            } else {
	                midIndex = -1;
	            }
	        }
	    }
	    return counter;
    }
}
