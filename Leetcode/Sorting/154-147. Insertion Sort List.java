/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(head.val);
        head = head.next;
        while(head != null){
            int val = head.val;
            ListNode p1 = dummy, p2 = dummy.next;
            while(p2 != null && p2.val < val){
                p1 = p1.next;
                p2 = p2.next;                
            }
            ListNode temp = new ListNode(val);
            temp.next = p2;
            p1.next = temp;
            head = head.next;
        }
        
        return dummy.next;
    }
}