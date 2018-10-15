public class Solution {
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        
        int[][] f = new int[m][n];
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        
        
        int edge = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(matrix[i][j] == 1){
                    left[i][j] = 0;
                    up[i][j] = 0;
                    
                    if(i > 0 && j > 0){
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(up[i - 1][j], left[i][j - 1])) + 1;
                    } else {
                        f[i][j] = 1;
                    }
                    edge = Math.max(edge, f[i][j]);
                }
                
                if(matrix[i][j] == 0){
                    f[i][j] = 0;
                    left[i][j] = (j > 0) ? left[i][j - 1] + 1 : 1;
                    up[i][j] = (i > 0) ? up[i - 1][j] + 1 : 1;
                }
            }
        }
        return edge * edge;
        
    }
}