/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        int carry = 0;  
        
        while(h1 != null && h2 != null){
            int temp = h1.val + h2.val + carry;
            
            if(temp >= 10){
                carry = 1;
                tail.next = new ListNode(temp % 10);
                
            } else {
                carry = 0;
                tail.next = new ListNode(temp);                
            }            
            tail = tail.next;
            h1 = h1.next;
            h2 = h2.next;
        }          
              
        if(h1 != null){            
            while(h1 != null){
                int temp = h1.val + carry;
                if(temp >= 10){
                    tail.next = new ListNode(temp % 10);
                    carry = 1;
                } else {
                    tail.next = new ListNode(temp);
                    carry = 0;
                }
                h1 = h1.next;
                tail = tail.next;
            }            
        }           
        
        if(h2 != null){
            // h2 != null
            while(h2 != null){
                int temp = h2.val + carry;
                if(temp >= 10){
                    tail.next = new ListNode(temp % 10);
                    carry = 1;
                } else {
                    tail.next = new ListNode(temp);
                    carry = 0;
                }
                h2 = h2.next;
                tail = tail.next;
            } 
        }
        
        
        if(h1 == null && h2 == null && carry == 1){
            tail.next = new ListNode(1);
            carry = 0;
        }         
        
        
        return dummy.next;
        
    }
    
}