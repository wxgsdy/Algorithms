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
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            head = reverseNextk(head, k);
        }
        return dummy.next;
    }
    
    // head -> n1 -> n2 -> .. -> nk -> next
    // head -> nk -> ... -> n1 -> next
    // return n1
    
    private ListNode reverseNextk(ListNode head, int k){
        
        // check there are enough nodes for reversing
        ListNode checkpoint = head;
        for(int i = 0; i < k; i++){
            if(checkpoint.next == null) return checkpoint;
            checkpoint = checkpoint.next;
        }
        
        ListNode prev = head, curt = head.next,n1 = head.next;
        for(int i = 0; i < k; i++){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        head.next = prev;
        n1.next = curt;
        return n1;
    }
}