class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int[][] state = new int[m][n];
        // initialization
        for(int i = 0; i < m; i++){
            state[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            state[0][i] = 1;
        }
        
        // build state matrix
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                state[i][j] = state[i][j-1] + state[i-1][j];
            }
        }
        
        return state[m-1][n-1];
    }
}