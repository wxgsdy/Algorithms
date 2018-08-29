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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        return treeBuilder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    } 
    
    
    
    private int searchIndex(int[] arr, int start, int end, int target){
        
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                return i;
            }
        }        
        return -1;
    }
    
    private TreeNode treeBuilder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        // exit
        if(inStart > inEnd) return null;
        
        // split
        int rootIndex = searchIndex(inorder, inStart, inEnd, preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left  = treeBuilder(preorder, preStart + 1, preStart + rootIndex - inStart , inorder, inStart, rootIndex - 1);        
        root.right = treeBuilder(preorder, rootIndex - inEnd + preEnd + 1,preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}