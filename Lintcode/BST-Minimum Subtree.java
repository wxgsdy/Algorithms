// Description: find subtree with minimum sum 

// traverse + Divide & Conquer
class solution{

	private TreeNode node = null;
	private int minSum = Integer.MAX_VALUE;  

	public TreeNode findSubtree(TreeNode root){
		helper(root);
		return node;
	}

	private int helper(TreeNode root){
		if(root == null) return 0;

		int left = helper(root.left);
		int right = helper(root.right);
		int sum = left + right + root.val;
		if(sum < minSum){
			node = root;
			minSum = sum;
		}
		return sum;
	}


}



// Divide and Conquer
class Solution{


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

	public TreeNode findSubtree(TreeNode root) {
        return helper(root).node;
    } 


    private resultType helper(Treenode root){
    	if(root == null) return new resultType(null, 0, Integer.MAX_VALUE);
    	
    	// divide 
    	resultType left = helper(root.left);
    	resultType right = helper(root.right);

    	resultType res = new resultType(
    		root,
    		left.sum + right.sum + root.val,
    		left.sum + right.sum + root.val    		
    		)

    	if(left.minSum <= right.minSum){
    		res.node = left.node;
    		res.minSum = left.minSum;
    	}

    	if(right.minSum <= left.minSum){
    		res.node = right.node;
    		res.minSum = right.minSum;
    	}

    	return res;
    }
}