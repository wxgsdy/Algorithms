class Solution {
    
    private int diff;
    private int closest;  
    public int threeSumClosest(int[] nums, int target) {
        
        diff = Integer.MAX_VALUE;       
        if(nums == null || nums.length < 3) return 0;
        
        Arrays.sort(nums);        
        for(int i = 0; i < nums.length - 2; i++){
            
            if(diff == 0) return target;            
            twoSum(nums, i+1, nums.length - 1, nums[i], target);
        }
        return closest;   
        
    }
    
    private void twoSum(int[] nums,
                        int start, 
                        int end,
                        int curt,
                        int target){
        
        int i = start, j = end;
        
        while(i < j){
            
            if(nums[i] + nums[j] + curt == target){
                // return target
                diff = 0;
                closest = target; 
                i++; j--;
                
            } 
            else if(nums[i] + nums[j] + curt < target){
                if(target - nums[i] - nums[j] - curt < diff){
                    diff = target - nums[i] - nums[j] - curt;
                    closest = nums[i] + nums[j] + curt;
                }                
                i++;
            } else {                               
                
                if(nums[i] + nums[j] + curt - target < diff){
                    diff = nums[i] + nums[j] + curt - target;
                    closest = nums[i] + nums[j] + curt;
                }
                
                j--;
            } 
            
            
        }
        
    }
}