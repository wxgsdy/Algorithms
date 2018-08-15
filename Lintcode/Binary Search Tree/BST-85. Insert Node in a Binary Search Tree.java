public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        
        if(root.val < node.val) root.right = insertNode(root.right, node);
        if(root.val > node.val) root.left = insertNode(root.left, node);
        if(root.val == node.val) root.val = node.val;
        return root;
    }
}