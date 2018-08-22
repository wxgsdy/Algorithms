class Solution {
    public String reverseString(String s) {
        if(s.equals("")) return s;
        
        char[] chars = s.toCharArray();
        rotateArray(chars);
        return new String(chars);
    }
    
    private void rotateArray(char[] chars){
        for(int i = 0, j = chars.length - 1; i < j; i++,j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}