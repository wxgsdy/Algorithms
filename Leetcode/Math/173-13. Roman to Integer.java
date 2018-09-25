class Solution {
    
    public int romanToInt(String s) {
        
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for(int i = 0; i < len; i++){
            if(i == len - 1) res += toint(chars[i]);
            else{
                if(toint(chars[i]) < toint(chars[i + 1])) res = res - toint(chars[i]);
                else res =  res + toint(chars[i]);
            }
        }
        return res;
        
    }
    
    
    
    private int toint(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}