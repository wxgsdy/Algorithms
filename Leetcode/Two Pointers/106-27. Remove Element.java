class Solution {
    
    public int removeElement(int[] nums, int val) {
        
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        
        return left++;        
    }
}