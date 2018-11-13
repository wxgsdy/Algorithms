class Solution {
    public int minCut(String s) {
        
        
        if(s == null || s.length() <= 1) return 0;
        if(isPalindrome(s)) return 0;
        
        int n = s.length();
        
        int[] f = new int[n]; // 保证[0, i]内的字符串满足回文切割的最少切割次数
        for(int i = 0; i < n; i++){
            f[i] = i;
        }
        
        for(int i = 1; i < n; i++){
            if(isPalindrome(s.substring(0, i + 1))) f[i] = 0;
            for(int j = 0; j < i; j++){
                if( isPalindrome(s.substring(j + 1, i + 1)) ){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[n - 1];
    }
    
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i< j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}