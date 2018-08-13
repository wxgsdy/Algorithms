public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(boolean[][] grid, int x, int y){
        
        // bfs int grid from (x,y) and mark 0 
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x,y));
        grid[x][y] = false;
        
        int[] deltaX = new int[]{0, 1, -1, 0};
        int[] deltaY = new int[]{1, 0, 0, -1};
        
        while(! queue.isEmpty()){
            Coordinate temp = queue.poll();
            
            for(int index = 0; index < 4; index++){
                Coordinate newCoor = new Coordinate( temp.x + deltaX[index],
                                                     temp.y + deltaY[index]);
                if(!inBound(grid, newCoor)) continue;
                if(grid[newCoor.x][newCoor.y]){
                    queue.offer(newCoor);
                    grid[newCoor.x][newCoor.y] = false;
                }
                
            }
            
        
        }
        
        
    }
    
    private boolean inBound(boolean[][] grid, Coordinate coor){
        return coor.x >= 0 && coor.x < grid.length && coor.y >= 0 && coor.y < grid[0].length;
    }
}