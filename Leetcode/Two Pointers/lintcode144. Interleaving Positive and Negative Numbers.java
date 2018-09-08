public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
     
    private void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    
    public void rerange(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            
            while(start <= end && nums[start] < 0){
                start++;
            }
            
            while(start <= end && nums[end] > 0){
                end--;
            }
            
            if(start <= end){
                swap(nums, start,end);
                start++; end--;
            }
        }
        
        int numNegative = start;
        int numPositive = nums.length - start;
        int les = Math.min(numNegative, numPositive);
        // more negative numbers
        
        int left = 0, right = 0;
        if(numNegative > numPositive){
            
            // first move redundant negative numbers to tail 
            int l = numPositive, r = nums.length - 1;
            int diff = numNegative - numPositive;
            for(int i = 0; i < diff; i++){
                swap(nums, l, r);
                l++; r--;
            }
            left = 1; 
            right = 2 * les - 2;
        }
        
        if(numNegative == numPositive){
            left = 1;
            right = 2 * les - 2;
        }
        
        if(numNegative < numPositive){
            left = 0; 
            right = 2 * les - 1;
        }
      
        while(left < les){
            swap(nums, left, right);
            left += 2; right -=2;
        }
        
    }
}