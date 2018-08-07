
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2) return 0;

        int cnt = 0;
        int start = 0, end = nums.length - 1;
        while(start < end){

        	if(nums[start] + nums[end] == target){
        		cnt++;
        		start++;
        		end--;
        		while(start < end && nums[start] == nums[start - 1]){
        			start++;
        		}

        		while(start < end && nums[end] == nums[end + 1]){
        			end--;
        		}
        	}
        	else if(nums[start] + nums[end] < target){
        		start ++;
        	}
        	else{
        		end--;
        	}
        }
        return cnt;
    }
}