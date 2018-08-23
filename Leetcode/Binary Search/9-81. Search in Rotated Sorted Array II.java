class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return -1;
        
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[start] == target) return start;
            if(nums[end] == target) return end;
            
            // left part
            if(nums[mid] > nums[start]){
                if(nums[mid] > target && target > nums[start]) end = mid;
                else start = mid;
            }
            
            else if(nums[mid] < nums[start]){
                if(nums[mid] < target && target < nums[start]) start = mid;
                else end = mid;
            }
            
            else{
                start++;
            }
        }
        
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
        
    }
}