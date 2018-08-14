public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) return results;
        
        Arrays.sort(nums);
        bfsHelper(nums, 0, target, new ArrayList<Integer>(), results);
        return results;
        
    }
    
    private void bfsHelper(int[] nums,
                           int startIndex,
                           int remainTarget,
                           List<Integer> combination,
                           List<List<Integer>> results){
        // exit
        if(remainTarget == 0){
            results.add(new ArrayList<Integer>(combination));
        }
        
        // split
        for(int i = startIndex; i < nums.length; i++){
            
            if(remainTarget < nums[i]) break;
            if(i != 0 && nums[i] == nums[i - 1] && i > startIndex) continue;
            combination.add(nums[i]);
            bfsHelper(nums, i+1, remainTarget - nums[i], combination, results);
            combination.remove(combination.size() - 1);
        }
                                   
    }
}