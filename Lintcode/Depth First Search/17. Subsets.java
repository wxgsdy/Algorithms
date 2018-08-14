public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        bfsHelper(nums, 0, subset, results);
        return results;
        
        
    }
    
    // 在nums的startIndex以后数字， 寻找subset开头的子集， 并加入results
    private void bfsHelper(int[] nums,
                           int startIndex, 
                           List<Integer> subset,
                           List<List<Integer>> results){
    
        // exit        
        results.add(new ArrayList<Integer>(subset));
        
        // split
        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            bfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}