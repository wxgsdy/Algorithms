class Solution {
    public int longestIncreasingContinuousSubsequence(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int res = Integer.MIN_VALUE, ascend = 1, descend = 1;
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] > nums[i - 1]){
                ascend += 1; descend = 1;
            } 
            
            else if(nums[i] < nums[i - 1]){
                ascend = 1; descend += 1;
            }
            else{
                ascend = 1; descend = 1;
            }
            
            res = Math.max(res, Math.max(ascend, descend));            
        }
        return res;         
    }
}