public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        if(stones == null || stones.length == 0) return false;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for(int i = 0; i< stones.length; i++){
        	dp.put(stones[i], new HashSet<Integer>());
        }
        dp.get(stones[0]).add(0);

        for(int i = 0; i < stones.length; i++){
        	int curtStone = stones[i];

        	for(int k : dp.get(curtStone)){
        		if(k - 1 > 0 && dp.containsKey(curtStone + k - 1)) dp.get(curtStone + k - 1).add(k - 1);
        		if(dp.containsKey(curtStone + k)) dp.get(curtStone + k).add(k);
        		if(dp.containsKey(curtStone + k + 1)) dp.get(curtStone + k + 1).add(k + 1);
        	}        	
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}