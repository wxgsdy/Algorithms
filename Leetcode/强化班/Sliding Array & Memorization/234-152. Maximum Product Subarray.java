class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0]; g[0] = nums[0];
        int res = f[0];
        
        for(int i = 1; i < n; i++){
            
            int temp1 = f[i - 1] * nums[i];
            int temp2 = g[i - 1] * nums[i];
            
            g[i] = Math.min(nums[i], Math.min(temp1, temp2));
            f[i] = Math.max(nums[i], Math.max(temp1, temp2));
            res = Math.max(res, f[i]);
            
        }
        
        return res;
    }
}


class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] f = new int[2];
        int[] g = new int[2];
        f[0] = nums[0]; g[0] = nums[0];
        int res = f[0];
        
        for(int i = 1; i < n; i++){
            
            int temp1 = f[(i - 1) % 2] * nums[i];
            int temp2 = g[(i - 1) % 2] * nums[i];
            
            g[i % 2] = Math.min(nums[i], Math.min(temp1, temp2));
            f[i % 2] = Math.max(nums[i], Math.max(temp1, temp2));
            res = Math.max(res, f[i % 2]);
            
        }
        
        return res;
    }
}

