/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || k < 1) return head;
        int n = length(head);
        k = k % n;
        
        if(n == 1) return head;
        
        for(int i = 0; i < k; i++){
            head = rotate1(head);
        }        
        return head;
        
    }
    
    private int length(ListNode head){
        int length = 1;
        ListNode curt = head;
        while(curt.next != null){
            curt = curt.next;
            length ++;            
        }
        return length;
    }
    
    private ListNode rotate1(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pretail = dummy;
        while(pretail.next.next != null){
            pretail = pretail.next;
        }
        ListNode tail = pretail.next;
        pretail.next = null;
        dummy.next = tail;
        tail.next = head;
        return dummy.next;
    }
    
}