public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if(S == null || S.length == 0) return 0;
        int cnt = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            int left = 0, right = i - 1;
            while(left < right){
                if(S[left] + S[right] > S[i]){
                    cnt = cnt + (right - left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return cnt;
    }
}