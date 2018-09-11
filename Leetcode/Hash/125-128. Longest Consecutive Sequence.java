class Solution {
    
    public int longestConsecutive(int[] nums) {
    
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        
        // build set
        Set<Integer> set = new HashSet<>();
        for(int number : nums){
            set.add(number);
        }
        
        // running through nums and find the longest sequence 
        int left = 0, right = 0;
        int length = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            
            left = nums[i] - 1; right = nums[i] + 1;
            set.remove(nums[i]);
            
            // left boundary
            while(set.contains(left)){
                set.remove(left);
                left--;
                
            }
            // right boundary 
            while(set.contains(right)){
                set.remove(right);
                right++;
            }
            
            length = Math.max(length, right - left - 1);           
        }
        
        return length;
    }
}