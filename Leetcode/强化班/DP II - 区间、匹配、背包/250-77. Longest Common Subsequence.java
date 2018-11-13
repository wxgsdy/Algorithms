public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1]; 
        // dp[i][j] 表示A的前i个和B的前[j]个能匹配上的subsequenc的长度
        
        // initialize 
        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, Math.max(dp[i-1][j], dp[i][j-1]));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            } 
        }
        
        return dp[m][n];
        
    }
}




public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        
        int m = A.length(), n = B.length();
        int[][] dp = new int[3][n + 1]; 
        // dp[i][j] 表示A的前i个和B的前[j]个能匹配上的subsequenc的长度
        
        // initialize 
        for(int i = 0; i <= 2; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i % 3][j] = Math.max(dp[(i-1) % 3][j-1] + 1, Math.max(dp[(i-1) % 3][j], dp[i % 3][j-1]));
                } else {
                    dp[i % 3][j] = Math.max(dp[(i-1) % 3][j], dp[i % 3][j-1]);
                }
            } 
        }
        
        return dp[m % 3][n];
        
    }
}