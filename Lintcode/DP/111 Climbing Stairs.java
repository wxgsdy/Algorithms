public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n == 0) return 0;
        
        // state array 
        int[] f = new int[n + 1];
        f[0] = 1; f[1] = 1;
        for(int i = 2; i < n + 1; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}