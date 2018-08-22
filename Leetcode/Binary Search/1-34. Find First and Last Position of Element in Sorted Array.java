public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        
        // Acutually find the first and last pointer
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;
        
        // search for first pointer
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) end = mid;
            else if(nums[mid] < target) start = mid;
            else end = mid;
        }
        
        if(nums[start] == target) res[0] = start;
        else if(nums[end] == target) res[0] = end;
        
        
        
        // search for last pointer
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) start = mid;
            else if(nums[mid] < target) start = mid;
            else end = mid;
        }
        
        if(nums[end] == target) res[1] = end;
        else if(nums[start] == target) res[1] = start;
        
        
        return res;
    }
}