public class Solution {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
 
		int left = 1; // point to leftious
		int right = 2; // point to rightent
 
		while (right < A.length) {
			if (A[right] == A[left] && A[right] == A[left - 1]) {
				right++;
			} else {
				left++;
				A[left] = A[right];
				right++;
			}
		}
 
		return left + 1;
	}
}