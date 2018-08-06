public class Solution {
    public  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, combination, result);

        return result;
    }

     void dfs(int[] candidates,
                 int startIndex,
                 int remainTarget,
                 List<Integer> combination,
                 List<List<Integer>> result) {
                     
        if (remainTarget == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
    
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainTarget) break;
            if(i != 0 && candidates[i] == candidates[i - 1] && i > startIndex) continue;

            combination.add(candidates[i]);
            dfs(candidates, i + 1, remainTarget - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}