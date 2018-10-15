// Method 1: BFS + Memory
// bfs + 记忆话搜索

class Pair{
    int x, y, dis;
    public Pair(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
//  dis 存的是起点到当前点的距离


class Solution {
    
    private static final int WALL = 1;
    private static final int EMPTY = 0;
        
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        
        int m = maze.length, n = maze[0].length;        
        if(start[0] == destination[0] && start[1] == destination[1]) return 0;
        
        int[] deltaX = new int[]{0, 0, -1, 1};
        int[] deltaY = new int[]{-1, 1, 0, 0};
        
        int[][] distance = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);            
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start[0], start[1], 0));
        distance[start[0]][start[1]] = 0;
        
        while(!queue.isEmpty()){
            
            Pair curt = queue.poll();                 
            
            for(int i = 0; i < 4; i++){
                int newX = curt.x, newY = curt.y, newDis = curt.dis;
                
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == EMPTY){
                    newX += deltaX[i];
                    newY += deltaY[i];
                    newDis += 1;
                }
                
                // go back for one step
                newX -= deltaX[i];
                newY -= deltaY[i];
                newDis --; 
                
                if(distance[newX][newY] == Integer.MAX_VALUE){
                    queue.offer(new Pair(newX, newY, newDis));
                    distance[newX][newY] = newDis; 
                } else {
                    if(distance[newX][newY] > newDis){
                        queue.offer(new Pair(newX, newY, newDis));
                        distance[newX][newY] = newDis; 
                    } else {
                        continue;
                    }
                }                               
            }
        }        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];   
    }
}


// Method 2 : DFS + Memory
// DFS + memory

class Solution {
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    private final static int EMPTY = 0; 
    private int[][] distance; //  记录从起始点到当前位置的距离
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0 || maze[0].length == 0) return 0;
        if(start[0] == destination[0] && start[1] == destination[1]) return 0;
        
        int m = maze.length, n = maze[0].length; 
        distance = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);            
        }      
        
        
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, 0);
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
        
        
        
    }
    
    private void dfs(int[][] maze, int[] start, int curtDis){
        
        
        for(int i = 0; i < 4; i++){
            int newX = start[0], newY = start[1], newDis = curtDis;
            
            while(newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == EMPTY){
                newX += deltaX[i];
                newY += deltaY[i];
                newDis += 1;
            }
                
            // go back for one step
            newX -= deltaX[i];
            newY -= deltaY[i];
            newDis --; 
            
            
            if(distance[newX][newY] == Integer.MAX_VALUE){
                distance[newX][newY] = newDis;
                dfs(maze, new int[]{newX, newY}, newDis);
            } else {
                if(distance[newX][newY] > newDis){
                    distance[newX][newY] = newDis;
                    dfs(maze, new int[]{newX, newY}, newDis);
                } else {
                    continue;
                }
            }

        }
        
        
    }
    
    
    
}