class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        int j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){            
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            
            if(sum >= s) minLength = Math.min(minLength, j - i);
            //j--;
            sum -= nums[i];            
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}