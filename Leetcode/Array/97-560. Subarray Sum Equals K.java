class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // prefixSum -> number of times we see this sum
            
            
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){  
            
            
            sum += nums[i];            
            // update result
            if(map.containsKey(sum - k)) count += map.get(sum - k);
            if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        
        return count;
    }
}