public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;
        
        // matrix dimension: m * n
        // search from bottom left [m - 1, 0]
        int m = matrix.length, n = matrix[0].length;
        int x = m - 1, y = 0;
        while(x >= 0 && y < n){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) x--;
            else y++;
        }
        return false;
    }
}