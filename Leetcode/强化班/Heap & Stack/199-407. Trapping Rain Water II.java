class Cell{
    int x, y, height;
    public Cell(int x, int y, int height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

class Solution {
    
    private Comparator<Cell> cellComparator = new Comparator<Cell>(){        
        public int compare(Cell left, Cell right){
            return left.height - right.height;
        }
    };
    
    public int trapRainWater(int[][] heightMap) {
        
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        Queue<Cell> minHeap = new PriorityQueue<>(cellComparator);
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
            
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        // build initial queue
        
        // row 0 and row m - 1
        for(int i = 0; i < n; i++){
            minHeap.add(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
            
            minHeap.add(new Cell(m - 1, i, heightMap[m - 1][i]));
            visited[m - 1][i] = true;            
        }
        
        // column 0 and column n - 1
        for(int i = 0; i < m; i++){
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        
        // heap 
        int water = 0;
        while(!minHeap.isEmpty()){
            Cell curt = minHeap.poll();
            for(int i = 0; i < 4; i++){
                int newX = curt.x + dx[i];
                int newY = curt.y + dy[i];
                
                if(newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                if(visited[newX][newY] == true) continue;
                
                visited[newX][newY] = true;
                minHeap.add(new Cell(newX, newY, Math.max(curt.height, heightMap[newX][newY])));
                water += Math.max(curt.height - heightMap[newX][newY], 0);
                
            }
        }
        
        return water;
        
        
        
    }
}