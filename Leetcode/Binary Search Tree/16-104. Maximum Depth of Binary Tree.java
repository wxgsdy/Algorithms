// Method 1: Divide and Conquer
class Solution {
    public int maxDepth(TreeNode root) {
        
        // exit and corner case
        if(root == null) return 0;
        
        // Divide 
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // merge
        return Math.max(left, right) + 1;
    }
}

// Method 2: Traverse

class Solution {
    
    private int depth;
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        depth = 1;
        helper(root, 1);
        return depth;
    }
    
    private void helper(TreeNode root, int curtDepth){
        
        // exit 
        if(root == null) return;
        if(curtDepth > depth) depth = curtDepth;
        
        // split
        helper(root.left, curtDepth + 1);
        helper(root.right, curtDepth + 1);
        
        
    }
}