
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
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void bfs(boolean[][] grid, int i, int j){
        // grid[i][j] is true, bfs traverse to mark down all connected points
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i,j));
        grid[i][j] = false;
        
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int cnt = 0; cnt < 4; cnt++) {
                Coordinate adj = new Coordinate(
                    coor.x + directionX[cnt],
                    coor.y + directionY[cnt]
                );
                if (!inBound(grid, adj)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
        
    }
    
    private boolean inBound(boolean[][] grid, Coordinate coor){
        return coor.x >= 0 && coor.x < grid.length && coor.y >= 0 && coor.y < grid[0].length;
    }
}