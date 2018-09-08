public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        
        if(chars == null || chars.length == 0) return;
        
        int start = 0, end = chars.length - 1;
        while(start <= end){
            
            while(start <= end && Character.isLowerCase(chars[start])){
                start++;
            }
            
            while(start <= end && Character.isUpperCase(chars[end])){
                end--;
            }
            
            if(start <= end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++; end--;
            }
        }
        return;
    }
}