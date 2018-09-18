class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        boolean state[] = new boolean[n];
        // initialization
        Arrays.fill(state, false);
        state[0] = true;
        
        for(int i = 1; i < state.length; i++){
            for(int j = 0; j < i; j++){
                if(state[j] == true && j + nums[j] >= i){
                    state[i] = true;
                }
            }
        }        
        return state[nums.length - 1];
    }
}