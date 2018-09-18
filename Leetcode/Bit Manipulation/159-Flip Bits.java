public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        // write your code here
        return countOne(a ^ b);
    }
    
    private int countOne(int num){
        int count = 0;
        while(num != 0){
            num = (num & (num - 1));
            count++;
        }
        return count;
    }
}