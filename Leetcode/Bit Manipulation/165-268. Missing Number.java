// Method 1: USing array sum
class Solution {
    public int missingNumber(int[] nums) {
        
        int length = nums.length;
        // [3, 0 , 1]  -> (0 + 1 + 2 + 3) - sum
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += nums[i];
        }
        
        return length * (length + 1) / 2 - sum;
    }
}

// Method 2 : Bit manipulation
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ (i + 1) ^ nums[i];
        }
        return res;
        
    }
}