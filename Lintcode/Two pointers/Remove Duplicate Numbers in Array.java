/*  Description:
Given an array of integers, remove the duplicate numbers in it.

You should:

Do it in place in the array.
Move the unique numbers to the front of the array.
Return the total number of the unique numbers.

*/ 

// Method 1: Using HashSet: take O(n) time and O(n) space;
// Mathod 2: Sorting then in place move; takes O(nlogn) time and O(1) space

public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        // in place move 
        int left = 0, right = 0;
        while(right < nums.length){
        	if(nums[left] != nums[right]){
        		nums[++left] = nums[right];
        	}        	
        }
        return left + 1;
    }
}