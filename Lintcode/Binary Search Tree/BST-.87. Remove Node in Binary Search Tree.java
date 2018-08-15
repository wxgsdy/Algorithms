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
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    
    private TreeNode min(TreeNode root){
        if(root.left == null) return root;
        else return min(root.left);
        
    }
    
    private TreeNode deleteMin(TreeNode root){
        if(root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }
    
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null) return null;
        if(value < root.val) root.left = removeNode(root.left, value);
        else if(value > root.val) root.right = removeNode(root.right, value);
        else{
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;
            TreeNode t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }
}