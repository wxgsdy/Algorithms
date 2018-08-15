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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode prem = dummy, pren = dummy;
        
        for(int i = 0; i < m-1; i++){
            prem = prem.next;
        }
        
        for(int i = 0; i < n; i++){
            pren = pren.next;
        }
        
        ListNode mNode = prem.next;
        ListNode prev = prem, curt = prem.next;
        for(int i = 0; i < n - m + 1; i++){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        mNode.next = curt;
        prem.next = prev;
        return dummy.next;
        
        
        
    }
}