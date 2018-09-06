/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    boolean meetTail = false;
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(!meetTail){
            head = reversenextk(head, k);
        }
        
        return dummy.next;        
    }
    
    private ListNode reversenextk(ListNode head, int k){
        // input : head -> n1 -> ... -> nk -> next
        // output: head -> nk -> ... -> n1 -> next
        // return n1 
        
        ListNode check = head;
        for(int i = 0; i < k; i++){
            if(check.next == null){
                meetTail = true;
                return null;
            }
                
            check = check.next;
        }
        
        ListNode prev = head, curt = head.next, n1 = head.next;
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