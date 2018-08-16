public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        if(k > nums.length) return nums;
        
        // Build a PriorityQueue -> minHeap
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length; i++){
            
            if(pq.size() < k) pq.add(nums[i]);
            else{// already full to k
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        
        // pq -> list
        int[] result = new int[k];
        for(int index = k - 1; index >= 0; index--){
            result[index] = pq.poll();
        }
        
        return result;
    }
}