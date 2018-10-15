class Solution {
    
    public int splitArray(int[] nums, int k) {
        
        int max = Integer.MIN_VALUE, sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        int start = max, end = sum;
        while(start + 1 < end){
            
            int mid = start + (end - start) / 2;
            if(number_of_interval_needed(nums, mid) <= k) end = mid;
            else start = mid;
        }
        
        if(number_of_interval_needed(nums, start) <= k) return start;
        else return end;
    }
    
    private int number_of_interval_needed(int[] nums, int sumLimit){
        int sum = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > sumLimit){
                sum = 0;
                count++;
            }
            sum += nums[i];
        }
        return count+1;
    }
    
}