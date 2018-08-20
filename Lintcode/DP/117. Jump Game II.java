public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        
        // state array
        int[] minPath = new int[nums.length];
        // init 
        
        for(int i = 0; i < nums.length; i++){
            minPath[i] = i; 
        }
        // function
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    minPath[i] = Math.min(minPath[i], minPath[j] + 1);
                }
            }
        }
        
        return minPath[nums.length - 1];
    }
}