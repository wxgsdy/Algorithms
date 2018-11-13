class Solution {
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    int[][] memory;
    
    
    
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        memory = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memory[i], -1);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;        
    }
    
    private int dfs(int[][] matrix, int x, int y){        
        
        if(memory[x][y] != -1) return memory[x][y];
            
        int path = 1;
        for(int i = 0; i < 4; i++){
            int newX = x + deltaX[i], newY = y + deltaY[i];            
            
            if( !inBound(matrix, newX, newY) ) continue;
            if(matrix[x][y] < matrix[newX][newY])
                path = Math.max(path, dfs(matrix, newX, newY) + 1);
        }
        
        memory[x][y] = path;
        return path;
        
    }
    
    private boolean inBound(int[][] matrix, int x, int y){
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}