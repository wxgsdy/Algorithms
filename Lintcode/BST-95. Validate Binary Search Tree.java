/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    
    private class resultType{
        public boolean isBST;
        public TreeNode maxNode, minNode;
        public resultType(boolean isBST){
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    private resultType helper(TreeNode root){
        if(root == null) return new resultType(true);
        
        // Divide 
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        // Conquer
        if(!left.isBST || !right.isBST) return new resultType(false);
        if(left.maxNode != null && left.maxNode.val >= root.val) return new resultType(false);
        if(right.minNode != null && right.minNode.val <= root.val) return new resultType(false);
        
        resultType res = new resultType(true);
        
        if(left.minNode != null) res.minNode = left.minNode;
        else res.minNode = root;
        
        if(right.maxNode != null) res.maxNode = right.maxNode;
        else res.maxNode = root;
        
        return res;
        
    }
    
    
    
    
    
    
    
    
    
}