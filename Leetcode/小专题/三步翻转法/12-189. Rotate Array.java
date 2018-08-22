class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return;
        k = k % nums.length;
            
        rotateSub(nums, 0, nums.length - k - 1);
        rotateSub(nums, nums.length - k, nums.length - 1);
        rotateSub(nums, 0, nums.length - 1);
    }
    
    private void rotateSub(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}