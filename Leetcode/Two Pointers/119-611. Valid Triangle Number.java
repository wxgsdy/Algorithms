class Solution {
    
    private int count;
        
    public int triangleNumber(int[] nums) {
        
        if(nums == null || nums.length < 3) return 0;
        
        Arrays.sort(nums);
        for(int i = 2; i < nums.length; i++){
            twoSum(nums, 0, i - 1, nums[i]);
        }
        return count;
    }
    
    private void twoSum(int[] nums,
                        int start,
                        int end,
                        int curt){
        // find nums[start] + nums[end] > curt
        int i = start, j = end;
        while(i < j){
            
            if(nums[i] + nums[j] > curt){
                count = count + (j - i);
                j--;
            } else {
                i++;
            }
        }
    }
}