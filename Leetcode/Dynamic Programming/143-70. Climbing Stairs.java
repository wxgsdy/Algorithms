class Solution {
    
    public int climbStairs(int n) {
        
        int[] state = new int[n+1]; // n stairs from 1 to n
        state[0] = 1; state[1] = 1;
        for(int i = 2; i < state.length; i++){
            state[i] = state[i-1] + state[i-2];
        }
        return state[n];
        
    }
}