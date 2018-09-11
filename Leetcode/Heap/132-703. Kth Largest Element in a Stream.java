class KthLargest {
    
    private int capacity;
    private Queue<Integer> pq;
        
    private void addNumber(int num){
        if(pq.size() < capacity){
            pq.add(num);
        } else {
            int curt = pq.peek();
            if(curt < num){
                pq.poll();
                pq.add(num);
            }
        }
    }
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.capacity = k;
        
        for(int i = 0; i < nums.length; i++){
            addNumber(nums[i]);
        }
    }    
    public int add(int val) {        
        addNumber(val);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */