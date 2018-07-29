/* Binary Search Tree based symble table
* Methods:
*	1) public int size(): return size of BST
*	2) public Value get(Key key): search by key value
*	3) public void put(Key key, Value val): insert new key-value pair
*	4) public Key min(), public Key max(), 
*      public Key floor(Key key):  max key value that <= key
	   public Key ceiling (Key key): min  key value that >= key
	5) public int rank(Key key): Return the number of keys in the symbol table strictly less than;
	   public Key select(int k): Return the key in the symbol table whose rank is {@code k};
*
*
*/

public class BST<Key extends Comparable<Key>, Value>{

	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int N;

		private Node(Key k, Value v, int n){
			this.key = k;
			this.val = v;
			this.N = n;
		}
	}

	private Node root;


	// (1)
	private int size(Node root){
		if(root == null) return 0;
		else return root.N;
	}

	public int size(){
		return size(root);
	}


	// (2)
	private Value get(Node root, Key key){
		if(root == null) return null;
		int cmp = key.compareTo(root.val);
		if(cmp < 0) return get(root.left, key);
		else if(cmp > 0) return get(root.right, key);
		else return root.val;
	}
	public Value get(Key key){
		return get(root, key);
	}

	// (3)
	private Node put(Node root, Key key, Value val){
		if(root == null) return new Node(key, val, 1);
		int cmp = val.compareTo(root.val);
		if(cmp < 0)         x.left = put(root.left, key, val);
		else if(cmp > 0)    x.right = put(root.right, key, val);
		else root.val = val;
		root.N = size(root.left) + size(root.right) + 1;
		return root;
	}

	public void put(Key key, Value val){
		root = put(root, key, val);
	}


	// (4) min, max
	private Node min(Node root){
		if(root.left == null) return root;
		else  return root.left;
	}

	public Key min(){
		return min(root).key;
	}

	private Node max(Node root){
		if(root.right == null) return root;
		else return max(root.right);
	}
	public Key max(){
		return max(root).key;
	}

	// floor: max key value <= key
	private Node floor(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;	
	}

	public Key floor(Key key){
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}
	

	// ceiling: min key that >= key
	private Node ceiling(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp > 0) return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if(t != null) return t;
		else return x;
	}

	public Key ceiling(Key key){
		Node x = ceiling(Node root, key);
		if(x == null) return null;
		return x.key;
	}


	// (5) rank and select
	private int rank(Node x, Key key){
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return size(x.left);
		else if(cmp > 0) return size(x.left) + 1 + rank(x.right, key);
		else return rank(x.left, key);
	}

	public int rank(Key key){
		return rank(root, key);
	}

	private Node select(Node x, int k){
		if(x == null) return null;
		int t = size(x.left);
		if(t > k) return select(x.left, k);
		else if(t < k) return select(x.right, k - 1 - t);
		else return x;		
	}

	public Key select(int k){
		return select(root, k).key;
	}


	






}