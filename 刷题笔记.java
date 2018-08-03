*****
* 1 * Binary Search 
*****


(1). Template

public int binarysearch(int[] nums, int taget)
{
	int start = 0, end = nums.length - 1;
	while(start + 1 < end)
	{
		int mid = start + (end - start) / 2;
		if(nums[mid] == target)        end = mid;
		else if(nums[mid] < target)    start = mid;
		else end = mid;
	}

	if(nums[start] == target) return start;
	if(nums[end] == target) return end;
	return -1;
}

(2)  159.Rotated Array
// Hint: find the first number <= the last number
public class Solution 
{
    
    public int findMin(int[] nums) 
    {
        if(nums == null || nums.length == 0) return -1;
        
        int start = 0, end = nums.length - 1;
        int cmp = nums[end];
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= cmp)   end = mid;
            else                   start = mid;
        }
         
        if(nums[start] <= cmp) return nums[start];
        else                   return nums[end];
    }
}

(3)  75.Find Peak Element
// hint: notebook
public class Solution 
{    
    public int findPeak(int[] nums) 
    {
        int start = 1, end = nums.length - 1;
        while(start + 1 < end)
        {
        	int mid = start + (end - start) / 2;
        	if(nums[mid] < nums[mid - 1])       end = mid;
        	else if(nums[mid] < nums[mid + 1])  start = mid;
        	else return mid;
        }

    	if(nums[start] < nums[end]) return end;
    	else return start;
    }
}

(4)  Lintcode 62:Search in Rotated Sorted Array
// Hint: notebook 3
public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) 
    {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end)
        {
        	int mid = start + (end - start) / 2;
        	if(nums[mid] == target) return mid;

        	if(nums[mid] > nums[start])
        	{
        		if(target >= nums[start] && nums[mid] >= target) end = mid;
        		else start = mid;
        	}

        	else
        	{
        		if(target >= nums[mid] && target <= nums[end]) start = mid;
        		else end = mid;
        	}
        }

        if(nums[start] == target) return start;
        else if(nums[end] == target) return end;
        else return -1;
    }
}

*****
* 2 * Binary Tree, Divede & Conquer 
*****

(5) Binary Tree Preorder Traversal
// Hint: notebook 3

// 1. Recursion
public class Solution 
{    
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root,res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res)
    {
    	if(root == null) return;
    	res.add(root.val);
    	traverse(root.left, res);
    	traverse(root.right, res);
    }
}

// 2. Divide & Conquer
public class Solution 
{    
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.add(root.val);

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        res.addAll(left);
        res.addAll(right);
        return res;
    }    
}

// 3. non-recursive traverse
public class Solution 
{    
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        stack.push(root);
        while(!stack.empty())
        {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(root.right);
            if(node.left != null) stack.push(root.left);
        }
        return res;
    }
}

6.  Lintcode 67: Binary Tree Inorder Traversal
// 1. Recursion
public class Solution 
{   
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        Traverse(root,res);
        return res;        
    }
    private void Traverse(TreeNode root, List<Integer> res)
    {
        if(root == null) return;
        Traverse(root.left,res);
        res.add(root.val);
        Traverse(root.right,res);
    }
}

// 2. non-recursion
public class Solution 
{    
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curt = root;
        while(curt != null || !stack.empty())
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
        return res;
    }
}

7.  Lintcode 68: Binary Tree Postorder Traversal

// 1.Recursion 
public class Solution 
{    
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer>();
        Traverse(root,res);
        return res;        
    }    
    private void Traverse(TreeNode root, List<Integer> res)
    {
        if(root == null) return;
        Traverse(root.left,res);
        Traverse(root.right,res);
        res.add(root.val);        
    }
}

// 2. non-recursion
// Hint: notebook 5
public class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
        
        if(root == null) return res;

        stack.push(root);
        while(!stack.empty())
        {
        	curr = stack.peek();
        	if((curr.left == null && curr.right == null)||(prev != null && (prev == curr.left || prev == curr.right)))
        	{
        		res.add(curr.val);
        		stack.pop();
        		prev = curr;
        	}	
        	else
        	{
        		if(curr.right != null) stack.push(curr.right);
        		if(curr.left != null) stack.push(curr.left);
        	}
        }
        return res;
    }
}

