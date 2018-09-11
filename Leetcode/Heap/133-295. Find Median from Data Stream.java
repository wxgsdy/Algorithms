class MedianFinder {

    
    
    PriorityQueue<Integer> minH, maxH;
        
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        minH.add(num);
        maxH.add(minH.poll());
        if(maxH.size() > minH.size()){
            minH.add(maxH.poll());
        }
    }
    
    public double findMedian() {
        if(minH.size() == maxH.size()) return (minH.peek() + maxH.peek()) / 2.0;
        else return minH.size() > maxH.size() ? minH.peek() : maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */