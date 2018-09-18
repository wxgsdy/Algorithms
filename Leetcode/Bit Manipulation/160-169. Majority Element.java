// Method 1: Sorting, O(nlongn) time
class Solution {
    
    public int majorityElement(int[] nums) {
        // if(nums == null || nums.length == 0) return null;
        
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


// Method 2: Moore voting algorithm

 class Solution {
    
    public int majorityElement(int[] nums) {
        
        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            
            if(count == 0){
                major = nums[i];
                count = 1;
            } else if(nums[i] == major){
                count++;
            } else count--;           
        }
        return major;
    }
}