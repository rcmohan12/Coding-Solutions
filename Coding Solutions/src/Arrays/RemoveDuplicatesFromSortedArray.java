package Arrays;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 5, 5}));
    }
	
	public static int removeDuplicates(int[] nums) {
        
        int shiftIndex = 0;
        int unique = 1;
        
        for(int x = 1; x < nums.length; x++) {
            if((nums[x] == nums[x-1]) && shiftIndex == 0) {
                shiftIndex = x; 
            } else if ((nums[x] != nums[x-1]) && shiftIndex != 0) {
            	nums[shiftIndex] = nums[x];
            	shiftIndex++;
            	unique++;
            } else if((nums[x] != nums[x-1])) {
            	unique++;
            }
        }
        
        //DEBUG only, will cause memory issues otherwise
        /*for(int i : nums) {
        	System.out.print(i+ " ");
        }*/
        return unique;
    }
	
	public static int removeDuplicatesRefined(int[] nums) {
		int i = 0;
        for (int j = 0; j < nums.length; j++){
            
            if (j > 0 && nums[j] == nums[j-1])
                continue;
            nums[i++] = nums[j];
        }
        
        return i;
	}
	
}
