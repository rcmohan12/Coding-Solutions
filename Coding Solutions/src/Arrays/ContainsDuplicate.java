package Arrays;

import java.util.Arrays;

public class ContainsDuplicate {
	
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] {0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 5, 5}));
    }
	
	public static boolean containsDuplicate(int[] nums) {
		boolean duplicate = false;
		
		if(nums.length == 1) {
			return false;
		}
		
		if(nums.length == 2) {
			if(nums[0] == nums[1]) {
				return true;
			} else {
				return false;
			}
		}
		
		
		Arrays.sort(nums);
		
	    for (int i = 0; i < nums.length - 1; ++i) {
	        if (nums[i] == nums[i + 1]) {
	        	return true;
	        }
	    }
		
//		Brute force
//		for(int x = 0; x < nums.length; x++) {
//			for(int y = x+1; y < nums.length; y++) {
//				if(nums[x] == nums[y]) {
//					return true;
//				}
//			}
//		}
		

		return duplicate;
	}
}
