class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;                
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);        
        dfsHelper(nums, visited, new ArrayList<Integer>(), results);
        return results;        
    }    
    
    private void dfsHelper(int[] nums,
                           boolean[] visited,
                           List<Integer> permutation,
                           List<List<Integer>> results){
        
        // return 
        if(permutation.size() == nums.length){
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        // 
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true) continue;
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfsHelper(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;            
        }
    }
}