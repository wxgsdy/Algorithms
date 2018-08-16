// Method 1: using PriorityQueue
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
            public int compare(ListNode left, ListNode right) {
                return left.val - right.val;
            }
    };
        
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) return null;
        
        // build a dynamic PriorityQueue
        
        Queue<ListNode> pq = new PriorityQueue<>(lists.size(), ListNodeComparator);
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null){
                pq.add(lists.get(i));
            }
        }
        
        // build result lists
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode curt = pq.poll();
            tail.next = curt;
            tail = tail.next;
            if(curt.next != null){
                pq.add(curt.next);
            }
        }
        
        return dummy.next;
        
    }
}
