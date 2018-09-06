/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode prem = dummy;
        for(int i = 0; i < m - 1; i++){
            prem = prem.next;
        }
        
        ListNode nextn = dummy;
        for(int i = 0; i < n + 1; i++){
            nextn = nextn.next;
        }
        
        ListNode mNode = prem.next;
        ListNode prev = prem.next, curt = prem.next.next;
        for(int i = 0; i < n - m; i++){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        prem.next = prev;
        mNode.next = nextn;
        return dummy.next;
    }
}