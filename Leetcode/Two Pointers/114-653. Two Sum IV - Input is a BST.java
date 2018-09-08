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
    
    private Set<Integer> set = new HashSet<>();
    private boolean result = false;    
    
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        helper(root, k);
        return result;
        
    }    
    
    
    private void helper(TreeNode root, int k){
        
        // exit
        if(root == null) return;        
        
        helper(root.left, k);
        
        if(set.contains(k - root.val)) result = true;
        else{
            set.add(root.val);
        }       
        
        helper(root.right, k);
        
        
    }
    
    
}