/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "[]";
        
        // build list of tree nodes
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for(int i = 0; i < nodes.size(); i++){
            TreeNode temp = nodes.get(i);
            if(temp == null) continue;
            nodes.add(temp.left);
            nodes.add(temp.right);
        }
        
        // remove null points at tail
        while(nodes.get(nodes.size() - 1) == null){
            nodes.remove(nodes.size() - 1);
        }
        
        // ArrayList to sting 
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(nodes.get(0).val);
        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i) == null){
                sb.append(",null");
            } else {
                sb.append(",");
                sb.append(nodes.get(i).val);
            }
        }
        sb.append("]");
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int parentIndex = 0;
        boolean isLeft = true;
        for(int i = 1; i < vals.length; i++){
            if(!vals[i].equals("null")){
                TreeNode curt = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeft) nodes.get(parentIndex).left = curt;
                else nodes.get(parentIndex).right = curt;
                nodes.add(curt);
            }
            
            if(!isLeft) parentIndex++;
            isLeft = !isLeft;
        }
        
        return root;            
        
    }
    
    
}