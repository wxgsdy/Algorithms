class Solution {
    
    
    private class coordinate{
        int x, y;
        public coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] deltaX = new int[]{0, 0, -1, 1};
    private int[] deltaY = new int[]{-1, 1, 0, 0};
    
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int number = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, new coordinate(i, j));
                    number++;
                }
            }
        }        
        return number;
        
    }
    
    private void bfs(char[][] grid, coordinate start){        
        // 入队列的时候改flag
        Queue<coordinate> queue = new LinkedList<>();
        queue.offer(start);
        grid[start.x][start.y] = '0'; 
            
        while(!queue.isEmpty()){            
            coordinate curt = queue.poll();            
            for(int index = 0; index < 4; index++){
                coordinate temp = new coordinate(curt.x + deltaX[index], curt.y + deltaY[index]);
                if(!inBound(grid, temp)) continue;
                if(grid[temp.x][temp.y] == '1'){
                    queue.offer(temp);
                    grid[temp.x][temp.y] = '0';
                }
            }
        }
        
    }
    
    private boolean inBound(char[][] grid, coordinate point){
        return point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid[0].length;
    }
}