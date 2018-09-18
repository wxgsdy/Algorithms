public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 1, 2
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        if(nums.length==1) {
            res.add(nums[0]);
            return res;
        }
        
        int element1 = nums[0], element2 = 0, count1 = 1, count2 = 0;        
        for(int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if(x == element1) count1++;
            else if(x == element2) count2++;
            else if(count1==0) {
                element1 = x;
                count1 = 1;
            } else if(count2==0) {
                element2 = x;
                count2 = 1;
            } else {
                count1--; count2--;
            }
        }
        
        
        count1 = 0; count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(element1 == nums[i]) count1++;
            else if(element2 == nums[i]) count2++;
        }
        if(count1>nums.length/3) res.add(element1);
        if(count2>nums.length/3) res.add(element2);
        return res;
    }
}
