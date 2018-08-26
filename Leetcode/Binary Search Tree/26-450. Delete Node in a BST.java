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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        // exit 
        if(root == null) return null;
        
        // split
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
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
    
    private TreeNode min(TreeNode root){
        //exit
        if(root.left == null) return root;
        else return min(root.left);
    }
    
    private TreeNode deleteMin(TreeNode root){
        if(root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }
}