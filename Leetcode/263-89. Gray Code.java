class Solution {
    
    
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited; 
    int flag = 0;
    
    public List<Integer> grayCode(int n) {
    
        visited = new boolean[(int) Math.pow(2, n)];
        Arrays.fill(visited, false);
        
        List<Integer> curt = new ArrayList<>();
        curt.add(0);
        visited[0] = true;
        
        recursionHelper(n, visited, curt);
        
        if(res.size() == 0) return null;
        return res.get(0); 
        
    }
    
    private void recursionHelper(int n, 
                                 boolean[] visited,
                                 List<Integer> curt){
        
        if(flag == 1) return;
        
        if(curt.size() == (int) Math.pow(2, n)){
            res.add(new ArrayList<Integer>(curt));  
            flag = 1;
        }
        
        for(int next : getNext(curt.get(curt.size() - 1), n)){
            
            if(!visited[next]){
                
                curt.add(next); 
                visited[next] = true;
                
                recursionHelper(n, visited, curt);
                
                visited[curt.get(curt.size() - 1)] = false;
                curt.remove(curt.size() - 1);                
                
            }
        }
    }  
    
    private Set<Integer> getNext(int curt, int n){
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){            
            int pointer = (1 << i);            
            if((curt & pointer) == 0) set.add(curt + pointer);
            else set.add(curt - pointer);
        }
        return set;
    }
    
    
}
