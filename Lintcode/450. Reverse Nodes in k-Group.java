public class Solution {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(head != null){
        	head = reverseNextk(head, k);
        }

        return dummy.next;
    }


    // reverse head -> n1 -> n2 -> ... -> nk -> next
    // res: head -> nk -> ... -> n1 -> next
    // return n1
    private reverseNextk(ListNode head, int k){
    	ListNode next = head;
    	// chech there are enough k nodes for reverse
    	for(int i = 0; i < k; i++){
    		if(next.next == null) return next;
    	}
    	next = next.next;
    }

    // reverse
    

}