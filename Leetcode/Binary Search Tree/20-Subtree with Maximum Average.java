public class Solution {
    
    
    private class resultType{
        public int size;
        public int sum;
        public resultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }
  
    
    private TreeNode minNode = null;
    private resultType record = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        
        helper(root);
        return minNode;
    }
    

    private resultType helper (TreeNode node){

        // exit
        if(node == null) return new resultType(0, 0);


        // split
        resultType left = helper(node.left);
        resultType right = helper(node.right);

        // merge
        resultType result = new resultType(left.sum + right.sum + , left.size + right.size + 1);
        if(record == null || record.sum * result.size < result.sum * record.size){
            minNode = node;
            record = result;
        }

        return result;
    }
    
}