class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int sumAll = 0, sumOdd = 0;
        for(int i = 0; i < nums.length; i++){
            sumAll += nums[i];
            if(i % 2 == 0) {
                sumOdd += nums[i];
            }
        }
        //return Math.max(sumOdd, sumAll - sumOdd);
        return sumOdd;
    }
}