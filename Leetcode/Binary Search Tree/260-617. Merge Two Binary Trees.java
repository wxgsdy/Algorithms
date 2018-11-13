// Methos 1: merge to t1


class Solution {
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1 == null && t2 == null) return null;
        else if(t1 != null && t2 != null) t1.val += t2.val;
        else if(t1 == null && t2 != null) t1 = new TreeNode(t2.val);
        else return t1;
        
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
    }
}


class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeHelper(t1, t2);
    }
    
    private TreeNode mergeHelper(TreeNode t1, TreeNode t2){
        
        TreeNode res = null;
        if(t1 == null && t2 == null) return res;
        else if(t1 != null && t2 != null) {
            res = new TreeNode(t1.val + t2.val);
            res.left = mergeHelper(t1.left, t2.left);
            res.right = mergeHelper(t1.right, t2.right);
            return res;
        }
        else if(t1 != null && t2 == null){
            res = t1;
            return res;
        } 
        else {
            res = t2;
            return res;
        }
    }
}