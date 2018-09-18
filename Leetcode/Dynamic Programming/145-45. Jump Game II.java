class Solution {
    
    public int jump(int[] nums) {
        
        if(nums == null || nums.length < 1) return 0;
        
        int n = nums.length;
        int[] state = new int[n];
        Arrays.fill(state, Integer.MAX_VALUE);
        state[0] = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if( state[j] != Integer.MAX_VALUE && j + nums[j] >= i){
                    state[i] = Math.min(state[j] + 1, state[i]);
                }
            }
        }
        
        return state[n - 1];
    }
}