/* 
* Description: In this question, you are required to give the entrance of the circle!
*/
public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode fast = head.next, slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        while(head != slow.next){
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}