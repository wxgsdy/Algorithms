/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int[] deltaX = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
    public int[] deltaY = new int[]{2, -2, 1, -1, 2, -2, 1, -1};
    
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if(!reachable(grid, source)) return -1;
        if(!reachable(grid, destination)) return -1;
        
        // bfs 
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int paths = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point temp = queue.poll();
                if(temp.x == destination.x && temp.y == destination.y) return paths;
                
                for(int j = 0; j < 8; j++){
                    Point newPoint = new Point(temp.x + deltaX[j], temp.y + deltaY[j]);
                    if(! reachable(grid, newPoint)) continue;
                    queue.offer(newPoint);
                    grid[newPoint.x][newPoint.y] = true;
                }
            }
            paths++;
        }
        return -1;
        
    }
    
    private boolean inBound(boolean[][] grid, Point p){
        return p.x >= 0 && p.x < grid.length && p.y >= 0 && p.y < grid[0].length;
    }
    
    private boolean reachable(boolean[][] grid, Point p){
        return inBound(grid, p) && grid[p.x][p.y] == false;
    }
}