public class Solution{
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
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