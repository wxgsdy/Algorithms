// Divide and Conquer
public Solution{

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


	public TreeNode findSubtree(TreeNode root){
		return helper(root).node;
	}

	private resultType helper(TreeNode node){
		if(TreeNode == null) return new resultType(null, Integer.MAX_VALUE, 0);


		// Divide
		resultType left = helper(node.left);
		resultType right = helper(node.right);

		resultType res = new resultType(
			node,
			left.sum + right.sum + node.val,
			left.sum + right.sum + node.val
			);

		if(left.minSum <= right.minSum){
			res.minSum = left.minSum;
			res.node = left.node;
		}

		if(right.minSum <= left.minSum){
			res.minSum = right.minSum;
			res.node = right.node;
		}

		return res;
	}

}


// Traverse
public Solution{

	private TreeNode minSubtree = null;
	private int minSum = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root){

		helper(root);
		return minSubtree;
	}

	private int helper(TreeNode node){
		if(node === null) return 0;

		int sum = helper(root.left) + helper(root.right) + root.val;
		if(sum < minSum){
			minSum = sum;
			minSubtree = node;
		}

		return sum;



	}
}