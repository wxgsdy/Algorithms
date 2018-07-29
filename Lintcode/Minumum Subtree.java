// Description: 给一棵二叉树, 找到和为最小的子树, 返回其根节点;

// Traverse(kind of combining Divide & Conquer)
public Solution{

	private TreeNode subtree = null;
	private int subtreeSum = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtree;
	}

	private int helper(TreeNode root){
		if(root == null) return 0;

		int sum = helper(root.left) + helper(root.right) + root.val;
		if(sum < subtreeSum){
			subtree = root;
			subtreeSum = sum;
		}
		return sum;
	}
}

// Divide & Conquer

public class solution{

	private class resultType{
		public TreeNode subtree;
		public int sum, minSum;

		public resultType(TreeNode subtree, int sum, int minSum){
			this.subtree = subtree;
			this.sum = sum;
			this.minSum = minSum;
		}
	}

	public TreeNode findSubtree(TreeNode root) {

		resultType res = helper();
		return res.subtree;
	}

	private resultType helper(TreeNode root){
		if(root == null) return new resultType(null, 0, Integer.MAX_VALUE);

		// Divide
		resultType left = helper(root.left);
		resultType right = helper(root.right);

		resultType res = new resultType(
			node, 
			left.sum + right.sum + root.val,
			left.sum + right.sum + root.val
			)

		if(right.minSum <= left.minSum){
			res.subtree = right.subtree;
			res.minSum = right.minSum;
		}

		if(right.minSum >= left.minSum){
			res.subtree = left.subtree;
			res.minSum = left.minSum;
		}

		return res;

	}


}

