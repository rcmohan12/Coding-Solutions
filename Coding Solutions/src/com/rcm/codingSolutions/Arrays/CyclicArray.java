package com.rcm.codingSolutions.Arrays;

/**
 * Given an array whose elements point to the next index position, determine if it contains a cycle. 
 * encountering a -1 indicates a break in the cycle
 * @author rchandramohan
 *
 */
public class CyclicArray {

	public static void main(String[] args) {
		System.out.println("Cyclic? "+findCycle(new int[] {2,3,-1,4,1,0,-1}));
	}
	
	private static boolean findCycle(int[] inputArr) {
		int fp = 0;
		int sp = 0;
		boolean flag = true;
		int startVal = inputArr[0]; // 2
		int nextIndex = startVal;
		
		while (flag) {
			fp+=1;
			nextIndex = inputArr[nextIndex];
			if(nextIndex == startVal) {
				return true;
			}
			
			if(nextIndex == -1 || nextIndex > inputArr.length-1) {
				return false;
			}
			
			if(fp > inputArr.length-1) {
				return true;
			}
		}
		
		return false;
	}
	
}
