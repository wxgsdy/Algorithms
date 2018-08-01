// Traverse
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
     
    private int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;
        helper(root, 1);
        return depth;
    }
    
    
    private void helper(TreeNode root, int currentDepth){
        // exit
        if(root == null) return;
        
        // split
        if(currentDepth > depth) depth = currentDepth;
        helper(root.right, currentDepth + 1);
        helper(root.left, currentDepth + 1);
        
    }
}


// Divide and Conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        // Divide 
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // Conquer
        return Math.max(left, right) + 1;
    }
}
