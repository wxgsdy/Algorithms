class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        // matrix : m * n
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;     // from top right
        while(i < m && j >= 0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
        
    }
}