class Solution {
    
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    private boolean[][] connectedP, connectedA;
    
    private void flow(int[][] matrix, int x, int y, boolean[][] connected){
        
        connected[x][y] = true;        
        
        for(int i = 0; i < 4; i++){
            int newX = x + deltaX[i], newY = y + deltaY[i];
            
            if( inBound(matrix, newX, newY) && matrix[newX][newY] >= matrix[x][y] && connected[newX][newY] != true){
                flow(matrix, newX, newY, connected);
            }
        }
        
    }
    
    private boolean inBound(int[][] matrix, int x, int y){
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
    
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
    
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<int[]>() ;
        int m = matrix.length, n = matrix[0].length;
        connectedP = new boolean[m][n];
        connectedA = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            flow(matrix, i, 0, connectedP);
            flow(matrix, i, n - 1, connectedA);
        }
            
        for(int j = 0; j < n; j++) {
            flow(matrix, m - 1, j, connectedA);
            flow(matrix, 0, j, connectedP);
        }
        
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(connectedP[i][j] && connectedA[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;    
        
    }
}