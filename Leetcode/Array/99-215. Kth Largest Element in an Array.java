class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return -1;
        return QuickSelect(nums, 0, nums.length - 1, k);
    }
    
    
    private int QuickSelect(int[] nums, int start, int end, int k){
        
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        
        while(i <= j){
            
            while(i <= j && nums[i] > pivot){
                i++;
            }
            
            while(i <= j && nums[j] < pivot){
                j--;
            }
            
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
        
        if(start + k - 1 <= j) return QuickSelect(nums, start, j, k);
        else if(start + k - 1 >= i) return QuickSelect(nums, i, end, k - (i - start));
        else return nums[j + 1];
    }
}