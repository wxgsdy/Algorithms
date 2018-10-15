public class Solution {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        
        List<Integer> result = new ArrayList<>();
        if(A == null || A.length == 0){
            result.add(-1);
            result.add(-1);
            return result;
        }
        
        int left = 0, right = A[0].length;
        int up = 0, down = A.length;
        while(left + 1 < right || up + 1 < down){
            if(right - left > down - up){
                // split right and left
                int mid = (left + right) / 2;
                int rowIndex = findPeakinColumn(A, mid, up, down);
                // binary search
                if(isPeak(A, rowIndex, mid)){
                    result.add(rowIndex);
                    result.add(mid);
                    return result;
                }
                else if(A[rowIndex][mid] < A[rowIndex][mid - 1]) right = mid;
                else left = mid;
            }
            else{
                // split top and down
                int mid = (up + down) / 2;
                int colIndex = findPeakinRow(A, mid, left, right);
                if(isPeak(A, mid, colIndex)) {
                    result.add(mid);
                    result.add(colIndex);
                    return result;
                }
                else if(A[mid][colIndex] < A[mid - 1][colIndex]) down = mid;
                else up = mid;
            }
        }
        
        int x = -1, y = -1;
        if(isPeak(A, up, left)){
            x = up; y = left;
        }
        if(isPeak(A, up, right)){
            x = up; y = left;
        }
        if(isPeak(A, down, left)){
            x = up; y = left;
        }
        if(isPeak(A, down, right)){
            x = up; y = left;
        }
        
        result.add(x);
        result.add(y);
        return result;
    }
    
    
    private int findPeakinColumn(int[][] matrix, int colIndex, int up, int down){
        
        int rowIndex = up;
        int value = matrix[up][colIndex];
        for(int i = up + 1; i < down; i++){
            if(matrix[i][colIndex] > value){
                rowIndex = i;
                value = matrix[i][colIndex];
            }
        }
        return rowIndex;
    }
    private boolean isPeak(int[][] matrix, int row, int col){
        return matrix[row][col] > matrix[row][col + 1]
               && matrix[row][col] > matrix[row][col - 1]
               && matrix[row][col] > matrix[row + 1][col]
               && matrix[row][col] > matrix[row - 1][col];
    }
    private int findPeakinRow(int[][] matrix, int rowIndex, int left, int right){
        int colIndex = left;
        int value = matrix[rowIndex][left];
        for(int i = left + 1; i < right; i++){
            if(matrix[rowIndex][i] > value){
                colIndex = i;
                value = matrix[rowIndex][i];
            }
        }
        
        return colIndex;
    }
}