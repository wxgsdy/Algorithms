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
    
    List<List<Integer>> results = new ArrayList<>();   
        
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        
        if(root == null) return results;
        
        List<Integer> init = new ArrayList<>();
        init.add(root.val);
        
        helper(root, init, root.val, sum);
        
        return results;
    }
    
    private void helper(TreeNode node, List<Integer> curt, int curtSum, int target){
        
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            if(curtSum == target){
                results.add(curt);
                return;
            }
        }
        
        if(node.left != null){    
            
            List<Integer> temp = new ArrayList<>(curt);
            temp.add(node.left.val);
            helper(node.left, temp, curtSum + node.left.val, target);            
            
        } 
        
        if(node.right != null){            
            List<Integer> temp = new ArrayList<>(curt);
            temp.add(node.right.val);
            helper(node.right, temp, curtSum + node.right.val, target);
            
        }
            
    }
}