// Divide and Conquer
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private class resultType{
        DoublyListNode start, end;
        public resultType(DoublyListNode start, DoublyListNode end){
            this.start = start;
            this.end = end;
        }
        
    }
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null) return null;
        resultType res = helper(root);
        return res.start;
    }
    
    private resultType helper(TreeNode root){
        if(root == null) return null;
        
        // Divide 
        resultType left= helper(root.left);
        resultType right = helper(root.right);
        resultType res = new resultType(null, null);
        
        DoublyListNode node = new DoublyListNode(root.val);
        
        if(left == null) res.start = node;
        else{
            res.start = left.start;
            left.end.next = node;
            node.prev = left.end;
        }
        
        if(right == null) res.end = node;
        else{
            res.end = right.end;
            node.next = right.start;
            right.start.prev = node;
        }
        
        return res;
        
        
    }    
    
}

// Traverse --> that is inorder traverse

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
   
    private DoublyListNode dummy = new DoublyListNode(0);
    private DoublyListNode tail = dummy;
    
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null) return null;
        helper(root);
        return dummy.next;
        
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        
        // split
        helper(root.left);
        
        DoublyListNode node = new DoublyListNode(root.val);
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
        
        helper(root.right);
    }
}