/**
 * Definition for ListNode
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
    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
     
    private ListNode findmid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        int index = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head1 != null && head2 != null){
            if(index % 2 == 0){
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
            index++;
        }
        if(head1 != null) tail.next = head1;
        if(head2 != null) tail.next = head2;
        return dummy.next;
    }
    
    
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return;
        ListNode mid = findmid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
        return;
    }
}