/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null && head.next.next != null){
            head = reverseNext2(head);
        }        
        return dummy.next;       
    }
    
    
    private ListNode reverseNext2(ListNode head){
        // Assert there are two nodes after head
        ListNode prev = head.next;
        ListNode curt = prev.next;
        ListNode next = curt.next;
        head.next = curt;
        curt.next = prev;
        prev.next = next;
        return prev;        
    }
}

