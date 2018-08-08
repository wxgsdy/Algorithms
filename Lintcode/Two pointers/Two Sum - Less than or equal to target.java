/* Description:
Given an array of integers, find how many pairs in the array 
such that their sum is less than or equal to a specific target number. 
Please return the number of pairs.
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        if(nums == null || nums.length < 2) return 0;

        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        int cnt = 0;
        while(left < right){
        	if(nums[left] + nums[right] <= target){
        		cnt = cnt + right - left;
        		left++;
        	} else{
        		right--;
        	}
        }
        return cnt;

        
    }
}