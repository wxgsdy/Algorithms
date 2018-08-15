/* Flatten a binary tree to a fake "linked list" in pre-order traversal.
* Here we use the right pointer in TreeNode as the next pointer in ListNode.
*/

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    
    private TreeNode lastNode = null; 
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
        
    }
}