/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    
    private Node head, tail;
    private boolean first = true;
    
    public Node treeToDoublyList(Node root) {        
        
        if(root == null) return null;  
        
        helper(root);
        head.left = tail;
        tail.right = head;        
        return head;
    }
    
    private void helper(Node root){
        
        if(root == null) return;
        Node left = root.left;
        Node right = root.right;
        
        helper(left);        
        // 插入是往尾巴上插
        // tail不是空指针
        // head.next是第一个元素
        if(first){
            head = root;
            tail = root;
            first = false;
        }
        
        tail.right = root;
        root.left = tail;
        tail = tail.right;            
            
        helper(right);        
        
    }
}