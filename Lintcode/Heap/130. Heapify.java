public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i = (A.length - 1)/2; i >= 0; i--){
            sink(A, i);
        }
    }
    
    private void sink(int[] A, int k){
        
        while(2*k + 1 < A.length){
            int j = 2 * k + 1;
            if(2 * k + 2 < A.length && A[j] > A[j + 1]) j++;
            if(A[j] >= A[k]) break;
            
            int temp = A[k];
            A[k] = A[j];
            A[j] = temp;
            k = j;
            
        }
    }
}