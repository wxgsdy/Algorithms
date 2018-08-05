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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 1) return head;
        int length = 0;
        ListNode checkpoint = head;
        while(checkpoint != null){
            length ++;
            checkpoint = checkpoint.next;
        }
        k = k % length;
        
        
        for(int i = 0; i < k; i++){
            head = rotateRight1(head);
        }
        return head;
        
    }
    
    private ListNode rotateRight1(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        while(tail.next.next != null){
            tail = tail.next;
        }
        
        ListNode move = tail.next;
        move.next = head;
        dummy.next = move;
        tail.next = null;
        return dummy.next;
    }
}