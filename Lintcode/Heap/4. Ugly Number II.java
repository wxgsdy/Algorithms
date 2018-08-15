public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        
        
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < primes.length; i++){
            set.add(primes[i]);
            pq.add(primes[i]);
        }
        
        Long number = Long.valueOf(1);
        for(int i = 1; i < n; i++){
            number = pq.poll();
            for(int j = 0; j < 3; j++){
                if(!set.contains(primes[j] * number)){
                set.add(primes[j] * number);
                pq.add(primes[j] * number);
                }
            }
            
        }
        return number.intValue();
    }
}