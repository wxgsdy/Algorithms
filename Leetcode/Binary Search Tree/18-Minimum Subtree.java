// Solution 1: traverse + Divide & Conquer

public class Solution {
    
    private int minSum = Integer.MAX_VALE;
    private Treenode res = null;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root){

        // exit
        if(root == null) return 0;

        // split
        int sum = helper(root.left) + helper(root.right) + root.val;
        if(sum < minSum){
            minSum = sum;
            res = root;
        }
        return sum;

    }   
}


// Solution 2: Define a resultType


public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private class resultType{
        public TreeNode node;
        public int sum;
        public int minSum;
        public resultType(TreeNode node, int sum, int minSum){
            this.node = node;
            this.sum = sum;
            this.minSum = minSum;
        }
    }


    public TreeNode findSubtree(TreeNode root) {
        resultType result = helper(root);
        return result.node;
    }
    

    private resultType helper(TreeNode root){

        if(root == null) return new resultType(null, 0, Integer.MAX_VALUE);

        resultType left = helper(root.left);
        resultType right = helper(root.right);

        resultType result = new resultType(
            root, 
            left.sum + right.sum,
            left.sum + right.sum);

        if(left.minSum <= result.minSum){
            result.minSum = left.minSum;
            result.node = left.node;
        }

        if(right.minSum < result.minSum){
            result.minSum = right.minSum;
            result.node = right.node;
        }

        return result;

    }
    
}