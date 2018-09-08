class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length + nums2.length;
        if(n % 2 == 0)
            return (findkth(nums1, 0, nums2, 0, n/2) + findkth(nums1, 0, nums2, 0, n/2 + 1)) / 2.0;
        else
            return findkth(nums1, 0, nums2, 0, n/2 + 1);
        
    }
    
    
    private int findkth(int[] A, int startA, int[] B, int startB, int k){
        
        if(startA >= A.length) return B[startB + k - 1];
        if(startB >= B.length) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);
        
        int midA = startA + k/2 - 1 < A.length ? A[startA + k/2 - 1] : Integer.MAX_VALUE;        
        int midB = startB + k/2 - 1 < B.length ? B[startB + k/2 - 1] : Integer.MAX_VALUE;
        
        if(midA < midB) return findkth(A, startA + k/2, B, startB, k - k/2);
        else return findkth(A, startA, B, startB + k/2, k - k/2);
    }
    
}