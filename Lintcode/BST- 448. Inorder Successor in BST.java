public class{

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){

		if(root == null || p == null) return null;
		if(p.val >= root.val) return inorderSuccessor(root.right, p);
		else{
			TreeNode left = inorderSuccessor(root.left, p);
			if(left != null) return left;
			else return right;
		}
	}
}