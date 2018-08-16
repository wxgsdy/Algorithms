public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    
    private class Pair{
        public int row, col, val;
        public Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        // need a minHeap
        public int compare(Pair left, Pair right){
            return left.val - right.val;
        } 
    };
    
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] deltaX = new int[]{0, 1};
        int[] deltaY = new int[]{1, 0};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        Queue<Pair> pq = new PriorityQueue<>(k, pairComparator);
        pq.add(new Pair(0,0,matrix[0][0]));
        visited[0][0] = true;
        
        Pair curt = null;
        for(int i = 0; i < k; i++){
            curt = pq.poll();
            for(int j = 0; j < 2; j++){
                Pair newPair = new Pair(curt.row+deltaX[j], curt.col+deltaY[j], 0);
                if(!inBound(matrix, newPair) || visited[newPair.row][newPair.col]) continue;
                newPair.val = matrix[newPair.row][newPair.col];   // don't forget to change value here 
                pq.add(newPair);          
                visited[newPair.row][newPair.col] = true;
            }
        }
        
        return curt.val;
        
    }
    
    private boolean inBound(int[][] matrix, Pair p){
        return p.row >=0 && p.row < matrix.length && p.col >= 0 && p.col < matrix[0].length;
    }
}