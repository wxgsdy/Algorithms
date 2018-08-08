/* Description:
	find tow integers so that their sum is closest to the given target; Reture the difference;
*/

public class solution{

	public int twoSumClosest(int[] nums, int target){

		if(nums == null || nums.length < 2) return -1;
		int diff = Integer.MAX_VALUE;
		int left = 0, right = nums.length - 1;
		while(left < right){

			if(nums[left] + nums[right] > target){
				diff = Math.min(nums[left] + nums[right] - target, diff);
				right--;
			}
			else if(nums[left] + nums[right] < target){
				diff = Math.min(target - nums[left] - nums[right], diff);
				left++;
			}else{
				return 0;
			}

		}
		return diff;
	}
}