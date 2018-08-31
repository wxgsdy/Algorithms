class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);        
        
        int result = 1;        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }                
            }
            result = Math.max(result, f[i]);
            
        }
        return result;        
    }
}