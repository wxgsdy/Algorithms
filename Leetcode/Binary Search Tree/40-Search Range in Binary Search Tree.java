public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    
    
    private List<Integer> result;
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    
        result = new ArrayList<>();
        if(root == null) return result;
         
         helper(root, k1, k2);
         return result;
    }

    private void helper(TreeNode root, int k1, int k2){

        //exit 
        if(root == null) return;

        // split
        if(k1 < root.val) helper(root.left, k1, k2);
        if(k1 <= root.val && k2 >= root.val) result.add(root.val);
        if(k2 > root.val) helper(root.right, k1, k2); 
        return;
    }
}