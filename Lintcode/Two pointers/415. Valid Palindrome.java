public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if(s.length() == 0 || s == null) return true;
        int start = 0, end = s.length() - 1;
        while(start < end){
            
            while(start < s.length() && !isValid(s.charAt(start))){
                start++;
            }
            
            if(start == s.length()) return true;
            
            while(end >= 0 && !isValid(s.charAt(end))){
                end--;
            }
            
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) break;
            else{
                start++;
                end--;
            }
        }
        return start >= end;
    }
    
    private boolean isValid(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }
}