8. Lintcode 97. Maximum Depth of Binary Tree
// 1. Divede & Conquer
public class Solution {
    
    public int maxDepth(TreeNode root) 
    {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.Max(left,right) + 1;
    }
}

// 2. Recursion
public class Solution {
    
    private int depth;
    public int maxDepth(TreeNode root) 
    {
    	depth = 0;
    	depth(root,1);
    	return depth;
    }

    private void depth(TreeNode root, int currdepth)
    {
    	if(root == null) return;
    	if(currdepth > depth) depth = currdepth;
    	depth(root.right,currdepth + 1);
    	depth(root.left, currdepth + 1);
    }
}

9. 480. Binary Tree Paths
public class Solution {
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> paths = new ArrayList<>();
        //递归的出口
        if(root == null) return paths;
        if(root.left == null && root.right == null)
        {
            paths.add("" + root.val);
            return paths;
        }
        
        //递归的拆解
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for(String path : leftPaths)
            paths.add(root.val + "->" + path);
        for(String path : rightPaths)
            paths.add(root.val + "->" + path);
        return paths;
    }
}


10. Minimus subtree
//Hint : 使用全局变量，Divide & Conquer
public class Solution 
{
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) 
    {
    	helper(root);
    	return subtree;        
    }

    private int helper(TreeNode root)
    {
    	if(root == null) return 0;
    	int sum = helper(root.right) + helper(root.left) + root.val;
    	if(sum < suntreeSum)
    	{
    		subtree = root;
    		sum = subtreeSum;
    	} 
    	return sum;
    }
}

11. Lintcode 93. Balanced Binary Tree
//Hint: notebook 6
public class Solution 
{    
    public boolean isBalanced(TreeNode root) 
    {
        return helper(root) != -1;
    }

    private int helper(TreeNode root)
    {
    	if(root == null) return 0;
     	int left = helper(root.left);
    	int right = helper(root.right);
    	if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
    	return Math.max(left, right) + 1;
    	
    }
}

// 2. self-defined ResultType
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}

12. Subtree with Maximum Average
// Hint: notebook 7
public class Solution
{
	private class ResultType
	{
		public int sum,size;
		public ResultType(int sum, int size)
		{
			this.sum = sum;
			this.size = size;
		}
	}

	private TreeNode maxAverTree = null;
	private ResultType subTreeResult = null;

	public TreeNode findSubTree(TreeNode root)
	{
		helper(root);
		return maxAverTree;
	}

	private ResultType helper(TreeNode root)
	{
		if(root == null) return new ResultType(0,0);
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		ResultType rootReslut = new ResultType(
			left.sum + right.sum + root.val,
			left.size + right.sizr + 1)

		if(maxAverTree == null || rootReslut.sum *subTreeResult.size < subTreeResult.sum *rootReslut.size )
		{
			maxAverTree = root;
			subTreeResult = rootReslut;
		}
		return rootReslut;
	}
} 

13. Lowest Common Ancestor 
// 1. Divide & Conquer
public class Solution 
{
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) 
    {
        if(root == null || root == A || root == B) return root;

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}

// 2. self-defined ResultType
class ResultType
{
	public boolean a_exist, b_exist;
	public TreeNode node;
	public ResultType(boolean a, boolean b, TreeNode n)
	{
		this.a_exist = a;
		this.b_exist = b;
		this.node = n;
	}
}

public class Solution
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) 
	{
		ResultType rt = helper(root,A,B);
		if(rt.a_exist && rt.b_exist) return rt.node;
		else return null;
	}

	private ResultType helper(TreeNode root, TreeNode a, TreeNode b)
	{
		ResultType left_rt = helper(root.left,a,b);
		ResultType right_rt = helper(root.right,a,b);

		boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == a;
		boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == b;

		if(root == a || root == b)                              return new ResultType(a_exist,b_exist,root);
		if(left_rt.node != null && right_rt.node != null )      return new ResultType(a_exist,b_exist,root);
		if(left_rt.node != null)                                return new ResultType(a_exist,b_exist,left_rt.node);
		if(right_rt.node != null)                               return new ResultType(a_exist,b_exist,right_rt.node);
		return new ResultType(a_exist,b_exist,null);
	}
}

