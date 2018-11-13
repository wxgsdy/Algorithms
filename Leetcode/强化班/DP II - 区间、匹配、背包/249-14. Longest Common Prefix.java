class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        String cmp = strs[0];
        if(cmp.equals("")) return "";
        String res = "";
        int index = 0;
        while(index < cmp.length() && matchChar(strs, index, cmp.charAt(index))){
            res = res + cmp.charAt(index);
            index++;
        }
        return res;
    }
    
    private boolean matchChar(String[] strs, int index, char c){
        for(String str : strs){
            if(index >= str.length()) return false;
            if(str.charAt(index) != c) return false;
        }
        return true;
    }
}