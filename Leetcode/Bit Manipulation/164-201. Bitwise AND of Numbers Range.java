class Solution {
    
    public int rangeBitwiseAnd(int m, int n) {
        
        int count = 0; // count steps to move right
        while(m != n){
            m = (m >> 1);
            n = (n >> 1); 
            count++;
        }
        return (m << count);        
    }
}