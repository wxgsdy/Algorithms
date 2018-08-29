// Method 1: Pure inorder traversal
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
    DoublyListNode tail = dummy;
    
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if(root == null) return null;
        helper(root);
        return dummy.next;
        
    }
    
    private void helper(TreeNode root){
        
        // exit
        if(root == null) return;
        
        // split
        helper(root.left);
        
        DoublyListNode temp = new DoublyListNode(root.val);
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
        
        helper(root.right);
    }
}


// Method 2 : Divide and conquer with resultType
class resultType{
    public DoublyListNode first, last;
        
    public resultType(DoublyListNode first, DoublyListNode last){
        this.first = first;
        this.last = last;
    }
}

public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    
    
    
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if(root == null) return null;
        return helper(root).first;
        
    }
    
    private resultType helper(TreeNode root){
        if(root == null) return null;
        
        DoublyListNode node = new DoublyListNode(root.val);
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        resultType result = new resultType(null, null);
        
        if(left == null) result.first = node;
        else{
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        
        if(right == null) result.last = node;
        else{
            result.last = right.last;
            node.next = right.first;
            right.first.prev = node;
        }
        
        return result;
    }
}