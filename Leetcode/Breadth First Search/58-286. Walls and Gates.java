// Similar to preblem 01 matrix: starting from gate to find empty rooms, instead of from room to gate;

class Solution {
    
    private final int WALL = -1;
    private final int GATE = 0;
    private final int EMPTYROOM = Integer.MAX_VALUE;
    
    private int[] deltaX = new int[]{0, 0, -1, 1};
    private int[] deltaY = new int[]{-1, 1, 0, 0};
    
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length; 
        int n = rooms[0].length;   // rooms: m * n
        
        // Build queue to help with BFS
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == GATE){
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        
        // BFS
        while(!queue.isEmpty()){
            Coordinate curt = queue.poll();
            for(int index = 0; index < 4; index++){
                Coordinate newCoor = new Coordinate(curt.x + deltaX[index], curt.y + deltaY[index]);
                if(! inBound(rooms, newCoor)) continue;
                if(rooms[newCoor.x][newCoor.y] == WALL) continue;
                if(rooms[curt.x][curt.y] < rooms[newCoor.x][newCoor.y]){
                    rooms[newCoor.x][newCoor.y] = rooms[curt.x][curt.y] + 1;
                    queue.offer(newCoor);
                }
            }
        }
        
        
        
    }

    private boolean inBound(int[][] rooms, Coordinate coor){
        return coor.x >= 0 && coor.x < rooms.length && coor.y >= 0 && coor.y < rooms[0].length;
    }
}