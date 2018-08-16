// Method 1: using PriorityQueue
class Node{
    int row, col, val;
    public Node(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    
    private Comparator<Node> NodeComparator = new Comparator<Node>(){
        public int compare(Node left, Node right){
            return left.val - right.val;
        }  
    };
    
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if(arrays == null || arrays.length == 0) return new int[]{};
        
        int length = 0;
        for(int i = 0; i < arrays.length; i++){
            length += arrays[i].length;
        }
        
        
        // build a dynamic PriorityQueue
        Queue<Node> pq = new PriorityQueue<>(arrays.length, NodeComparator);
        for(int i = 0; i < arrays.length; i++){
            // i -> row
            if(arrays[i].length != 0){
                pq.add(new Node(i,0,arrays[i][0]));
            }
        }
        
        // build result array
        int[] result = new int[length];
        int count = 0;
        
        while(! pq.isEmpty()){
            Node curt = pq.poll();
            result[count] = curt.val;
            count++;
            if(curt.col + 1 < arrays[curt.row].length){
                pq.add(new Node(curt.row, curt.col + 1, arrays[curt.row][curt.col + 1]));
            }
            
        }
        
        return result;
    }
}