class Solution {
    
    public int divide(int dividend, int divisor) {
        
        // corner cases
        if(dividend == 0) return 0;
        if(divisor == 0) return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // flag
        int flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        // divide operation
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b<<shift)){
                shift++;
            }
            a -= (b<<(shift - 1));
            res += (1<<(shift - 1));
        }
       // System.out.print(Math.abs(Integer.MIN_VALUE));
        return res * flag;
        
        
    }
}