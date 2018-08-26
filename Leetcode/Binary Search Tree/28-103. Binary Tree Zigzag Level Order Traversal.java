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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int depth = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right!= null) queue.offer(node.right);
            }
            
            if(depth % 2 == 0) Collections.reverse(level);
            results.add(level);
            depth++;
        }
        
        return results;
    }
}