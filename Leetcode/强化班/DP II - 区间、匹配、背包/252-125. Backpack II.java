public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        // 从前i个物品中构成j的总size 所能实现的最大价值
        
        for(int i = 0; i < n + 1; i++) dp[i][0] = 0;
        for(int j = 0; j < m + 1; j++) dp[0][j] = 0;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                dp[i][j] = dp[i - 1][j];
                if(j - A[i - 1] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[n][m];
        
        
        
        
        
    }
}