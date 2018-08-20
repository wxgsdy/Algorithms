public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] nums) {
        // write your code here
        boolean[] capability = new boolean[nums.length];
        capability[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(capability[j] && nums[j] + j >= i){
                    capability[i] = true;
                    break;
                }
            }
        }
        
        return capability[nums.length - 1];
    }
}