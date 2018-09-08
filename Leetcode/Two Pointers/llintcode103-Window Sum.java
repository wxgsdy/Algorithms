public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {

    	if(nms == null || nums.length < k || k <= 0){
    		return new int[];
    	}

    	int[] sums = new int[nums.length - k + 1];
		int sum = 0;
		for(int i = 0; i < k; i++){
			sum += nums[i];
		}    	
		sum[0] = sum;

    	for(int i = 1; i < sums.length; i++){
    		sums[i] = sums[i - 1] + nums[i + k - 1] - nums[i - 1];
    	}
    	return sums;
    }


}