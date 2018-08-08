class solution{

	public int threeSumCloset(int[] nums, int target){
		if(nums == null || nums.length < 3) return -1;
		Arrays.sort(nums);
		diff = Integer
		for(int i = 0; i < nums.length - 2; i++){
			int start = i + 1, end = nums.length - 1;
			while (start < end){
				int val = nums[start] + nums[end] + nums[i];
				if(val > targrt){
					diff = Math.min(diff, val - target);
					end--;
				}
				else if (val < target){
					diff = Math.min(diff, target - val);
					start++;
				}
				else{
					return 0;
				}
				
			}
		}
		return diff;
	}
}