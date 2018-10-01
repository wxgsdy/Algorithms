class Solution {
    
    
    private int[] father;
    private int size;
    
    public boolean validTree(int n, int[][] edges) {
        
        // if(n == 0) return false;
        // if(edges == null || edges.length == 0) return false;  
        
        if(n != edges.length + 1) return false;
        
        father = new int[n];
        for(int i = 0; i < father.length; i++){
            father[i] = i;
        }
        
        this.size = n;
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            union(u, v);
        }
        return size == 1;
        
        
    }
    
    private int find(int a){
        if(father[a] == a) return a;
        else return find(father[a]);
    }
    
    private void union(int a, int b){
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
            size--;
        }
    }
}