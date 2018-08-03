*****
* 1 * 双栈算数表达式求值算法
*****
思想：不断读取字符串，如果是运算符，则压入运算符栈；如果是“）”则弹出堆栈最上边的
      运算符和操作数，计算结果压入栈；如果是数值则压入操作数栈。
	  
public class Evaluate
{
	public void main(String[] args)
	{
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		while(!StdIn.isEmpty())
		{
			String s = StdIn.readString();
			if(s.equals("(")                       ;
			else if(s.equals("+"))      ops.push(s);
			else if(s.equals("-"))      ops.push(s);
			else if(s.equals("*"))      ops.push(s);
			else if(s.equals("/"))      ops.push(s);
			else if(s.equals("sqrt"))   ops.push(s);

			else if(s.equals(")"))
			{
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+"))      v = vals.pop() + v; 
				if(op.equals("-"))      v = vals.pop() - v;
				if(op.equals("*"))      v = vals.pop() * v;
				if(op.equals("/"))      v = vals.pop() / v;
				if(op.equals("sqrt"))   v = sqrt(v);
				vals.push(v);
			}

			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}



*****
* 2 *  二叉树的遍历： 递归和非递归
*****

   前序： 根 --> 左 --> 右
   中序： 左 --> 根 --> 右
   后序： 左 --> 右 --> 根


**********
* 递归实现*
**********

protected static void preorder(TreeNode p)
{
	if(p != null)
	{
		visit(p);
		preorder(p.left());
		preordr(p.right());		
	}
}

protected static void inorder(TreeNode p)
{
	if(p != null)
	{
		inorder(p.left());
		visit(p);
		inorder(p.right());
	}
}

protected static void postorder(TreeNode p)
{
	if(p != null)
	{
		postorder(p.left());
		postorder(p.right());
		visit(p);
	}
}

************
* 非递归实现*
************

对于任一节点P，
1）输出节点P，然后将其入栈，再看P的左孩子是否为空；
2）若P的左孩子不为空，则置P的左孩子为当前节点，重复1）的操作；
3）若P的左孩子为空，则将栈顶节点出栈，但不输出，并将出栈节点的右孩子置为当前节点，看其是否为空；
4）若不为空，则循环至1）操作；
5）如果为空，则继续出栈，但不输出，同时将出栈节点的右孩子置为当前节点，看其是否为空，重复4）和5）操作；
6）直到当前节点P为NULL并且栈空，遍历结束。

  public List<Integer> preorderTraversal(TreeNode root)
  {
  	Stack<TreeNode> stack = new Stack<TreeNode>();
  	List<Integer> preorder = new ArrayList<Integer>();

  	if(root == null) return preorder;

  	stack.push(root);
  	while(!stack.isEmpty())
  	{
  		TreeNode node = stack.pop();
  		preoder.add(node.val);
  		// first in stack, later output to out List
  		if(root.right != null) stack.push(root.right);
  		if(root.left != null) stack.push(root.left);
  	}
  	return preorder;
  }


  对于任一节点P，
1）若P的左孩子不为空，则将P入栈并将P的左孩子置为当前节点，然后再对当前节点进行相同的处理；
2）若P的左孩子为空，则输出P节点，而后将P的右孩子置为当前节点，看其是否为空；
3）若不为空，则重复1）和2）的操作；
4）若为空，则执行出栈操作，输出栈顶节点，并将出栈的节点的右孩子置为当前节点，看起是否为空，重复3）和4）的操作；
5）直到当前节点P为NULL并且栈为空，则遍历结束。

  public List<Integer> inorderTraverse(TreeNode root)
  {
  	Stack<TreeNode> stack = new Stack<TreeNode>();
  	List<Integer> res = new ArrayList<Integer>();

  	TreeNode curt = root;
  	while(curt != null || !stack.isEmpty())
  	{
  		while(curt != null)
  		{
  			stack.push(curt);
  			curt = curt.left;  			
  		}

  		curt = stack.pop();
  		res.add(curt.val);
  		curt = curt.right;
  	}
  }


  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;

    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) 
    {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) 
        { // traverse down the tree
            if (curr.left != null)          stack.push(curr.left);             
            else if (curr.right != null)    stack.push(curr.right);
            
        } 
        else if (curr.left == prev) 
        { // traverse up the tree from the left
            if (curr.right != null) 
                stack.push(curr.right);
            
        } 
        else 
        { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }

    return result;
}