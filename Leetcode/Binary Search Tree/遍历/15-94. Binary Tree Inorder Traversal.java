// method 1 : Recursion -> traverse

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
     
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result);
        return result;
        
    }
    
    private void helper(TreeNode root, List<Integer> result){
        
        // exit
        if(root == null) return;
        
        // split
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}

// Method 2: Recursion -> Divide and Conquer
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
            
        // split 
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        // merge
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
        
    }
}

// Method 3: non-recursion 
public class Solution{
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curt = root;
		while(curt != null || !stack.empty()){
			while(curt != null){
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


