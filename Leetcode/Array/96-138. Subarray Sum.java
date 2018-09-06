public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefixSum -> index
        
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                res.add(map.get(sum) + 1);
                res.add(i);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}