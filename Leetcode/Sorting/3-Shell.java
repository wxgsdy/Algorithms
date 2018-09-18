public class Shell{


	public static void sort(int[] nums){
		int h = 1;
		while(h < nums.length / 3) h = h * 3;
		while(h >= 1){
			for(int i = h; i < nums.length; i++){
				for(int j = h; j >= h; j = j - h){
					if(nums[j] < nums[j - h]){
						exch(nums, j, j - h);
					}
				}	
			}

			h = h / 3;
		}
	}
}