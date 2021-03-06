// 三步翻转法


public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        
        if(str == null || str.length == 0) return;
        offset = offset % str.length;
        if(offset == 1) return;
        
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        
    }
    
    
    private void reverse(char[] str, int start, int end){
        for(int i = start, j = end; i < j; i++,j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}