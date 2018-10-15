class Solution {
    
    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;     
            
            
        int[][] f = new int[m][n];           
        // initialize 
        for(int i = 0; i < n; i++){
            f[0][i] = matrix[0][i] - '0';
        }
        
        for(int i = 0; i < m; i++){
            f[i][0] = matrix[i][0] - '0';
        }
        
        // function
        int edge = matrix[0][0] - '0';   
        if(m >= 2) edge = Math.max(matrix[1][0] - '0', edge);
        if(n >= 2) edge = Math.max(matrix[0][1] - '0', edge);   
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;                    
                } else {
                    f[i][j] = 0;
                }
                edge = Math.max(edge, f[i][j]);                
            }
        }
        
        return edge * edge;
        
    }
}