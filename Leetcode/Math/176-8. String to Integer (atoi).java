class Solution {
    
    public int myAtoi(String str) 
        str = str.trim();       
        if(str.length() == 0) return 0;
        int flag = 0, index = 0;
        
        // get flag
        if(str.charAt(index) == '-') {
            flag = -1;
            index++;
        }
        else if(str.charAt(index) == '+'){
            flag = 1; index++;
        } 
        else if(Character.isDigit(str.charAt(index))) flag = 1;
        else return 0;
        
        // count number 
        long res = 0;
        while(index < str.length() && Character.isDigit(str.charAt(index))){
            int digit = str.charAt(index) - '0';
            res = res * 10 + digit;
            if(res > Integer.MAX_VALUE) break;
            index++;å
        }
        
        
        if(res > Integer.MAX_VALUE) return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int)res * flag;
        
        
        
        
    }
}