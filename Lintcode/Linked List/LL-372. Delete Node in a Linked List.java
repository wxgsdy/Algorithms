public class Solution {
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}