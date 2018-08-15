//Description: Given a binary tree, find the subtree with maximum average. Return the root of the subtree.



// Divide and Conquer
class Solution{	

	private class resultType{
		public int size;
		public int sum;

		public resultType(int size, int sum){
			this.size = size;
			this.sum = sum;
		}
	}


	private resultType overall = null;
	private TreeNode subtree;

	public TreeNode findSubtree2(TreeNode root){
		helper(root);
		return subtree;
	}


	private resultType helper(TreeNode root){
		if(root == null) return new resultType(0,0);

		// Divide 
		resultType left = helper(root.left);
		resultType right = helper(root.right);

		resultType res = new resultType(
			left.size + right.size + 1,
			left.ssum + right.sum + root.val
			);

		if(overall == null){
			subtree = root;
			overall = res;
		}

		else if(res.sum * overall.size < res.size * overall.sum){
			subtree = root;
			overall = res;
		}
		return res;

	}
}

