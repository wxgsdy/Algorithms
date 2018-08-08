/*
Given an array of integers, find how many pairs in the array such that their sum is 
bigger than a specific target number. Please return the number of pairs.

*/


public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2) return 0;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int cnt = 0;
        while(left < right){
            if(nums[left] + nums[right] > target){
                cnt = cnt + (right - left);
                right--;

            } else{
                left++;
            }
        }
        return cnt;
    }
}