public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        
        if(values == null || values.length <= 2) return true;
        
        int n = values.length;
        int[] sumAfter = new int[n];
        
        int sum = 0;
        for(int index = n - 1; index >= 0; index--){
            sum += values[index];
            sumAfter[index] = sum;
        }
        
        int[] f = new int[n];
        f[n - 1] = values[n - 1];
        f[n - 2] = values[n - 1] + values[n - 2];
        for(int i = n - 3; i >= 0; i--){
            f[i] = Math.max( values[i] + sumAfter[i + 1] - f[i + 1],
                             values[i] + values[i + 1] + sumAfter[i + 2] - f[i + 2] );
        }
        
        return f[0] > sumAfter[0] - f[0];
        
        
    }
}





public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        
        if(values == null || values.length <= 2) return true;
        
        int n = values.length;
        int[] sumAfter = new int[n];
        
        int sum = 0;
        for(int index = n - 1; index >= 0; index--){
            sum += values[index];
            sumAfter[index] = sum;
        }
        
        int[] f = new int[3];
        f[(n - 1) % 3] = values[n - 1];
        f[(n - 2) % 3] = values[n - 1] + values[n - 2];
        for(int i = n - 3; i >= 0; i--){
            f[i % 3] = Math.max( values[i] + sumAfter[i + 1] - f[(i + 1) % 3],
                             values[i] + values[i + 1] + sumAfter[i + 2] - f[(i + 2) % 3] );
        }
        
        return f[0] > sumAfter[0] - f[0];
        
        
    }
}