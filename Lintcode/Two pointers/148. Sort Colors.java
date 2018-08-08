public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length <2) return;
        
        int left = 0, i = 0, right = nums.length - 1;
        while(i <= right){
            
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