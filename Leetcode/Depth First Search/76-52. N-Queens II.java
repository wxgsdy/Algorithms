class Solution {
    
    private int count = 0;    
    public int totalNQueens(int n) {
        
        if(n <= 1) return n;
        search(n, new ArrayList<Integer>());
        return count;      
        
    }
    
    private void search(int n, List<Integer> cols){
        
        if(cols.size() == n){
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(! validCurrent(cols, i)) continue;
            cols.add(i);
            search(n, cols);
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
}