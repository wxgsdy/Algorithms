public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int start = 0, end = nums.length - 1;
        int cmp = nums[end];
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > cmp) start = mid;
            else end = mid;
        }
        
        if(nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}