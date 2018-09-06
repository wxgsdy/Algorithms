class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> results = new ArrayList<>();
        if(n == 0) return results;
        
        search(n, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void search(int n, List<Integer> cols, List<List<String>> results){
        
        if(cols.size() == n){
            results.add(drawBoard(cols));
            return;
        }
        
        for(int i = 0; i < n; i++){            
            if(!validCurrent(cols, i)) continue;
            cols.add(i);
            search(n, cols, results);
            cols.remove(cols.size() - 1);
        }          
    }         
    private boolean validCurrent(List<Integer> cols, int colIndex){
        
        for(int i = 0; i < cols.size(); i ++){
            if(cols.get(i) == colIndex) return false;
            if(cols.size() - i == colIndex - cols.get(i)) return false;
            if(colIndex - cols.get(i) == i - cols.size()) return false;            
        }
        return true;
    }      
    
    private List<String> drawBoard(List<Integer> cols){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){                
                if(j == cols.get(i)) sb.append("Q");
                else sb.append(".");
            }
            result.add(sb.toString());
        }
        return result;
        
    }
}