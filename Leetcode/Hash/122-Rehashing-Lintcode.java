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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        
        int curtSize = hashTable.length;
        ListNode[] result = new ListNode[curtSize * 2];
        Arrays.fill(result, null);
        
        for(ListNode node : hashTable){
            ListNode curt = node;
            while(curt != null){
                int pos = hashFunction(curt.val, result.length);
                if(result[pos] == null) result[pos] = new ListNode(curt.val);
                else {
                    ListNode temp = new ListNode(curt.val);
                    ListNode tail = result[pos];
                    while(tail.next != null){
                        tail = tail.next;
                    }
                    tail.next = temp;
                }
                curt = curt.next;
             }   
        }
        
        return result;
    }
    
    private int hashFunction(int val, int capacity){
        if(val >= 0) return val % capacity;
        else return (val % capacity + capacity) % capacity;
    }
};
