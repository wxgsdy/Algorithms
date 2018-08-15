// Divide and Conquer
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        if(root.left == null && root.right == null) 
            res.add("" + String.valueOf(root.val));
        
        // Divide
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        // Conquer
        for(String path : leftPaths) 
            res.add(String.valueOf(root.val) + "->" + path);
            
        for(String path : rightPaths) 
            res.add(String.valueOf(root.val) + "->" + path);
        
        
        return res;
    }
}

// Traverse
public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        
        
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, String.valueOf(root.val), res);
        return res;
    }
    
    
    
    private void helper(TreeNode root, String path, List<String> res){
        if(root == null) return;
        
        // split
        if(root.left == null && root.right == null){
            res.add(path);
            return;
        }
        
        if(root.left != null)
            helper(root.left, path + "->" + String.valueOf(root.left.val), res);
            
        if(root.right != null)
            helper(root.right, path + "->" + String.valueOf(root.right.val), res);
    }
}