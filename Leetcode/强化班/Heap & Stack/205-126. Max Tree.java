public class Solution {
    /*
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // O(N) - Monotonous Stack
        if(A.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        for(int i = 0; i <= A.length; ++i) {
            TreeNode node = new TreeNode(i == A.length ? Integer.MAX_VALUE : A[i]);

            if(!stack.isEmpty() && stack.peek().val < node.val) {
                TreeNode curr = stack.pop();
                while(!stack.isEmpty() && stack.peek().val < node.val) {
                    TreeNode parent = stack.pop();
                    parent.right = curr;
                    curr = parent;
                }
                node.left = curr;
            }

            stack.push(node);
        }

        return stack.pop().left;
    }
}