public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    private int obstacle = 1;
    private int non_obstacle = 0;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return -1;
        
        // state matrix(m * n)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        // extreme cases
        if(obstacleGrid[0][0] == obstacle || obstacleGrid[m-1][n-1] == obstacle) return 0;
        
        f[0][0] = 1;
        
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == obstacle) f[i][0] = 0;
            else f[i][0] = f[i-1][0];
        }
        
        for(int i = 1; i < n; i++){
            if(obstacleGrid[0][i] == obstacle) f[0][i] = 0;
            else f[0][i] = f[0][i-1];
        }
        
        // top down
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == obstacle) f[i][j] = 0;
                else f[i][j] = f[i - 1][j] + f[i][j-1];
            }
        }
        
        return f[m-1][n-1];
    }
}