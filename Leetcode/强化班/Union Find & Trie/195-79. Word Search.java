class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word.equals("")) return true;
        
        // board m * n       
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = search(board, i, j, word, 1);
                    if(res) return true;
                }
            }
        }        
        return false;
    }
    
    // 从【】
    private boolean search(char[][] board, int startX, int startY, String word, int startIndex){
        // exit
        if(startIndex >= word.length()) return true;
        
        // split 
        int[] deltaX = new int[]{0, 0, -1, 1};
        int[] deltaY = new int[]{-1, 1, 0, 0};
        
        board[startX][startY] = '#';
        
        for(int j = 0; j < 4; j++){
            int newX = startX + deltaX[j];
            int newY = startY + deltaY[j];
            if(!inBound(newX, newY, board)) continue;            
            if(board[newX][newY] == word.charAt(startIndex)){
                
            
                if(search(board, newX, newY, word, startIndex + 1)) 
                    return true;
            }
        }
        
        board[startX][startY] = word.charAt(startIndex - 1);
        
        return false;
        
    }
    
    private boolean inBound(int x, int y, char[][] board){
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
    
    
    
        
        
    
}