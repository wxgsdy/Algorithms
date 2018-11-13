class Solution {
    
    public int findCircleNum(int[][] M) {
        
        if (M == null || M.length == 0) return 0;
        int N = M.length; 
        int count = 0;
        for(int i = 0; i < N; i++){
            boolean flag = false;            
            for(int j = 0; j < N; j++){                
                if(M[i][j] == 1){
                    flag = true;
                    dfs(M, i, j);
                }
            }            
            if(flag) count += 1;
        }
        return count;
    }
    
    private void dfs(int[][] M, int self, int friend){
        
        M[self][friend] = 0;
        if(self == friend) return;
        else{
            for(int j = 0; j < M.length; j++){
                if(M[friend][j] == 1){
                    dfs(M, friend, j);
                }
            }
        }
    }
    
    
}