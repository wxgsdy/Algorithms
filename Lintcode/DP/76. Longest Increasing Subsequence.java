public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        
        // state array
        int[] f = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
        }
        
        // seach
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
                
            }
        }
        
        // find max value of f
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < f.length; i++){
            if(result < f[i]){
                result = f[i];
            }
        }
        
        return result;
    }
}