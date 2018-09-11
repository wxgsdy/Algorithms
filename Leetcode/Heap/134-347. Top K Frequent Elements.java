class Solution {
    
    private class Pair{
        int number, frequency;
        public Pair(int number, int frequency){
            this.number = number;
            this.frequency = frequency;
        }
    }    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left, Pair right){
            return left.frequency - right.frequency;
        }  
    };
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        // use map to count frequency
        Map<Integer, Integer> map = new HashMap<>(); // number -> frequency
        for(int num : nums){
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);           
        }
        
        // build topk, we need a minHeap to compare frequency
        Queue<Pair> pq = new PriorityQueue<Pair>(k, pairComparator);
        for(int num : map.keySet()){
            
            Pair curt = new Pair(num, map.get(num));
            if(pq.size() < k) pq.add(curt);
            else{
                Pair tail = pq.peek();
                if(tail.frequency < curt.frequency){
                    pq.poll();
                    pq.add(curt);
                }
            }
        }
        
        // from pq to result
        List<Integer> results = new ArrayList<>();
        int size = pq.size();
        for(int i = 0; i < size; i++){
            results.add(pq.poll().number);
        }
        Collections.reverse(results);        
        return results;
        
    }
}