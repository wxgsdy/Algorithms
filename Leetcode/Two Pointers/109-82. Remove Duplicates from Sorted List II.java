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
        ListNode prev = dummy;
        
        while(prev.next != null){
            ListNode curt = prev.next;
            while(curt.next != null && curt.next.val == curt.val){
                curt = curt.next;
            }
            
            if(curt != prev.next) prev.next = curt.next;
            else prev = prev.next;
        }
        
        return dummy.next;       
        
       
    }
}