/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy.next, right = dummy.next;
        while(right != null){
            
            if(left.val != right.val){
                left = left.next;
                left.val = right.val;
            }
            right = right.next;
        }
        
        left.next = null;
        return dummy.next;
    }
}