public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        
        if(s.equals("")) return 0;
        if(s.length() < 2) return s.length();
        
        int n = s.length();
        char[] chars = s.toCharArray();
        int j = 0, maxLength = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            while(j < n && !set.contains(chars[j])){
                set.add(chars[j]);
                j++;
            }
            maxLength = Math.max(maxLength, j - i);
            set.remove(chars[i]);
        }
        return maxLength;
    }
}