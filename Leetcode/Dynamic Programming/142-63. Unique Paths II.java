class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] state = new int[m][n];
        // initialization
        state[0][0] = 1;
        // 0 row        
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == 1) state[0][i] = 0;
            else if(state[0][i-1] == 0) state[0][i] = 0;
            else state[0][i] = 1;
        }
        // 0 column
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 1) state[i][0] = 0;
            else if(state[i-1][0] == 0) state[i][0] = 0;
            else state[i][0] = 1;
        }
        
        // build state matrix
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) state[i][j] = 0;
                else state[i][j] = state[i][j-1] + state[i-1][j];
            }
        }
        
        return state[m-1][n-1];
    }
}