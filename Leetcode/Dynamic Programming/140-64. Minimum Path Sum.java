class Solution {
    
    public int minPathSum(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] state = new int[m][n];
        
        // initialization
        state[0][0] = grid[0][0];
        // row 0
        for(int i = 1; i < n; i++){
            state[0][i] = grid[0][i] + state[0][i-1];
        }
        
        // column 0
        for(int i = 1; i < m; i++){
            state[i][0] = grid[i][0] + state[i-1][0];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                state[i][j] = grid[i][j] + Math.min( state[i][j-1], state[i-1][j]);
            }
        }
        
        return state[m-1][n-1];
        
    }
}