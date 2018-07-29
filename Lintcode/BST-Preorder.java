// 1. Recursive -- Traverse
public class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // Preorder: mid, left, right
        List<Integer> res = new ArrayList<>(); 
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}


// 2. Recursive -- Divide & Conquer
public class Solution {    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        // Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        // Conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        
        return res;        
    }
}

// 3. non-recursive way
