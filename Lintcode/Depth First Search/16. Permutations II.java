public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            visited[i] = false;
        }
        
        dfsHelper(nums, visited, new ArrayList<Integer>(),results);
        return results;
    }
    
    private void dfsHelper(int[] nums,
                           boolean[] visited,
                           List<Integer> permutation,
                           List<List<Integer>> results){
                               
        // exit
        if(permutation.size() == nums.length){
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        // split
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue;
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfsHelper(nums, visited, permutation,results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
                               
    } 
    
    
    
    
    
    
};