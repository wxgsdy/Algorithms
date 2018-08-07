public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length + B.length;
        if(n % 2 == 0) return (findkth(A, 0, B, 0, n/2) + findkth(A, 0, B, 0, n/2 + 1))/2.0;
        return findkth(A, 0, B, 0, n/2 + 1);
    }
    
    private int findkth(int[] A, int startA, int[] B, int startB, int k){
        
        if(startA >= A.length) return B[startB + k - 1];
        if(startB >= B.length) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);
        
        int midA = (startA + k/2 - 1 < A.length)? A[startA + k/2 - 1]:Integer.MAX_VALUE;
        int midB = (startB + k/2 - 1 < B.length)? B[startB + k/2 - 1]:Integer.MAX_VALUE;
        
        if(midA < midB) return findkth(A, startA + k/2, B, startB, k - k /2);
        else return findkth(A, startA, B, startB + k/2, k - k/2);
    }
}