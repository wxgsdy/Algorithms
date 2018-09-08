class Solution {
    
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            
            while(i < j && !isAlphanumeric(s.charAt(i))) i++;            
            while(i < j && !isAlphanumeric(s.charAt(j))) j--;
            
            
            if(s.charAt(i) != s.charAt(j)) break;
            else{
                i++; j--;
            }
        }        
        
        return i >= j;        
    }
    
    private boolean isAlphanumeric(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }
}