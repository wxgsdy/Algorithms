class Solution {
    
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        
        int[][] dp = new int[n][n]; // dp[i][j] 表示从i到j先手能取得的最多石子数目
        int[][] sum = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[i][i] = piles[i];      
            sum[i][i] = piles[i];
        }
        
        // function       
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                sum[i][j] = sum[i][j - 1] + piles[j];
                dp[i][j] = sum[i][j] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[0][n-1] > sum[0][n - 1] - dp[0][n - 1];
        
        
    }
}