14. Lintcoe 95. Validate Binary Search Tree
// 1. Divede & Conquer + self-defined ResultType
class ResultType
{
    boolean is_bst;
    int maxValue, minValue;
    
    public ResultType(boolean is_bst, int max, int min)
    {
        this.is_bst = is_bst;
        this.maxValue = max;
        this.minValue = min;
    }
}
public class Solution {
    
    public boolean isValidBST(TreeNode root) 
    {
        ResultType rt = validateHelper(root);
        return rt.is_bst;
        
    }
    
    private ResultType validateHelper(TreeNode root)
    {
        if(root == null)
        	return new ResultType(true, Integer.minValue, Integer.maxValue);

        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);

        if(!left.is_bst || !right.is_bst) return new ResultType(false,0,0);
        if((left != null && left.maxValue >= root.val) ||(right != null && right.minValue <= root.val))
        	return new ResultType(false, 0 , 0);
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
        
    }
}

15. Lintcode.378. Convert Binary Search Tree to Doubly Linked List
// 1. Divide & Conquer + self-defined resultType
class ResultType
{
	DoublyListNode first ,last;
	public ResultType(DoublyListNode first, DoublyListNode last)
	{
		this.first = first;
		this.last = last;
	}
}
            
public class Solution 
{
    
    public DoublyListNode bstToDoublyList(TreeNode root) 
    {
        if(root == null) return null;
        ResultType rt = helper(root);
        return rt.first;
    }

    private ResultType helper(TreeNode root)
    {
    	if(root == null) return null;

    	ResultType left = helper(root.left);
    	ResultType right = helper(root.right);
    	ResultType res = new ResultType(null, null);
    	DoublyListNode node = new DoublyListNode(root.val);

    	if(left == null) res.first = node;
    	else
    	{
    		res.first = left.first;
    		left.last.next = node;
    		node.prev = left.last;
    	}

    	if(right == null) res.last = node;
    	else
    	{
    		node.next = right.first;
    		right.first.prev = node;
    		res.last = right.last;
    	}
    	return res;
    }
}

//2. Inorder Traverse


*****
* 3 *  Breath First Research 
*****

16. Lintcode 69. Binary Tree Level Order Traversal
// Hint : template for BFS
public class Solution
{
    
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}

17. Lintcode 178. Graph Valid Tree 
// hint:  notebook 8
public class Solution {
    
    public boolean validTree(int n, int[][] edges)
    {
        if(n == 0) return false;
        if(edges.length != n - 1) return false;
        
        Map<Integer, Set<Integer>> graph = initGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            for(Integer neighbor: graph.get(node))
            {
                if(set.contains(neighbor)) continue;
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }
        return set.size() == n;
        
    }
    
    
    private Map<Integer, Set<Integer>> initGraph(int n, int[][] edges)
    {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}



18. Lintcode 137. Clone Graph 
// hint:  notebook 9

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        if(node == null) return node;
        // find all nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // copy nodes
        Map<UndirectedGraphNode,UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n: nodes)
        {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        // copy edges
        for(UndirectedGraphNode n : nodes)
        {
            UndirectedGraphNode newNode = mapping.get(n);
            for(UndirectedGraphNode neighbor: n.neighbors)
            {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return mapping.get(node);
    }
    
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) 
    {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode neighbor: n.neighbors)
            {
                if(!set.contains(neighbor))
                {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
} 


19. Lintcode 127. Topological Sorting
// hint:  notebook 10

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) 
    {
        Map<DirectedGraphNode, Integer> indgree = new HashMap<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        
        // count indgree
        for(DirectedGraphNode node : graph)
        {
            for(DirectedGraphNode n : node.neighbors)
            {
                if(indgree.containsKey(n))
                    indgree.put(n, indgree.get(n) + 1);
                else
                indgree.put(n, 1);
            }
        }
        
        // get start nodes(没人指向的带你先入列)
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph)
        {
            if(!indgree.containsKey(node))
            {
                res.add(node);
                queue.offer(node);
            }
        }
        
        // bfs
        while(!queue.isEmpty())
        {
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode n : node.neighbors)
            {
                indgree.put(n, indgree.get(n) - 1);
                if(indgree.get(n) == 0)
                {
                    res.add(n);
                    queue.offer(n);
                }
            }
        }
        
        return res;
    }
}

