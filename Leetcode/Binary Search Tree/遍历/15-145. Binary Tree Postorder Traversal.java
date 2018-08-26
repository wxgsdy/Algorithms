// Divide and Conquer
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        // divide
        List<Integer> left  = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        
        // merge
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        
        return result;
    }
}