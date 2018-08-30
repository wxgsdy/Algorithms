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
    
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        if(isLeaf(root)) return 1;
        
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth ++;
            for(int i = 0; i < size; i++){
                TreeNode curt = queue.poll();
                if(isLeaf(curt)) return depth;
                
                if(curt.left != null) queue.offer(curt.left);
                if(curt.right != null) queue.offer(curt.right);
            }
        }
        return depth;
        
    }
    
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}