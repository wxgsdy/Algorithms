public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        
        Arrays.sort(nums);
        bfsHelper(nums, visited, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void bfsHelper(int[] nums, 
                      boolean[] visited,
                      List<Integer> permutation,
                      List<List<Integer>> results){
                          
        //exit
        if(permutation.size() == nums.length){
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        // split
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            
            permutation.add(nums[i]);
            visited[i] = true;
            bfsHelper(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
                          
    }
}