class Solution {
    
    public int maxCoins(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n]; // dp[i][j] 从第i个气球戳到第j个的最大得分
        
        // initialize
        int left = 1, right = 1;
        for(int i = 0; i < n; i++){
            // nums[i - 1] * nums[i] * nums[i + 1]
            left = (i - 1 >= 0) ? nums[i - 1] : 1;
            right = (i + 1 < n) ? nums[i + 1] : 1;
            dp[i][i] = left * nums[i] * right;
        }
        
        // transfer function 
        // i <= k <= j
        // dp[i][j] = max( dp[i][k - 1] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j + 1])
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                dp[i][j] = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    
                    int prev = (k - 1 >= 0) ? dp[i][k - 1] : 0;
                    int next = (k + 1 < n) ? dp[k + 1][j] : 0;
                    left = (i - 1 >= 0) ? nums[i - 1] : 1;
                    right = (j + 1 < n) ? nums[j + 1] : 1;                    
                    dp[i][j] = Math.max(dp[i][j], prev + next + left * nums[k] * right);
                }
            }
        }
        
        return dp[0][n - 1];
         
    }
    
}