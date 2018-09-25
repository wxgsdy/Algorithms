class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n =citations.length;
        int i = n-1;        
        for(;i >=0; i--) {
            if(citations[i] < n-i){
                break;
            }
        }
        
        return citations[0] >= n ? n : n-i-1;
    }
}