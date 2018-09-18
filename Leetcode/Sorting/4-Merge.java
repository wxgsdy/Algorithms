public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        int[] temp = new int[A.length];
        mergeSort(A, temp, 0, A.length - 1);
    }
    
    private void mergeSort(int[] nums, int[] temp, int start, int end){
        
        // exit
        if(start >= end) return;
        
        
        //split
        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid+1, end);
        
        // merge two part and copy results to temp
        int index = start;
        int left = start;
        int right = mid + 1;
        
        while(left <= mid && right <= end){
            if(nums[left] < nums[right]) temp[index++] = nums[left++];
            else temp[index++] = nums[right++];
        }
        
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        
        while(right <= end){
            temp[index++] = nums[right++];
        }
        
        // copy temp back to nums
        for(int i = start; i <= end; i++){
            nums[i] = temp[i];
        }
    }
}