/*Description:
* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
* You should preserve the original relative order of the nodes in each of the two partitions.
*/

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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null) return head;
        
        ListNode leftDummy = new ListNode(0); // <
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0); // >=
        ListNode rightTail = rightDummy;
    
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        
        // Patch
        leftTail.next = rightDummy.next;
        rightTail.next = null;
        return leftDummy.next;
        
        
    }
}