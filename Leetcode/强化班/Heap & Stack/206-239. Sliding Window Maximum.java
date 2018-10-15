class Solution {
    
    private Deque<Integer> deque = new ArrayDeque();        
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return new int[]{};        
        for(int i = 0; i < k - 1; i++){
            addNumber(nums[i]);            
        }
        
        // begin to build result
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for(int i = k - 1; i < nums.length; i++){
            addNumber(nums[i]);
            res[index++] = deque.peekFirst();
            removeNumber(nums[i - k + 1]);              
        }
        return res;        
    }
    
    private void addNumber(int num){
        // if number if larger than tail, then pollLast until
        while( !deque.isEmpty() && deque.peekLast() < num ){
            deque.pollLast();
        }
        deque.offer(num);
    }
    private void removeNumber(int num){
        // to remove number, check whether it is the first element in the deque
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }
    
    
}