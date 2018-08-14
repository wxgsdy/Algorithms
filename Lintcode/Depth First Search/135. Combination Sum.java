public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return results;
        
        Arrays.sort(candidates);
        bfsHelper(candidates, 0, target, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void bfsHelper(int[] candidates, 
                           int startIndex, 
                           int remainTarget,
                           List<Integer> combination,
                           List<List<Integer>> results){
    
        //exit
        if(remainTarget == 0){
            results.add(new ArrayList<Integer>(combination));
        }
        
        // split
        for(int i = startIndex; i < candidates.length; i++){
            
            if(remainTarget < candidates[i]) break;
            if(i != 0 && candidates[i] == candidates[i - 1]) continue;
            combination.add(candidates[i]);
            bfsHelper(candidates, i, remainTarget - candidates[i], combination, results);
            combination.remove(combination.size() - 1);
        }
                               
   }
}