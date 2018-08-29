class Solution {
    
    public int numTrees(int n) {
        // state 
        int[] count = new int[n + 2];
        Arrays.fill(count, 0);
        
        // initialization
        count[0] = 1; count[1] = 1;
        // function
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        
        // result
        return count[n];
    }
}