public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i + 1, nums.length - 1, -nums[i], result);
        }
        return result;
    }
    
     private void twoSum(int[] nums,
                         int start,
                         int end,
                         int target,
                         List<List<Integer>> result){
                             
        while(start < end){
            if(nums[start] + nums[end] == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);
                
                start++; end--;
                while(start < end && nums[start] == nums[start - 1]){
                    start ++;
                }
                
                while(start < end && nums[end] == nums[end + 1]){
                    end--;
                }
            }
            else if(nums[start] + nums[end] > target) end--;
            else start ++;
        }                         
    }
}