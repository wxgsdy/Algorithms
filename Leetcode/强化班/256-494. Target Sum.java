// DFS
class Solution {
    
    private int count;
    public int findTargetSumWays(int[] nums, int S) {
        
        count = 0;
        dfs(nums, 0, 0, S);
        return count;
    }
    
    private void dfs(int[] nums, int curtSum, int curtPos, int target){
       
        // exit
        if(curtPos == nums.length){            
            if(curtSum == target) count++;         
            return;
        }        
        dfs(nums, curtSum + nums[curtPos], curtPos + 1, target);
        dfs(nums, curtSum - nums[curtPos], curtPos + 1, target);
        
        
    }  
}

// Method 2: DFS + Memo
class Solution {
   
    private List<Map<Integer, Integer>> memo;
    public int findTargetSumWays(int[] nums, int S) {
        memo = new ArrayList<>();
        for(int i = 0; i < nums.length + 1; i++){
            memo.add(new HashMap<Integer, Integer>());
        }
        return dfsHelper(nums, S, 0);
    }
    
    private int dfsHelper (int[] nums, int remainSum, int curtPos){
        
        if(memo.get(curtPos).containsKey(remainSum)) return memo.get(curtPos).get(remainSum);
        
        if(curtPos == nums.length){
            if(remainSum == 0) {
                memo.get(curtPos).put(remainSum, 1);
                return 1;
            } else {
                memo.get(curtPos).put(remainSum, 0);
                return 0;
            }                
        }
        
        int res = dfsHelper(nums, remainSum + nums[curtPos], curtPos + 1) 
             + dfsHelper(nums, remainSum - nums[curtPos], curtPos + 1) ;
        
        memo.get(curtPos).put(remainSum, res);
        return res;
    }
}