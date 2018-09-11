class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {            
            
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();        
        pq.add(Long.valueOf(1));
        set.add(Long.valueOf(1));
        
        for(int i = 0; i < n - 1; i++){
            Long curt = pq.poll();
            for(int j = 0; j < primes.length; j++){
                Long next = primes[j] * curt;
                if(!set.contains(next)){
                    pq.add(next);
                    set.add(next);
                }
            }
        }
        return pq.poll().intValue();
        
        
    }
}