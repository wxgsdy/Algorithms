public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if(n == 0) return results;
        
        
        search(n, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void search(int n, ArrayList<Integer> cols, List<List<String>> results){
        
        // exit
        if(cols.size() == n){
            results.add(drawChessBoard(cols));
            return;
        }
        
        // split
        for(int colIndex = 0; colIndex < n; colIndex++){
            if(!isvalid(cols, colIndex)) continue;
            
            cols.add(colIndex);
            search(n, cols, results);
            cols.remove(cols.size() - 1);
        }
    }
    
    private List<String> drawChessBoard(List<Integer> cols){
        int size = cols.size();
        List<String> chaseBoard = new ArrayList<>();
        for(int i = 0; i < size; i++){// every row
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++){// jth column in ith row
                if(j == cols.get(i)) sb.append("Q");
                else sb.append(".");
            }
            chaseBoard.add(sb.toString());
        }
        return chaseBoard;
    }
    
    private boolean isvalid(List<Integer> cols, int column){
        
        int currentRow = cols.size();
        for(int rowIndex = 0; rowIndex < currentRow; rowIndex++){
            if(cols.get(rowIndex) == column) return false;  // vertical
            if(currentRow + column == rowIndex + cols.get(rowIndex)) return false;
            if(currentRow - column == rowIndex - cols.get(rowIndex)) return false;
        }
        return true;
    }
}