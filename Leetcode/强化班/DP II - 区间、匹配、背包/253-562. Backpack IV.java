public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        // write your code here
        
        int m = nums.length, n = target;
        int[][] dp = new int[m + 1][n + 1];
        // 从前i个物品中挑选组成和为j的方案数；
        for(int i = 0; i < m + 1; i++) dp[i][0] = 1;
        for(int j = 0; j < n + 1; j++) dp[0][j] = 0;
        dp[0][0] = 1;
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                int k = 0;
                dp[i][j] = 0;
                while(j - nums[i - 1] * k >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i - 1] * k];
                    k++;
                }
            }
        }
        
        return dp[m][n];
    }
}