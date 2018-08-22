public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        
        
        // idea: compare nums[mid] with nums[mid + 1]
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid;  // mid in the rising interval
            else end = mid;
        }
        
        if(nums[start] > nums[end]) return nums[start];
        else return nums[end];
    }
}