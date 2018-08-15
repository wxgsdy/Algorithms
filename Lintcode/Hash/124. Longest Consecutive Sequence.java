public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] nums) {
        // write your code here
        
        if(nums == null || nums.length == 0) return 0;
        int maxLength = Integer.MIN_VALUE;
        Set<Integer> number = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            number.add(nums[i]);
        }
        
        int left = 0, right = 0;
        for(int i = 0; i < nums.length; i++){
            left = nums[i] - 1; right = nums[i] + 1;
            int count = 1;
            while(number.contains(left)){
                count++;
                number.remove(left);
                left--; 
            }
            
            while(number.contains(right)){
                count++; 
                number.remove(right);
                right++;
            }
            
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }
}