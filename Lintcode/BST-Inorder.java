// Recursie -- Traverse
public class Solution {    
    public List<Integer> inorderTraversal(TreeNode root) {
        // order: left, mid, right
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
        
    }
    
    private void helper(TreeNode root, List<Integer> res){
        // 出口
        if(root == null) return;
        
        // 拆解
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

// Recursive -- Divide & Conquer
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        //Divide
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        // Conquer
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        
        return res;
    }
}

// non-recursive
public class Solution {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}