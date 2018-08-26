1. 快慢指针找链表的中部

private ListNode findmid(ListNode head){
        if(head == null) return null;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }