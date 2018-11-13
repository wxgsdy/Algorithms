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
    
    public int findBottomLeftValue(TreeNode root) {
        
        // root is assumed to be not null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int left = 0;
        while(!queue.isEmpty()){
            int size = queue.size();            
            for(int i = 0; i < size; i++){
                TreeNode curt = queue.poll();
                if(i == 0) left = curt.val;
                if(curt.left != null) queue.offer(curt.left);
                if(curt.right != null) queue.offer(curt.right);
            }
        }
        return left;
    }
}