public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results  = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        
        bfsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void bfsHelper(int[] nums,
                      int startIndex,
                      List<Integer> subset,
                      List<List<Integer>> results){
        
        // exit
        results.add(new ArrayList<Integer>(subset));
        
        // split
        for(int i = startIndex; i < nums.length; i++){
            
            if(i != 0 && nums[i] == nums[i-1] && i > startIndex) continue;
            subset.add(nums[i]);
            bfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
                              
    }
}