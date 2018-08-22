class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid;
            else{
                // nums[mid] > nums[mid + 1]
                if(nums[mid - 1] < nums[mid]) return mid;
                else end = mid;
            }
            
        }
        
        if(nums[start] < nums[end]) return end;
        else return start;
    }
}