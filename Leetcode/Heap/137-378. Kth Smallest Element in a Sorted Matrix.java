class Solution {
    
    private class Coordinate{
        int x, y;
        int val;
        public Coordinate(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }    
    private Comparator<Coordinate> coorComparator = new Comparator<Coordinate>(){        
        public int compare(Coordinate left, Coordinate right){
            return left.val - right.val;
        }
    };
    
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;        
        int[] deltaX = new int[]{0, 1};
        int[] deltaY = new int[]{1, 0};
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Coordinate> minHeap = new PriorityQueue<>(coorComparator);        
        minHeap.add(new Coordinate(0,0,matrix[0][0]));
        visited[0][0] = true;
        
        for(int i = 0; i < k - 1; i++){
            Coordinate curt = minHeap.poll();
            for(int j = 0; j < 2; j++){
                int newX = curt.x + deltaX[j];
                int newY = curt.y + deltaY[j];
                if(inBound(newX, newY, matrix) && visited[newX][newY] == false){
                    minHeap.add(new Coordinate(newX, newY, matrix[newX][newY]));
                    visited[newX][newY] = true;
                }
            }            
        }
        return minHeap.poll().val;
        
        
    }
    
    private boolean inBound(int x, int y, int[][] matrix){
        return x >=0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
    
    
    
    
}