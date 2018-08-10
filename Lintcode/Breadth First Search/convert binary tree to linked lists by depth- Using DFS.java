/*  Description:
        Given a binary tree, design an algorithm which creates a linked 
        list of all the nodes at each depth (e.g., if you have a tree 
        with depth D, you'll have D linked lists).
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        if(root == null) return result;

        ListNode dummy = new ListNode(0);
        ListNode tail = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            dummy.next = null;
            tail = dummy;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                tail.next = new ListNode(node.val);
                tail = tail.next;

                if(node.left != null) queue.offer(node.left);
                if(node.riht != null) queue.offer(node.right);
            }
            result.add(dummy.next);             
        }
        return result;
    }
}