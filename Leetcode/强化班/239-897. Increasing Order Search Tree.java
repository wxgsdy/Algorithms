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
    
    
    private TreeNode dummy, tail;
        
    public TreeNode increasingBST(TreeNode root) {
        
        if(root == null) return null;
        dummy = new TreeNode(0);
        tail = dummy;
        dummy.left = null;
        
        dfs(root);
        return dummy.right;
        
    }
    
    // in order
    private void dfs(TreeNode curt){
        
        // exit 
        if(curt == null) return;
        
        // split
        dfs(curt.left);
        
        tail.right = curt;
        curt.left = null;
        tail = tail.right;
        
        dfs(curt.right);      
    }
    
    
}