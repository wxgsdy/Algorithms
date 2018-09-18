class Solution {
    
    private boolean carry = false;
    public String addBinary(String a, String b) {
        
        //left pad to same length first
        int diff = Math.abs(a.length() - b.length());
        String pad = "";
        for(int i = 0; i < diff; i++){
            pad = pad + "0";
        }
        
        int length = 0;
        if(a.length() < b.length()){
            a = pad + a;
            length = b.length();
        } else {
            b = pad + b;
            length = a.length();
        }
        
        // now a and b have the same length
        char[] chars = new char[length];
        for(int index = length - 1; index >= 0; index--){
            chars[index] = addBit(a.charAt(index), b.charAt(index));
        }
        
        String temp =  new String(chars);
        if(carry) return "1" + temp;
        else return temp;
        
    }
    
    private char addBit(char c1, char c2){        
        if(c1 == '1' && c2 == '1'){
            if(carry){
                carry = true;
                return '1';
            } else {
                carry = true;
                return '0';
            }
        }
        else if(c1 == '0' && c2 == '0'){
            if(carry){
                carry = false;
                return '1';
            } else {
                carry = false;
                return '0';
            }
        }
        else{
            if(carry){
                carry = true;
                return '0';
            } else {
                carry = false;
                return '1';
            }
        }        
    }
    
    
}