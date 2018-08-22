public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end -start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[start]){
                if(target >= nums[start] && target <= nums[mid]) end = mid;
                else start = mid;
            }else{
                if(target >= nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}