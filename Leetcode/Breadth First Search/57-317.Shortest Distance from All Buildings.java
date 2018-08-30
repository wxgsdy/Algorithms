// Attention: some empty land may not be able to reach all buildings

class Solution {
    
    final int EMPTYLAND = 0;   // buiding area, can pass
    final int BUILDING = 1;    // target, cannot pass
    final int OBSTACLE = 2;    // cannot pass
    int[] deltaX = new int[]{0, 0, -1, 1};
    int[] deltaY = new int[]{-1, 1, 0, 0};
    
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
        
    public int shortestDistance(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        
        // get all buildings
        List<Coordinate> buildings = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == BUILDING){
                    buildings.add(new Coordinate(i, j));
                }
            }
        }
        
        
        
        int[][] results = new int[grid.length][grid[0].length];
        // building/obstacle: MAX_INTEGER
        // empty land: sum of distance or MAX_INTEGER(unreachable)
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == BUILDING || grid[i][j] == OBSTACLE){
                    results[i][j] = Integer.MAX_VALUE;
                }
                
                else{
                    int sumDistance = 0;
                    for(int k = 0; k < buildings.size(); k++){
                        int dis = distance(grid, new Coordinate(i, j), buildings.get(k));
                        if(dis == -1){
                            sumDistance = Integer.MAX_VALUE;
                            break;
                        } else {
                            sumDistance += dis;
                        }                      
                    }
                    results[i][j] = sumDistance;
                }
            }
        }
        
        int minResult = Integer.MAX_VALUE;
        for(int i = 0; i < results.length; i++){
            for(int j = 0; j < results[0].length; j++){
                minResult = Math.min(results[i][j], minResult);
            }
        }
        
        if(minResult == Integer.MAX_VALUE) return -1;
        return minResult;
        
        
    }
    
    private int distance(int[][] grid, Coordinate source, Coordinate target){
        // find shortest path length from empty land to building -> cannot reach return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(source);
        visited[source.x][source.y] = true;
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            depth ++;
            for(int i = 0; i < size; i++){
                Coordinate curt = queue.poll();
                for(int index = 0; index < 4; index++){
                    Coordinate temp = new Coordinate(curt.x + deltaX[index], curt.y + deltaY[index]);
                    if(!inBound(grid, temp)) continue;
                    if(temp.x == target.x && temp.y == target.y) return depth;
                    if(inBound(grid, temp) && visited[temp.x][temp.y] == false && grid[temp.x][temp.y] == EMPTYLAND){
                        visited[temp.x][temp.y] = true;
                        queue.offer(temp);                       
                    }
                    
                }
            }
            
        }
        
        return -1;
    }
    
    private boolean inBound(int[][] grid, Coordinate coor){
        if(coor.x < 0 || coor.x >= grid.length) return false;
        if(coor.y < 0 || coor.y >= grid[0].length) return false;
        return true;
    }
}