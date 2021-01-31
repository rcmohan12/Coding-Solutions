package Arrays;

import java.util.Arrays;

public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {4,1,2,1,2}));
    }
	
	public static int singleNumber(int[] nums) {
		int duplicate = -1;
		
		if(nums.length == 1) {
			return nums[0];
		}
		
		int result = 0;
        for(int i : nums) {
            result = result^i;
        }
        return result;
		
		
//		Arrays.sort(nums);
//		for(int x = 0; x < nums.length; x+=2) {
//			if(x == nums.length -1) {
//				return nums[x];
//			}
//			if(nums[x] != nums[x+1]) {
//				return nums[x];
//			}
//		}
		
//		return duplicate;
	}
}
