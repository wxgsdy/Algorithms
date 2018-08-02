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

// Divide and Conquer without defininig a new resultType class;
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || A == root || B == root) return root;
        
        // Divide 
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left == null && right == null) return null;
        if(left != null && right != null) return root;
        if (left != null && right == null) return left;
        return right; // if(left == null && right != null) 
        
        
     }
}



// Divide and Conquer: with resultType

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    
    private class resultType{
        public boolean findOne;
        public TreeNode lca;
        public resultType(boolean findOne, TreeNode lca){
            this.findOne = findOne;
            this.lca = lca;
        }
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        return helper(root, A, B).lca;
    }
    
    private resultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return new resultType(false, null);
        if(A == root) return new resultType(true, root);
        if(B == root) return new resultType(true, root);
        
        // Divde 
        resultType left = helper(root.left, A, B);
        resultType right = helper(root.right, A, B);
        
        if(left.findOne && right.findOne) return new resultType(true, root);
        if(left.findOne) return new resultType(true, left.lca);
        if(right.findOne) return new resultType(true, right.lca);
        return new resultType(false, null);
        
    }
}



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


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    private class resultType{
        public boolean findA, findB;
        public TreeNode lca;
        public resultType(boolean findA, boolean findB, TreeNode lca){
            this.findA = findA;
            this.findB = findB;
            this.lca= lca;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        
        resultType res = helper(root, A, B);
        if(res.findA && res.findB) return res.lca;
        else return null;
    }
    
    private resultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return new resultType(false, false, null);
        
        // Divde 
        resultType left = helper(root.left, A, B);
        resultType right = helper(root.right, A, B);
        
        
        // Conquer
        boolean a_exsist = left.findA || right.findA || root == A;
        boolean b_exsist = left.findB || right.findB || root == B;
        
        if(root == A || root == B) return new resultType(a_exsist, b_exsist, root);
        if(left.lca != null && right.lca != null) return new resultType(a_exsist, b_exsist, root);
        if(left.lca != null) return new resultType(a_exsist, b_exsist, left.lca);
        if(right.lca != null) return new resultType(a_exsist, b_exsist, right.lca);
        return new resultType(a_exsist, b_exsist, null);
        
    }
    



