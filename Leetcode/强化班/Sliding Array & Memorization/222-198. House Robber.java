class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] f = new int[n];
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // initialize 
        f[0] = nums[0]; 
        f[1] = Math.max(f[0], nums[1]);
        for(int i = 2; i < n; i++){
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        
        // System.out.print(f);
        return f[n - 1];
        
    }
}

// Sliding array
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] f = new int[3];
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // initialize 
        f[0] = nums[0]; 
        f[1] = Math.max(f[0], nums[1]);
        for(int i = 2; i < n; i++){
            f[i % 3] = Math.max(f[(i - 2) % 3] + nums[i], f[(i - 1) % 3]);
        }
        
        // System.out.print(f);
        return f[(n - 1) % 3];
        
    }
}