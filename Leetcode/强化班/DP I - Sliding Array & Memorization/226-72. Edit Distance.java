class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; // 表示从word1的前i字符变成word2的前j字符的最小变换数目；
        
        // inititalize 
        dp[0][0] = 0;
        for(int i = 1; i < m + 1; i++) dp[i][0] = i; // delete
        for(int j = 1; j < n + 1; j++) dp[0][j] = j; // insert
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}