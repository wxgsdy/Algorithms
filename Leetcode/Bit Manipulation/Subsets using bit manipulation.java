class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) return results;
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < (1<<n); i++){
            List<Integer> curt = new ArrayList<>();
            // from number to subset
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    curt.add(nums[j]);
                }
            }
            results.add(curt);
        }
        return results;        
    }
}