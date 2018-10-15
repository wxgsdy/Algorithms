class Solution {
    
    
    public double findMaxAverage(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        
        int maxSum = sum;        
        for(int i = k; i < nums.length; i++){
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        
        System.out.print(maxSum);
        return (double)maxSum / k;
        
    }
}