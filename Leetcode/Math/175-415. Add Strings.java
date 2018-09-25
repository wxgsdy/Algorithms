class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int curt = a + b + carry;
            if(curt >= 10){
                sb.append(curt % 10);
                carry = 1;
            } else {
                sb.append(curt);
                carry = 0;
            }
            i--; j--;
        }
        
        // num1 longer
        if(i >= 0){
            while(i >= 0){
                int a = num1.charAt(i) - '0';
                int curt = a + carry;
                if(curt >= 10){
                    sb.append(curt % 10);
                    carry = 1;
                } else {
                    sb.append(curt);
                    carry = 0;
                }
                i--;                
            }
        }
        
        if(j >= 0){
            while(j >= 0){
                int b = num2.charAt(j) - '0';
                int curt = b + carry;
                if(curt >= 10){
                    sb.append(curt % 10);
                    carry = 1;
                } else {
                    sb.append(curt);
                    carry = 0;
                }
                j--;                
            }
        }
        
        
        
        String temp = sb.reverse().toString();
        if(carry == 1) temp = "1" + temp;
        return temp;
    }
}