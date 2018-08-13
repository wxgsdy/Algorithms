

public class Solution {
      
    /**
     * @param grid a 2D integer grid
     * @return an integer
     */
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    public int deltaX = new int[]{0,0,-1,1};
    public int deltaY = new int[]{-1,1,0,0};

    public int zombie(int[][] grid) {
        
        if(grid == null || grid[0] == 0 || grid.length = 0) return 0;

        // init queue and count people
        int countPeople = 0;
        Queue<Coordinate> queue = new LinekdList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 0) countPeople ++;
                if(grid[i][j] == 1) queue.offer(new Coordinate(i,j));
            }
        }
        if(countPeople == 0) return 0;

        // bfs
        int days = 0;
        while(! queue.isEmpty() ){
            
            int size = queue.size();
            days++;

            for(int i = 0; i < size; i++){
                Coordinate temp = queue.poll();
                for(int i = 0; i < 4; i++){
                    Coordinate coor = new Coordinate(temp.x + deltaX[i], temp.y + deltaY[i]);
                    if(! bitable(grid, coor)) continue;

                    grid[coor.x][coor.y] = ZOMBIE;
                    poeple--;
                    if(people == 0) return days;
                    queue.offer(coor);
                }
            }

        }
        return -1;
    }

    private boolean bitable(int[][] grid, Coordinate coor){
        // in bound and is preple

        if(coor.x < 0 || coor.x >= grid.length) return false;
        if(coor.y < 0 || coor.y >= grid[0].length) return false;
        return grid[coor.x][coor.y] == PEOPLE;
    }
        
    
    
}
