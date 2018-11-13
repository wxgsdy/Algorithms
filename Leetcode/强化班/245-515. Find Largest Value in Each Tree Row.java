/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BFS
class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int curtMax = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curt = queue.poll();
                curtMax = Math.max(curtMax, curt.val);
                if(curt.left != null) queue.offer(curt.left);
                if(curt.right != null) queue.offer(curt.right);
            }
            res.add(curtMax);         
        }
        return res;    
    }
}