// fangfa 1:
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }


    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void dfs(int[] nums, 
                     int startIndex,
                     List<Integer> subset,
                     List<List<Integer>> results){
                         
        // exit
        results.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}


// fangfa2:
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //if(nums == null || nums.length == 0) return result;
        
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();
        dfs(nums, 0, combination, result);
        return result;
    }
    
    
    // 定义：  subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
    private void dfs(int[] nums,
                int index,
                List<Integer> combination,
                List<List<Integer>> result){
    
        // 出口
        if(index == nums.length){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        // 拆解
        
        // 选了nums[index]
        combination.add(nums[index]);
        dfs(nums, index + 1, combination, result);
        
        //不选 nums[index]
        combination.remove(combination.size() - 1);
        dfs(nums, index + 1, combination, result);
    }
    
    
}