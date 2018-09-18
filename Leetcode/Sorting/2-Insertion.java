public class Insertion{


	public static void sort(int[] nums){
		// insert a[i] to a[i-1], a[i-2], a[i-3]....
		for(int i = 1; i < nums.length; i++){
			for(int j = i; j >= 0; j--){
				if(nums[j] < nums[j-1]){
					exch(nums, j, j-1);
				}
			}			
		}
	}
}