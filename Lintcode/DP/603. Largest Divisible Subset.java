public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        // build and update status matrix
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            f[i] = 1; pre[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && f[j] + 1 > f[i]){
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }
        
        // build result -- find max first
        int maxLength = Integer.MIN_VALUE, index = 0;
        for(int i = 0; i < nums.length; i++){
            if(f[i] > maxLength){
                maxLength = f[i];
                index = i;
            }
        }
        
        res.add(nums[index]);
        while(pre[index] != index){
            index = pre[index];
            res.add(nums[index]);
        }
        
        Collections.reverse(res);
        return res;
            
            
        
        
        
        
    }
}