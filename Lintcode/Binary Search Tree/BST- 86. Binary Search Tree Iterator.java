public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode curt = stack.peek();
        TreeNode node = curt;
        
        // dealing with next 
        if(node.right == null){
            node = stack.pop();
            while(!stack.isEmpty() && stack.peek().right == node){
                node = stack.pop();
            }
        } else {
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        
        return curt;
        
    }
}