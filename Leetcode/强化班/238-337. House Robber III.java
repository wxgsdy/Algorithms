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
    
    private Map<TreeNode, Integer> map;
    
    public int rob(TreeNode root) {
        
        if(root == null) return 0;
        map = new HashMap<>();       
        return dfs(root);
    }
    
    private int dfs(TreeNode root){
        
        // exit 
        if(map.containsKey(root)) return map.get(root);
        if(root == null) return 0;
        
        // split
        int val = 0;
        if(root.left != null){
            val += dfs(root.left.left) + dfs(root.left.right);
        }
        
        if(root.right != null){
            val += dfs(root.right.left) + dfs(root.right.right);
        }
        
        int temp = Math.max( root.val + val, dfs(root.left) + dfs(root.right));
        map.put(root, temp);        
        return temp;
    }
    
    
}