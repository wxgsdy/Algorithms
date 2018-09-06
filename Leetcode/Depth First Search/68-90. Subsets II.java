class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfsHelper(int[] nums, 
                           int startIndex,
                           List<Integer> subset,
                           List<List<Integer>> results){
        
        results.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1] && i > startIndex) continue;
            
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}