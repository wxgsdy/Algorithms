/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        ListNode node = headA;
        while(node.next != null){
            node = node.next;
        }
        node.next = headB;
        ListNode result = findEntrance(headA);
        node.next = null;
        return result;
    }
    
    
    private ListNode findEntrance(ListNode head){
        
        ListNode slow = head, fast = head.next;
        
        // meet first time
        while(slow != fast){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        fast = fast.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}