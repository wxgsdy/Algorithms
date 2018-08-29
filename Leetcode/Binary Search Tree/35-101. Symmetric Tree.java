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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else{
            if(left.val != right.val) return false;
            return helper(left.right,right.left) && helper(left.left, right.right);
        }
    }
}