package Arrays;

public class RotateArray {

	public static void main(String[] args) {
		rotate1(new int[] {1,2,3,4,5,6,7}, 3);
		rotate1(new int[] {-1,-100,3,99}, 2);
		rotate1(new int[] {1,2}, 3);
		rotate1(new int[] {1,2,3}, 2);
    }
	
	public static void rotate(int[] nums, int k) {
		
		if(nums.length == 1 || nums.length == k) {
			return;
		}
        
        if(k > nums.length) {
            k = k%nums.length;
        }
		
		int[] tmp = new int[k];
		int tmpCountr = k-1;
		int tmp2Countr = k-1;
		for(int x = nums.length-1; x >= 0 ; x--) {
			if(x >= k-1) {
				if (tmpCountr >= 0) {
					tmp[tmpCountr] = nums[x];
					tmpCountr--;
				}
				nums[x] = nums[x-k];
			} else {
				
				nums[x] = tmp[tmp2Countr];
				tmp2Countr--;
				
			}
			
		}
		for(Integer i : nums) {
			
			System.out.print(i + " ");
		}
	}
	
	public static void rotate1(int[] nums, int k) {
		
		if(nums.length == 1 || nums.length == k) {
			return;
		}
        
		k=k%nums.length;
		
        rev(nums, 0, nums.length-1);
        rev(nums, 0, k-1);
        rev(nums, k, nums.length-1);
	}
	
	public static void rev(int[] nums, int start,int end){
	    while(start<end){
	        int temp = nums[end];
	        nums[end] = nums[start];
	        nums[start] = temp;
	        start++;
	        end--;
	    }
	}
}
