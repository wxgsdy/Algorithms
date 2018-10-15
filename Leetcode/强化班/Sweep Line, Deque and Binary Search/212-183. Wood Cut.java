public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) return 0;
        
        int start = 1, end = L[0];
        for(int item : L){
            end = Math.max(end, item);
        }
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(number_of_wood(L, mid) < k) end = mid;
            else start = mid;
        }
        
        if(number_of_wood(L, start) >= k) return start;
        if(number_of_wood(L, end) >= k) return end;
        return 0;
    }
    
    private int number_of_wood(int[] L, int len){
        int count = 0;
        for(int item : L){
            count += (item / len);
        }
        return count;
    }
}