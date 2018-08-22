public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0 || offset <= 1) return;
        offset = offset % str.length;
        
        rotate(str, 0, str.length - offset - 1);
        rotate(str, str.length - offset, str.length - 1);
        rotate(str, 0, str.length - 1);
        
    }
    
    private void rotate(char[] s, int start, int end){
        
        for(int i = start, j = end; i < j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}