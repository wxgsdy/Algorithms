class Solution {
    public boolean isAnagram(String s, String t) {
        
        return sortString(s).equals(sortString(t)); 
    }
    
    private String sortString(String s){
        if(s.equals("")) return "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}