/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


// Divide and Conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */

    private class resultType{
    	public boolean isBalanced;
    	public int depth;

    	public resultType(boolean isBalanced, int depth){
    		this.isBalanced = isBalanced;
    		this.depth = depth;
    	}
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return helper(root).isBalanced;
    }

    private resultType helper(TreeNode root){
    	if(root == null) return new resultType(true, 0);


    	// Divide 
    	resultType left = helper(root.left);
    	resultType right = helper(root.right);

    	// Conquer
    	if(!left.isBalanced || !right.isBalanced) return new resultType(false, -1);
    	if(Math.abs(left.depth - right.depth) > 1)
    		return new resultType(false, -1);

    	return new resultType(true, Math.max(left.depth, right.depth) + 1);
    }


}