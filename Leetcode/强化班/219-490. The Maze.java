// BFS
class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        int[] deltaX = new int[]{-1, 1, 0, 0};
        int[] deltaY = new int[]{0, 0, -1, 1};
        int WALL = 1, EMPTY = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
            
        
        queue.offer(new Pair(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){            
            
            Pair curt = queue.poll();     
            
            for(int i = 0; i < 4; i++){
                
                int newX = curt.x, newY = curt.y;
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == EMPTY){
                    newX += deltaX[i];
                    newY += deltaY[i];
                }
                
                // go back for one step
                newX -= deltaX[i];
                newY -= deltaY[i];
                
                if(visited[newX][newY]) continue;
                if(newX == destination[0] && newY == destination[1]) return true;
                visited[newX][newY] = true;
                queue.offer(new Pair(newX, newY));
            }
        }
        
        return false;
        
    }
}



// DFS
class Solution { 
    
    
    private int[] deltaX = new int[]{0, 0, -1, 1};
    private int[] deltaY = new int[]{-1, 1, 0, 0};
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return dfs(maze, start, destination, visited);
         
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] des, boolean[][] visited){
        // exit
        if(visited[start[0]][start[1]]) return false;
        
        visited[start[0]][start[1]] = true;
        if(start[0] == des[0] && start[1] == des[1]) return true;
        
        for(int i = 0; i < 4; i++){
            int newX = start[0], newY = start[1];
            while(newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == EMPTY){
                newX += deltaX[i];
                newY += deltaY[i];
            }
            
            // go back for one step
            newX -= deltaX[i]; newY -= deltaY[i];
            
            // bfs again from here
            if(dfs(maze, new int[]{newX, newY}, des, visited)) return true;        
            
        }
        return false;
    }
}