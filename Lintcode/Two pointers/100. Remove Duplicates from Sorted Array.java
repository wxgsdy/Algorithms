public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != nums[left]){
                nums[++left] = nums[right];
            }
            right++;
        }
        return left  + 1;
        
    }
}