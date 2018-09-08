public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        
        int start = 0, end = nums.length - 1;
        while(start <= end){
            while(start <= end && isOdd(nums[start])){
                start++;
            }
            
            while(start <= end && isEven(nums[end])){
                end--;
            }
            
            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++; end--;
            }
        }
    }
    
    private boolean isOdd(int num){
        return num % 2 != 0;
    }
    
    private boolean isEven(int num){
        return num % 2 == 0;
    }
}