class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        dfsHelper(nums, 0, target, new ArrayList<Integer>(), results);
        return results;
        
        
    }
    
    private void dfsHelper(int[] nums,
                           int startIndex,
                           int remainTarget,
                           List<Integer> combination,
                           List<List<Integer>> results){
        
        if(remainTarget == 0){
            results.add(new ArrayList<Integer>(combination));            
        }
        
        for(int i = startIndex; i < nums.length; i++){
            
            if(remainTarget < nums[i]) break;
            if(i != 0 && nums[i] == nums[i - 1] && i > startIndex) continue;
            
            combination.add(nums[i]);
            dfsHelper(nums, i + 1, remainTarget - nums[i], combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}