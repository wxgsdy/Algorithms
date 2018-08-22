public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        
        for(int i = 0; i < nums.size() - 1; i++){
            if(nums.get(i) > nums.get(i + 1) ){
                rotate(nums, 0, i);
                rotate(nums, i + 1, nums.size() - 1);
                rotate(nums, 0, nums.size() - 1);
                break;
            }
        }
       
        
    }
    
    private void rotate(List<Integer> nums, int start, int end){
        for(int i = start, j = end; i < j; i++,j--){
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
        
    }
}