public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {

        if(nums == null || nums.length < 2) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>(); // number -> index
        for(int i = 0; i < nums.length; i++){

            int case1 = nums[i] + target;
            if(map.containsKey(case1)){
                int[] pair = new int[2];
                pair[0] = map.get(case1) + 1;
                pair[1] = i + 1;
                return pair;
            }


            int case2 = nums[i] - target;
            if(map.containsKey(case2)){
                int[] pair = new int[2];
                pair[0] = map.get(case2) + 1;
                pair[1] = i + 1;
                return pair;
            }

            map.put(nums[i], i);
        }
        
        return new int[]{}

    }
}