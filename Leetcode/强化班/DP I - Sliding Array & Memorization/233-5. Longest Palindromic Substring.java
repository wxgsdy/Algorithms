// Method 1 : O(n^2)

class Solution {
    
    
    private int length;
    private String res;
    
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0) return s;
        length = 1; res = s.substring(0, 1);
        
        for(int i = 0; i < s.length() - 1; i++){
            search(s, i, i);
            search(s, i, i + 1);
            
        }
        return res;
    }
    
    private void search(String s, int start, int end){        
        
        while( start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end) ){
            start--; end++;
        }
        
        if(end - start - 1 > length){
            length = end - start - 1;
            res = s.substring(start + 1, end);
        }
    }
}


// DP
class Solution {
    
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0) return s;
        
        int n = s.length();
        
        int length = 1;
        String res = s.substring(0, 1);
        
        boolean[][] f = new boolean[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; i++){
            f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(f[i][i + 1]){
                length = 2;
                res = s.substring(i, i + 2);
            }
        }
        
        // function
        for(int i = n - 3; i >= 0; i--){
            for(int j = i + 2; j < s.length(); j++){
                
                f[i][j] = (f[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j));
                
                if(f[i][j]){
                    if(j - i + 1 > length){
                        length = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        return res;     
    }
}