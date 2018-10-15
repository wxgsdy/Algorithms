public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        
        if(values == null || values.length == 0) return false;
        int n = values.length;
        
        int[][] sum = new int[n][n];
        int[][] f = new int[n][n];
        
        // initialize 
        for(int i = 0; i < n; i++){
            sum[i][i] = values[i];
            f[i][i] = values[i];
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                
                sum[i][j] = values[i] + sum[i + 1][j];
                f[i][j] = sum[i][j] - Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        
        return f[0][n - 1] > sum[0][n - 1] - f[0][n - 1];
    }
}