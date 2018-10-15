class Solution {
    
    public int trap(int[] height) {
        
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        if(n <= 2) return 0;
        int curt = Integer.MIN_VALUE;
            
        int[] left_max = new int[n];        
        for(int i = 0; i < n; i++){
            left_max[i] = Math.max(height[i], curt);
            curt = left_max[i];
        }
        
        int[] right_max = new int[n];
        curt = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            right_max[i] = Math.max(height[i], curt);
            curt = right_max[i];
        }
        
        int res = 0;
        for(int i = 1; i < n - 1; i++){
            res += (Math.min(left_max[i], right_max[i]) - height[i]);
        }
        
        return res;
    }
}