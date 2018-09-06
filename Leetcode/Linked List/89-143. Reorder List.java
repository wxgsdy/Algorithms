/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);      
        head = merge(head, right);
        return;
        
    }
    
    
    private ListNode findMid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null, curt = head;
        while(curt != null){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
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
}