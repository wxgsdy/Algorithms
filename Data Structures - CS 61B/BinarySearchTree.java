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

	6) public void deleteMin()
	   public void deleteMax()

	7) public void delete(Key key)；
	8) public Iterable<Key> (Key lo, hi);
	9) public int size(Key lo, Key hi): override;

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


	// deleteMin and deleteMax
	prvivate Node deleteMin(Node x){
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMin(){
		if(isEmpty()) throw new NoSuchElementException("Symbol table underflow!");
		root = deleteMin(root);		
	}

	private Node deleteMax(Node x){
		if(x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax(){
		if(isEmpty()) throw new NoSuchElementException("Symbol table underflow!");
		root = deleteMax(root);
	}


	// delete
	private Node delete(Node x, Key key){
		if(x == null) return null;

		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, key);
		else if(cmp > 0) x.right = delete(x.righ, key);
		else{
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(t.right);
			x.left = t.right;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	// delete node with no child: modify the parents' link;
	// delete node with one child: the only child serves as the successor;
	// delete node with two children: sucessor is the smallest in the right tree;

	public void delete(Key key){
		if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
		root = delete(root, key);		
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
		// exit 
		if(x == null) return;

		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0) keys(x.left, queue, lo,hi);
		if(cmplo<=0 && cmphi >=0) queue.enqueue(x.key);
		if(cmphi>0) keys(x.right, queue, lo, hi);
	}

	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> = new Queue<Key>;
		keys(root, queue, lo, hi);
		return queue;
	}

	public int size(Key lo, Key hi){
		if(lo.compareTo(hi) > 0) return 0;
		if(contains(hi)) return rank(hi) - rank(lo) + 1;
		else return rank(hi) - rank(lo);
	}
	



	






}