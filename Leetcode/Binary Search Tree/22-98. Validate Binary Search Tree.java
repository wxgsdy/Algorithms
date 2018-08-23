/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private class resultType{
        public boolean isValid;
        public TreeNode minNode, maxNode;
        public resultType(boolean isValid){
            this.isValid = isValid;
            this.minNode = null;
            this.maxNode = null;
        }
    } 
              
        
        
    public boolean isValidBST(TreeNode root) {
        
        return helper(root).isValid;
    }
    
    private resultType helper(TreeNode root){
        // exit 
        if(root == null) return new resultType(true);
        
        // split
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        // merge
        if(!left.isValid || !right.isValid) return new resultType(false);
        if(left.maxNode != null && left.maxNode.val >= root.val) return new resultType(false);
        if(right.minNode != null && right.minNode.val <= root.val) return new resultType(false);
        
        // is valid
        resultType result = new resultType(true);
        result.minNode = (left.minNode != null) ? left.minNode: root;
        result.maxNode = (right.maxNode != null) ? right.maxNode : root;
        return result;
    }
}