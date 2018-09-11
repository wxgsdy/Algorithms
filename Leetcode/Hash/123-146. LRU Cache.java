class LRUCache {
    
    private class Node{
        public Node prev, next;
        public int key, val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head, tail;
    private Map<Integer, Node> map;// key -> Node 
    private int capacity;
        
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    } 
    
    public int get(int key) {
        if(! map.containsKey(key)) return -1;
        else{// delete then move_to_tail
            Node curt = map.get(key);
            // delete
            curt.prev.next = curt.next;
            curt.next.prev = curt.prev;
            
            move_to_tail(curt);
        }        
        return map.get(key).val;
        
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){
            // move to tail already, we have to modify val to value;
            map.get(key).val = value;
            return;
        } else {
            // create new node and add to tail
            if(map.size() == this.capacity){
                // delete head;       
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;                
            }
            
            Node temp = new Node(key,value);
            map.put(key, temp);
            move_to_tail(temp);
            return;
        }
    }
    
    private void move_to_tail(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */