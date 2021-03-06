/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) return head;
        ListNode slow = head, fast = head.next;
        
        while(slow != fast){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        while(slow != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}