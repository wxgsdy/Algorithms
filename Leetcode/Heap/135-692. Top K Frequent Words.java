class Solution {
    
    private class Pair{
        private String word;
        private int frequency;
        public Pair(String word, int frequency){
            this.word = word;
            this.frequency = frequency;
        }
    }
        
    private Comparator<Pair> pairComparator = new Comparator<Pair>() {
        public int compare(Pair left, Pair right) {
            if (left.frequency != right.frequency) {
                return left.frequency - right.frequency;
            }
            return right.word.compareTo(left.word);
        }
    };
    
    
    
    public List<String> topKFrequent(String[] words, int k) {
        
        // use map to count frequency 
        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
        }
        
        // from map to build pq
        Queue<Pair> pq = new PriorityQueue<Pair>(k, pairComparator);
        for(String str : map.keySet()){
            Pair curt = new Pair(str, map.get(str));
            
            if(pq.size() < k) pq.add(curt);
            else{
                Pair tail = pq.peek();
                if(pairComparator.compare(tail, curt) < 0){   
                    pq.poll();
                    pq.add(curt);
                }
            }
        }
        
        // from pq to build List<Strng>, desending(need reverse)
        List<String> results = new ArrayList<>();
        int size = pq.size();
        for(int i = 0; i < size; i++){
            results.add(pq.poll().word);
        }
        Collections.reverse(results);
        return results;
        
    }
}