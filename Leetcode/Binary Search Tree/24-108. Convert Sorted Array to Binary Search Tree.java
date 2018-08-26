/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return convertHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode convertHelper(int[] nums, int start, int end){
        
        // exit
        if(start == end) return new TreeNode(nums[start]);
        if(start > end) return null;
        
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertHelper(nums, start, mid - 1);
        root.right = convertHelper(nums, mid + 1, end);
        return root;
    }
}