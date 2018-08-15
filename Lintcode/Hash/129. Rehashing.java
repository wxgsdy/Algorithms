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
        
        int currentSize = hashTable.length;
        
        ListNode[] newHashTable = new ListNode[2 * currentSize];
        for(int i = 0; i < newHashTable.length; i++){
            newHashTable[i] = null;
        }
        
        // copy content to new list
        for(int i = 0; i < hashTable.length; i++){
            ListNode node = hashTable[i];
            if(node != null){
                while(node != null){
                    int index = hashFunction(node.val, newHashTable.length);
                    if(newHashTable[index] == null) newHashTable[index] = new ListNode(node.val);
                    else{
                        ListNode tail = newHashTable[index];
                        while(tail.next != null){
                            tail = tail.next;
                        }
                        ListNode temp = new ListNode(node.val);
                        tail.next = temp;
                    }
                    node = node.next;
                }
            }
        }
        
        return newHashTable;
        
    }
    
    private int hashFunction(int val, int capacity){
        if(val >= 0) return val % capacity;
        else{// negative numbers
            return (val % capacity + capacity) % capacity;
        }
    }
};
