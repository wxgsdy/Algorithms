class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        bfsHelper(nums, visited, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void bfsHelper(int[] nums,
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
            if(i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) continue;
            
            permutation.add(nums[i]);
            visited[i] = true;
            bfsHelper(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
            
                
        }
    }
    
    
}