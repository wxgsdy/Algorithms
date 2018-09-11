// Method 1: Using minHeap to find minNode in the pool in each step to build the result list 

class Solution {
    
    private Comparator<ListNode> nodeComparator = new Comparator<ListNode>(){        
        public int compare(ListNode left, ListNode right){
            return left.val - right.val;
        }
    };   
    
    public ListNode mergeKLists(ListNode[] lists) {        
        if(lists == null || lists.length == 0) return null;        
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, nodeComparator);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // don't add null node into pq        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.add(node.next);
            }
            
            tail.next = node;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}



// Method 2: 