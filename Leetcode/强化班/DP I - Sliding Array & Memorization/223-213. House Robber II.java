class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        // System.out.print(robHelper(nums, 0, nums.length - 1));
        
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    private int robHelper(int[] nums, int start, int end){
        
        int length = end - start + 1;
        if(start == end) return nums[start];
        if(length == 2) return Math.max(nums[start], nums[end]);
        
        int f[] = new int[3];
        f[0] = nums[start];
        f[1] = Math.max(nums[start + 1], nums[start]);
        
        for(int i = start + 2; i <= end; i++){
            f[(i - start) % 3] = Math.max(f[(i - start - 1) % 3], f[(i - start - 2) % 3] + nums[i]);
        }
        
        return f[(length - 1) % 3];
    }
}