class Solution {
    
    public void sortColors(int[] nums) {
        
        int left = 0, i = 0, right = nums.length - 1;
        while(i <= right){
            // 00000 11111 2222 
            if(nums[i] == 0){
                swap(nums, i, left);
                left++; i++;
                
            }
            
            else if(nums[i] == 1) i++;
            else{
                // nums[i] == 2
                swap(nums, i, right);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}