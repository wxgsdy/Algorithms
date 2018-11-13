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
    
    private List<Integer> curtLeaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>();
        curtLeaves = new ArrayList<>();
        while(root != null){
            curtLeaves.clear();
            root = deleteCurtLeaves(root);
            results.add(new ArrayList<>(curtLeaves));
        }
        return results;     
    }
    
    private TreeNode deleteCurtLeaves(TreeNode root){
        
        if(root == null) return null;
        if(root.left == null && root.right == null){
            curtLeaves.add(root.val);
            return null;
        } else {
            if(root.left != null) root.left = deleteCurtLeaves(root.left);
            if(root.right != null) root.right = deleteCurtLeaves(root.right);
        }
        return root;
        
        
    }
}