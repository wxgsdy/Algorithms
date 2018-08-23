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

public class Solution{

	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root == null) return res;

		while(root != null){
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpety()){
			TreeNode node = stack.peek();
			res.add(node.val);

			if(node.right != null){
				node = node.right;
				while(node != null){
					stack.push(node);
					node = node.left;
				}
			} else {
				node = stack.pop();
				while(!stack.isEmpety() && stack.peek().right == node){
					node = node.left;
				}
			}
		}


	}
}