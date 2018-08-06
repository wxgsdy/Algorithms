public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int length = nums.length;
        if (length % 2 == 0)
            return quickSelect(nums, 0, nums.length - 1, nums.length /2 + 1);
        return quickSelect(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        
        int i = start, j = end;
        int pivot = nums[(i + j)/2];
        while(i <= j){
            // kth largest -> descending here
            while(i <= j && pivot < nums[i]){
                i++;
            }
            
            while(i <= j && pivot > nums[j]){
                j--;
            }
            
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }
        }
        
        if(start + k - 1 <= j) return quickSelect(nums, start, j, k);
        else if(start + k - 1 >= i) return quickSelect(nums, i, end, k - (i - start));
        else return nums[j + 1];
    }
}