// Method 1: BFS
class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
            
            
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, bfs(grid, new Coordinate(i, j)));
                }
            }
        }
        return res;       
    }
    
    
    private int bfs(int[][] maze, Coordinate coor){        
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coor);
        maze[coor.x][coor.y] = 0;
        int size = 1;
        
        while(!queue.isEmpty()){
            
            Coordinate curt = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = curt.x + deltaX[i];
                int newY = curt.y + deltaY[i];
                if(newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) continue;
                if(maze[newX][newY] == 1){
                    size += 1;
                    queue.offer(new Coordinate(newX, newY));
                    maze[newX][newY] = 0;
                }
            }
        }
        
        return size;
    }   
}



// Method 2 : DFS

class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    private int maxSize;
    private int curt;
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        maxSize = 0;
            
            
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    curt = 0;
                    dfs(grid, i, j);
                    maxSize = Math.max(curt, maxSize);
                }
            }
        }
        return maxSize;       
    }
    
    private void dfs(int[][] maze, int x, int y){
        
        maze[x][y] = 0;
        curt += 1;              
        
        for(int i = 0; i < 4; i++){
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];
            if( inBound(maze, newX, newY) && maze[newX][newY] == 1){                
                dfs(maze, newX, newY);
            }
        }
    }   
      
    private boolean inBound(int[][] maze, int x, int y){
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;        
    } 
    
}