class Solution {
    
    
    private List<List<Integer>> results;    
    public List<List<Integer>> fourSum(int[] nums, int target) {        
        results = new ArrayList<>();
        if(nums == null || nums.length < 4) return results;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++){            
            if(i != 0 && nums[i] == nums[i-1]) continue;            
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j] == nums[j-1]) continue;
                twoSum(nums, j+1, nums.length - 1, nums[i], nums[j], target);
            }
        }
        return results;
        
    }
    
    
    private void twoSum(int[] nums, int start, int end, int curt1, int curt2, int target){        
              
        int i = start, j = end;        
        while(i < j){   
            
            if(nums[i] + nums[j] + curt1 + curt2 == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(curt1);
                temp.add(curt2);
                temp.add(nums[i]);
                temp.add(nums[j]);
                results.add(temp);
                
                i++; j--;
                while(i<j && nums[i] == nums[i-1]) i++;
                while(i<j && nums[j] == nums[j+1]) j--;
            }
            else if(nums[i] + nums[j] + curt1 + curt2 < target) i++;
            else j--;         
        }
    }
}