// Solution 1: 先按照w进行排序然后再对h求最长连续子序列； 但是时间复杂度有问题；

public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    
    private Comparator<int[]> pairComparator = new Comparator<int[]>(){
        
        public int compare(int[] left, int[] right){
            if(left[0] == right[0]){
                return left[1] - right[1];
            } else {
                return left[0] - right[0];
            }
            
        }  
        
        
    };
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, pairComparator);
        
        // state array
        int[] f = new int[envelopes.length];
        for(int i = 0; i < f.length; i++){
            f[i] = 1;
        }
        
        // 
        for(int i = 1; i < envelopes.length; i++){
            for(int j = 0;j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        
        //return max value of f
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < f.length; i++){
            if(f[i] > result){
                result = f[i];
            }
        }
        
        return result;
        
        
    }
}



// Solution 2: 结合二分的思想， 优化LIS算法
public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    private Comparator<int[]> pairComparator = new Comparator<int[]>(){
        
        public int compare(int[] left, int[] right){
            if(left[0] == right[0]) return right[1] - left[1];
            else return left[0] - right[0];
        }  
        
    };
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if(envelopes == null || envelopes.length == 0 || envelopes[1].length == 0) return 0;
        Arrays.sort(envelopes, pairComparator);
        
        int count = 0;
        for(int i = 0; i < envelopes.length; i++){
            // binary search
            int left = 0, right = count - 1;
            
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(envelopes[mid][1] < envelopes[i][1]) left = mid + 1;
                else right = mid - 1;
            }
            
            envelopes[left] = envelopes[i];
            if(count == left) count++;
        }        
        return count;       
    }
}