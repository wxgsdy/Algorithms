class Solution {
    
    public int titleToNumber(String s) {
        
        int res = 0;
        //int index = s.length() - 1;
        for(int index = 0; index < s.length(); index++){
            res = res * 26 + s.charAt(index) - 'A' + 1;
        }
        return res;
    }
}