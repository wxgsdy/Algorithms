/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        RandomListNode newNode;
        
        while(head != null){
            
            if(map.containsKey(head)) newNode = map.get(head);
            else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            tail.next = newNode;
            
            
            if(head.random != null){
                if(map.containsKey(head.random)) newNode.random = map.get(head.random);
                else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }           
            
            tail = tail.next;
            head = head.next;           
        }
        
        return dummy.next;
        
    }
}