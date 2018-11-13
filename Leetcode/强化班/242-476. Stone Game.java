public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
            sum[i][i] = A[i];
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                sum[i][j] = sum[i][j - 1] + A[j];
                int temp = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    temp = Math.min(temp, dp[i][k] + dp[k + 1][j] + sum[i][j]);
                }
                dp[i][j] = temp;
            }
        }
        
        return dp[0][n - 1];
    }
}