class Solution {
    public int findDuplicate(int[] nums) {
        // length nums : length
        // 数字的范围： 1 - nums.length - 1
        int start = Integer.MAX_VALUE;
        for(int num : nums){
            start = Math.min(num, start);
        }       
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(number_of_element_less_than(nums, mid) > mid) end = mid;
            else  = mid;            
        }
        
        if(number_of_element_less_than(nums, start) > start) return start;
        else return end;
    }
    
    private int number_of_element_less_than(int[] nums, int x){
        int count = 0;
        for(int num : nums){
            if(num <= x){
                count++;
            }
        }
        return count;
    }
}