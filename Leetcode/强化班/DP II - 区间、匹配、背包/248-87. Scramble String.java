public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
    
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length())
            return false;
            
        if (hash.containsKey(s1 + "#" + s2))
            return hash.get(s1 + "#" + s2);
        
        int n = s1.length();
        if (n == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        for (int k = 1; k < n; ++k) {
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) &&
                isScramble(s1.substring(k, n), s2.substring(k, n)) ||
                isScramble(s1.substring(0, k), s2.substring(n - k, n)) &&
                isScramble(s1.substring(k, n), s2.substring(0, n - k))
                ) {
                hash.put(s1 + "#" + s2, true);
                return true;
            }
        }
        hash.put(s1 + "#" + s2, false);
        return false;
    }
}