class Solution {
    
    private int count;
    public int threeSumSmaller(int[] nums, int target) {
        
        count = 0;
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            twoSum(nums, i+1, nums.length-1, nums[i], target);
        }
        return count;
        
    }
    
    
    private void twoSum(int[] nums,
                        int start, 
                        int end,
                        int curt, 
                        int target){
        // sum smaller than target
        
        int i = start, j = end;
        while(i < j){
            
            if(nums[i] + nums[j] + curt < target){                
                count = count + (j - i);
                i++;
            } else {
                j--;
            }
        }
    }
}