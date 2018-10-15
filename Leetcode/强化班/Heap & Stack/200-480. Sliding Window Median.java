class Solution {
    
    Queue<Integer> minH = new PriorityQueue<>();
    Queue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {        
        
        for(int i = 0; i < k - 1; i++){
            addNum(nums[i]);
        }
        
        
        int index = 0;
        double[] result = new double[nums.length - k + 1];   

        
        for(int i = k - 1; i < nums.length; i++){
            addNum(nums[i]);
            result[index++] = findMedian();
            remove(nums[i - k + 1]);
        }           
        return result;
       // return null;
    }
    
    public void addNum(int num) {        
        minH.add(num);
        maxH.add(minH.poll());
        if(maxH.size() > minH.size()){
            minH.add(maxH.poll());
        }
    }      
    public double findMedian() {
        if(minH.size() == maxH.size()) return ( (long)minH.peek() + (long)maxH.peek() ) / 2.0;
        else return minH.size() > maxH.size() ? minH.peek() : maxH.peek();
    }    
    private void remove(int num){
        
        if(maxH.contains(num)){
            maxH.remove(num);
            if(minH.size() - maxH.size() == 2){
                maxH.add(minH.poll());
            }
        }
        
        else if(minH.contains(num)){
            minH.remove(num);
            if(minH.size() < maxH.size()){
                minH.add(maxH.poll());
            }
        }
        
        
    }
    
}