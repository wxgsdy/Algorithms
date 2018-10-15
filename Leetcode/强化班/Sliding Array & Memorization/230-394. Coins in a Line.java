public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        
        if(n == 0) return false;
        if(n <= 2) return true;
        boolean[] f = new boolean[n + 1];
        f[1] = true; f[2] = true;
        for(int i = 3; i < n + 1; i++){
            f[i] = !f[i - 1] || !f[i - 2]; 
        }
        return f[n];
    }
}