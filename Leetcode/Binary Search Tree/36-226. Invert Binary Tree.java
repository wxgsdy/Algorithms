/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) return;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
    

}