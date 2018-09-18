class Solution {
    
    public int[] plusOne(int[] digits) {
        
        int carry  = 1;
        int curtDigit = digits.length - 1;
        
        while(curtDigit >= 0 && carry == 1){
            int temp = digits[curtDigit] + 1;
            if(temp == 10){
                digits[curtDigit] = 0;
                curtDigit--;
            } else {
                digits[curtDigit] += 1;   
                carry = 0;
            }
        }
        
        if(carry == 1){
            int[] newArray = new int[digits.length + 1];
            Arrays.fill(newArray, 0);
            newArray[0] = 1;
            return newArray;
        }
        return digits;
        
    }
}