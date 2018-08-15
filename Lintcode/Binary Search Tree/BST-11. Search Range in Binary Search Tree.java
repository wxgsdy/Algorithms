public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    private void helper(TreeNode root, List<Integer> res, int k1, int k2){
        if(root == null) return;
        
        if(k1 < root.val) helper(root.left, res, k1, k2);
        if(k1 <= root.val && k2 >= root.val) res.add(root.val);
        if(k2 > root.val) helper(root.right, res, k1, k2);
    }
    
    
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, k1, k2);
        return res;
        
        
    }
}