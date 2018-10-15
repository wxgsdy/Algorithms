class Solution {
    // numner Set: 1 - 9
    // 答案集合的大小： k
    // target ： n
    
    // 限制： 无重复待选集， 每个数字只能选一次
    
    List<List<Integer>> results;
    
    public List<List<Integer>> combinationSum3(int k, int target) {
        results = new ArrayList<>();
        
        helper(1, new ArrayList<Integer>(), target, k);
        return results;
    }
    
    private void helper(int start, 
                        List<Integer> curt,
                        int remainTarget,
                        int k){
        
        if(remainTarget == 0 && curt.size() == k){
            results.add(new ArrayList<>(curt));
            return;
        }
        
        for(int i = start; i <= 9; i++){            
            if(i > remainTarget) break;         
            
            curt.add(i);
            helper(i + 1, curt, remainTarget - i, k);
            curt.remove(curt.size() - 1);            
        }
    }
}