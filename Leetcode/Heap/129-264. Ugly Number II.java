class Solution {
    public int nthUglyNumber(int n) {
        
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
            
            
        Queue<Long> pq = new PriorityQueue<>();
        pq.add(Long.valueOf(1));
        
        for(int i = 0; i < n - 1; i++){
            Long curt = pq.poll();
            for(int j = 0; j < 3; j++){
                Long next = primes[j] * curt;
                if(!pq.contains(next)){
                    pq.add(next);
                }
            }
        }
        return pq.poll().intValue();
    }
}