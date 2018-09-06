/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        //exit
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode mid = findmid(head);
        ListNode temp = mid.next;
        mid.next = null;
        
        TreeNode root = new TreeNode(temp.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp.next);
        return root;
    }
    
    private ListNode findmid(ListNode head){
        if(head == null) return null;
        ListNode slow = head, fast = head.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}