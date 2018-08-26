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
    
    private boolean result = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null) return result;
        
        helper(root, root.val, sum);
        return result;
        
    }
    
    private void helper(TreeNode node, int curtSum, int target){
        
        if(node == null) return;
        if(node.left == null && node.right == null){
            if(curtSum == target){
                result = true;
                return;
            }
        }
        if(node.left != null) helper(node.left, curtSum + node.left.val,target);
        if(node.right != null) helper(node.right, curtSum + node.right.val, target);
    }
}