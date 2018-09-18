class Solution {
    public boolean isPowerOfFour(int num) {        
        return num > 0 && (num & (num - 1)) == 0 && checkDigits(num);
    }
    
    private boolean checkDigits(int num){        
        for(int i = 0; i < 32; i+=2){
            int cmp = 1<<i;
            if((num & cmp) != 0){
                return true;
            }
        }
        return false;
    }
}