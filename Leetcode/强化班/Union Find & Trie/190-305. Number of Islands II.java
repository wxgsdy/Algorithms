// Method 1: Define a UnionFind class
class Solution {
    
    
    public int convertIndex(int x, int y, int m){
        return x * m + y;
    }
    
    class UnionFind{        
        private Map<Integer, Integer> map;
        public UnionFind(int m, int n){
            map = new HashMap<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int id = convertIndex(i, j, m);
                    map.put(id, id);
                }
            }            
        }        
        public int find(int a){
            // find root index of set including a and compress the path
            int parent = a;
            while(parent != map.get(parent)){
                parent = map.get(parent);
            }
            
            // compress the path
            int path = a;
            while(path != map.get(path)){
                int temp = map.get(path);
                map.put(path, parent);
                path = temp;
            }              
            return parent;
        }        
        
        public void union(int a, int b){
            int parent_a = find(a);
            int parent_b = find(b);
            if(parent_a != parent_b){
                map.put(parent_a, parent_b);
            }
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(positions == null || positions.length == 0) return result;
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        
        int[] deltaX = new int[]{-1, 1, 0, 0};
        int[] deltaY = new int[]{0, 0, -1, 1};
        int[][] isIsland = new int[m][n];
        
        for(int i = 0; i < positions.length; i++){  
            
            int[] pair = positions[i];
            int x = pair[0], y = pair[1];
            
            if(isIsland[x][y] != 1){
                
                count++;
                isIsland[x][y] = 1;
                
                for(int j = 0; j < 4; j++){
                    int newX = x + deltaX[j], newY = y + deltaY[j];
                    if(inBound(newX, newY, m, n) && isIsland[newX][newY] == 1){
                        int id = convertIndex(x, y, m);
                        int newId = convertIndex(newX, newY, m);
                        int parent = uf.find(id);
                        int newParent = uf.find(newId);
                        if(parent != newParent){
                            count--;
                            uf.union(id, newId);
                        }
                    }                
                }                
            }
            result.add(count);            
        }
        return result;
    }
    
    private boolean inBound(int x, int y, int m, int n){
        return x >=0 && x < m && y >= 0 && y < n;
    }
}


// Method 2: 其实也可以不去定义一个class
class Solution {
    
    private int[] father;
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(positions == null || positions.length == 0) return result;
        
        father = new int[m * n];
        for(int i = 0; i < father.length; i++){
            father[i] = i;
        }
        
        boolean[][] island = new boolean[m][n]; 
        int[] deltaX = new int[]{-1, 1, 0, 0};
        int[] deltaY = new int[]{0, 0, -1, 1};
        // 2d to 1d : (x, y) -> x * m + y
        int count = 0;
        for(int i = 0; i < positions.length; i++){
            
            int x = positions[i][0], y = positions[i][1];
            if(island[x][y] != true){
                
                count++;
                island[x][y] = true;
                
                for(int j = 0; j < 4; j++){
                    int newX = x + deltaX[j];
                    int newY = y + deltaY[j];
                    if(inBound(newX, newY, m, n) && island[newX][newY] == true){
                        // merge
                        int id = x * n + y, newId = newX * n + newY;
                        int father_id = find(id), father_new = find(newId);
                        if(father_id != father_new){
                            union(id, newId);
                            count--;
                        }
                    }
                }                
            } 
            result.add(count);
        }
        return result;
        
    }
    
    private boolean inBound(int x, int y, int m, int n){
        return x >=0 && x < m && y >= 0 && y < n;
    }
    
    // revursive version of find 
    private int find(int a){
        // exit
        if(father[a] == a) return a;
        else return find(father[a]);
    }
    
    // union
    private void union(int a, int b){
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
        }
    }
    
    
}