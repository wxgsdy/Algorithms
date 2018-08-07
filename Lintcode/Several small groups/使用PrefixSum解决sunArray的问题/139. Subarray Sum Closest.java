public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        // corner cases
        if(nums == null || nums.length == 0) return result;
        if(nums.length == 1) return new int[]{0,0};
        
        // use prefixSum to search for subarray sum
        // use map to store original index --> need to sort later
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        
        Map<Integer, Integer> map = new HashMap<>(); // sum -> index
        map.put(0, -1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                // if there exist subarray sums 0
                result[0] = map.get(sum) + 1;
                result[1] = i;
                return result;
            }
            map.put(sum, i);
            prefixSum[i+1] = sum;
        }
        
        // no duplicates in prefixSump
        Arrays.sort(prefixSum);
        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = 0;  // the value is prefixSump value, look for map for orignal index 
        for(int i = 0; i < prefixSum.length - 1; i++){
            int curtDiff = Math.abs(prefixSum[i] - prefixSum[i+1]);
            if(curtDiff < minDiff){
                left = prefixSum[i];
                right = prefixSum[i+1];
                minDiff = curtDiff; 
            }
        }
        
        if(map.get(left) < map.get(right)){
            result[0] = map.get(left) + 1;
            result[1] = map.get(right);
        }
        
        else{
            result[0] = map.get(right) + 1;
            result[1] = map.get(left);
        }
        return result;
    }
}