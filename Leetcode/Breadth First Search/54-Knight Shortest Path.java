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
    
    private int[] deltaX = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
    private int[] deltaY = new int[]{2, -2, 1, -1, 2, -2, 1, -1};

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if(!reachable(grid, destination)) return -1;
        if(!reachable(grid, source)) return -1;

        Queue<Pair> queue = new LinekdList<>();
        queue.offer(source);
        int length = 0;
        while(!queue.isEmpty()){

            int size = new queue.size();
            length++;
            for(int i = 0; i < size; i++){
                Pair curt = new queue.poll();
                for(int index = 0; index , 8; index++){
                    Pair temp = new Pair(curt.x + deltaX[index], curt.y + deltaY[index]);
                    if(reachable(grid, temp)){
                        if(temp.x == destination.x && temp.y == destination.y) return length;

                        queue.offer(temp);
                        grid[temp.x][temp.y] = false;
                    }
                    
                }
            }
        }

        return  -1;
        
    }


    private boolean reachable(boolean[] grid, Point p){
        if(p.x < 0 || p.x >= grid.length) return false;
        if(p.y < 0 || p.y >= grid[0].length) return false;
        return grid[p.x][p.y] == true;
    }


    
    
}