class Solution {
    
    private List<List<Integer>> results;
    public List<List<Integer>> threeSum(int[] nums) {
        
        results = new ArrayList<>();
        if(nums.length < 3) return results;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(nums, i+1, nums.length - 1, -nums[i]);
        }       
        
        return results;
    }
    
    
    private void twoSum(int[] nums, int start, int end, int target){        
              
        int i = start, j = end;
        
        while(i < j){            
            if(nums[i] + nums[j] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[i]);
                temp.add(nums[j]);
                results.add(temp);
                
                i++; j--;
                while(i<j && nums[i] == nums[i-1]) i++;
                while(i<j && nums[j] == nums[j+1]) j--;
            }
            else if(nums[i] + nums[j] < target) i++;
            else j--;         
        }
    }
}