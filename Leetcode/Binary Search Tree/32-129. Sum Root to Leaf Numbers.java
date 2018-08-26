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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        for(String s : paths(root)){
            sum += Integer.parseInt(s);
        }
        return sum;
        
    }
    
    
    
        
        
    private List<String> paths(TreeNode root){
        List<String> results = new ArrayList<>();
        if(root == null) return results;
        String path =  String.valueOf(root.val);
        
        helper(root, path, results);
        return results;
    }
    private void helper(TreeNode root, String path, List<String> results){
        
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            results.add(path);
            return;
        }
        
        if(root.left != null){
            helper(root.left, path + String.valueOf(root.left.val), results);
        }
        
        if(root.right != null){
            helper(root.right, path + String.valueOf(root.right.val), results);
        }
        
    }
}