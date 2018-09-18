class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;        
        int[] state = new int[n];
        Arrays.fill(state, 1);
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    state[i] = Math.max(state[j] + 1, state[i]);
                }
                
            }
        }
        
        int result = state[0];
        for(int i = 1; i < state.length; i++){
            result = Math.max(state[i], result);
        }
        return result;
    }
}