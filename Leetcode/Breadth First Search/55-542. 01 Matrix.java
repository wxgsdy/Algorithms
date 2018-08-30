class Solution {
    
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] deltaX = new int []{0, 0, -1, 1};
    private int[] deltaY = new int []{-1, 1, 0, 0};
    
    public int[][] updateMatrix(int[][] matrix) {
        
        Queue<Coordinate> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){                
                if(matrix[i][j] == 0) queue.offer(new Coordinate(i, j));
                
                if(matrix[i][j] == 1) matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while(! queue.isEmpty()){
            
            Coordinate curt = queue.poll();
            for(int index = 0; index < 4; index++){
                Coordinate newCoor = new Coordinate(curt.x + deltaX[index], curt.y + deltaY[index]);
                if(!inBound(matrix, newCoor)) continue;
                
                if(matrix[curt.x][curt.y] < matrix[newCoor.x][newCoor.y]){
                     matrix[newCoor.x][newCoor.y] = matrix[curt.x][curt.y] + 1;
                     queue.offer(newCoor);
                }
            }
        }
        
        return matrix;
        
    }
    
    private boolean inBound(int[][] matrix, Coordinate coor){
        return coor.x >= 0 && coor.x < matrix.length && coor.y >= 0 && coor.y < matrix[0].length;
    }
}