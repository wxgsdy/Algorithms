public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        // 前 i 个item 能否实现和 为 j
        for(int j = 0; j <= m; j++) dp[0][j] = false;
        for(int i = 0; i <= n; i++) dp[i][0] = true;
        dp[0][0] = true;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                
                if(j - A[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j - A[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int res = 0;
        for(int j = 0; j < m + 1; j++){
            if(dp[n][j]) res = j;
        }
        return res;
        
    }
}