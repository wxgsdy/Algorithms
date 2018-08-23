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
        public int depth;
        public boolean isBalanced;
        public resultType(boolean isBalanced, int depth){
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
        
        
    }
    public boolean isBalanced(TreeNode root) {
        resultType result = helper(root);
        return result.isBalanced;
    }
    
    private resultType helper(TreeNode node){
        
        // exit
        if(node == null) return new resultType(true, 0);
        
        // split
        resultType left = helper(node.left);
        resultType right = helper(node.right);
        
        // merge
        if(Math.abs(left.depth - right.depth) > 1) return new resultType(false, -1);
        // if(!left.isBalanced || !right.isBalanced) return new resultType(false, -1);
        
        return new resultType(left.isBalanced & right.isBalanced, Math.max(left.depth, right.depth) + 1);
    }
}