class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;       
    }
    
    
    private void dfsHelper(int[] nums,
                           int startIndex,
                           ArrayList<Integer> subset,
                           List<List<Integer>>results){
        
        results.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
        
}