20. Lintcode 433. Number of Islands 
// hint:  notebook 11

class Coordiate
{
    int x,y;
    public Coordiate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) 
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j])
                {
                    markByBFS(grid, i, j);
                    islands ++;
                }
            }
        }
        return islands;
    }
    
    private void markByBFS(boolean[][] grid, int x, int y)
    {
        int[] coordiateX = {0,1,-1,0};
        int[] coordiateY = {1,0,0,-1};
        
        Queue<Coordiate> queue = new LinkedList<>();
        queue.offer(new Coordiate(x,y));
        grid[x][y] = false;
        
        while(!queue.isEmpty())
        {
            Coordiate coor = queue.poll();
            for(int i = 0; i < 4; i++)
            {
                Coordiate adj = new Coordiate(coor.x + coordiateX[i], coor.y + coordiateY[i]);
                if(!inbound(adj, grid)) continue;
                if(grid[adj.x][adj.y])
                {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean inbound(Coordiate coor, boolean[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        return coor.x >=0 && coor.x < n && coor.y > 0 && coor.y < m;
    }
    
    
}



*****
* 4 *  Depth First Research 
*****
21. Lintcode 135. sum combination 

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        recursion(candidates, target, 0, combination, res);
        return res;
    }
    
    private void recursion(int[] candidates,
                           int remainTarget,
                           int startIndex,
                           List<Integer> combination,
                           List<List<Integer>> res)
    {
        if(remainTarget == 0)
        {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++)
        {
            if(remainTarget < candidates[i]) break;
            if(i != 0 && candidates[i] == candidates[i - 1]) continue;
            
            combination.add(candidates[i]);
            recursion(candidates, remainTarget - candidates[i], i, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}


22. Lintcode 15. Permutations
// notebook 12 
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null) return res;
        if(nums.length == 0)
        {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        recursion(nums, permutation, set, res);
        return res;
     }
    
    private void recursion(int[] nums,
                           List<Integer> permutation,
                           Set<Integer> set,
                           List<List<Integer>> res)
    {
        if(permutation.size() == nums.length) 
        {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(set.contains(nums[i])) continue;
            
            permutation.add(nums[i]);
            set.add(nums[i]);
            recursion(nums, permutation, set, res);
            permutation.remove(permutation.size() - 1);
            set.remove(nums[i]);
        }
    }
}


23. Lintcode 136. Palindrome Partitioning
// notebook 11
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) 
    {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        
        List<String> partition = new ArrayList<>();
        recursion(s, 0, partition, res);
        return res;
    }
    
    private void recursion(String s,
                           int startIndex,
                           List<String> partition,
                           List<List<String>> res)
    {
        if(startIndex == s.length())
        {
            res.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++)
        {
            String substring = s.substring(startIndex, i + 1);
            if(!isPalindrome(substring)) continue;
            
            partition.add(substring);
            recursion(s, i+1, partition, res);
            partition.remove(partition.size() - 1);
        }
        
    }
    
    private boolean isPalindrome(String s)
    {
        for(int i = 0, j = s.length() - 1; i < j; i++,j--)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        
        return true;
    }
}


24. Lintcode 16. Permutations II
// notebook 12 
public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        if(nums.length == 0)
        {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            visited[i] = 0;
        }
        List<Integer> permutation = new ArrayList<>();
        
        recursion(nums, visited, permutation, res);
        return res;
    }
    
    private void recursion(int[] nums,
                           int[] visited,
                           List<Integer> permutation,
                           List<List<Integer>> res)
    {
        if(permutation.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
            && visited[i-1] == 0)){
                continue;
            }
            
            visited[i] = 1;
            permutation.add(nums[i]);
            recursion(nums, visited, permutation, res);
            permutation.remove(permutation.size() - 1);
            visited[i] = 0;
        }
        
        
    }
                             
                           
};