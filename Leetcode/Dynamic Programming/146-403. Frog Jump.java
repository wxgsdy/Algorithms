class Solution {
    
    public boolean canCross(int[] stones) {
        
        // state is a map, stone unit index -> last steps took to dump to this stone
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int stone : stones){
            map.put(stone, new HashSet<Integer>());
        }
        map.get(stones[0]).add(0);
        
        // build state map
        for(int i = 0; i < n - 1; i ++){
            int curtStone = stones[i];
            for(int k : map.get(curtStone)){
                // k - 1
                if(k - 1 > 0 && map.containsKey(curtStone + k - 1)){
                    map.get(curtStone + k - 1).add(k-1);
                }
                
                // k
                if(map.containsKey(curtStone + k)){
                    map.get(curtStone + k).add(k);
                }
                
                // k + 1
                if(map.containsKey(curtStone + k + 1)){
                    map.get(curtStone + k + 1).add(k + 1);
                }
            }
        }
        
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}