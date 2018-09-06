class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null) return results;
        if(candidates.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        
        Arrays.sort(candidates);
        dfsHelper(candidates, 0, target, new ArrayList<Integer>(), results);
        return results;
        
    }
    
    private void dfsHelper(int[] candidates,
                           int startIndex,
                           int remainTarget,                          
                           List<Integer> combination,
                           List<List<Integer>> results){
        
        if(remainTarget == 0){
            results.add(new ArrayList<Integer>(combination));
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            
            if(remainTarget < candidates[i]) break;
            // if(i != 0 && candidates[i] == candidates[i - 1]) continue;
            
            combination.add(candidates[i]);
            dfsHelper(candidates, i, remainTarget - candidates[i], combination, results);
            combination.remove(combination.size() - 1);
            
        }
    }
}