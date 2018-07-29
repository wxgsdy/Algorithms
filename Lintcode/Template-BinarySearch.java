class solution{

	public int binarySearch(int[] nums, int target){

		if(num == null || num.length == 0) return -1;
		int start = 0, end = nums.length - 1;

		while(start + 1 < end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target)        end = mid;
			else if(numd[mid] < target)    start = mid;
			else 						   end = mid;
		}
		if(nums[start] == target) return start;
		if(nums[end] == target)   return end;
		return -1;
	}




}