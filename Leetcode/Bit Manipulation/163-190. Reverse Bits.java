public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int pointer = 1;
        int res = 0;
        for(int i = 0; i < 32; i++){
            if((n & pointer) != 0){
                // digit is 1
                res = (res << 1) + 1;
            } else {
                res = (res << 1);
            }
            
            pointer = (pointer << 1);
        }
        
        return res;
    }
}