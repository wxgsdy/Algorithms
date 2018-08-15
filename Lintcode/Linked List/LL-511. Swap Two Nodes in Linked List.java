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
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode preNode1= null, preNode2 = null;
        while(head.next != null){
            if(head.next.val == v1) preNode1 = head;
            else if(head.next.val == v2) preNode2 = head;
            head = head.next;
        }
        
        // v1 or v2 does not exist
        if(preNode1 == null || preNode2 == null) return dummy.next;
        
        // v1 and v2 are adjacent
        if(preNode1.next == preNode2){
            ListNode node2 = preNode2.next;
            ListNode temp = node2.next;
            preNode1.next = node2;
            node2.next = preNode2;
            preNode2.next = temp;
        }
        
        else if(preNode2.next == preNode1){
            ListNode node1 = preNode1.next, temp = preNode1.next.next;
            preNode2.next = node1;
            node1.next = preNode1;
            preNode1.next = temp;
        }
        
        // gapped
        else{
            ListNode node1 = preNode1.next, node2 = preNode2.next;
            ListNode node1Next = node1.next, node2Next = node2.next;
            preNode1.next = node2;
            node2.next = node1Next;
            
            preNode2.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
        
        
        
        
    }
}