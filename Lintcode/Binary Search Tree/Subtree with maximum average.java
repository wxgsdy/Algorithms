public class Solution{

	private class resultType{
		public int size;
		public int sum;

		public resultType(int size, int sum){
			this.size = size;
			this.sum = sum;
		}
	}

	private TreeNode subtree = null;
	private resultType subtreeResult = null;

	public TreeNode findSubtree(TreeNode root){
		helper(root);
		return subtree;
	}

	private resultType helper(root){
		if(root == null) return new resultType(0,0);

		// divide
		resultType left = helper(root.left);
		resultType right = helper(rott.right);
		// Conquer
		result = new resultType(left.size + right.size + 1, left.sum + right.sum + root.val);
		if(subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size){
			subtree = root;
			subtreeResult = result;
		}

		return result;
	}







}