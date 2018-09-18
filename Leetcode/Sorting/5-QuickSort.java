public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] nums, int start, int end){
        
        // exit 
        if(start >= end) return;
        
        // split
        int left = start, right = end;
        int pivot = nums[(start + end)/ 2];
        while(left <= right){
            
            while(left <= end && nums[left] < pivot){
                left++;
            }
            
            while(left <= right && nums[right] > pivot){
                right--;
            }
            
            // exchage left and right
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
            }

        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
        
    }
}