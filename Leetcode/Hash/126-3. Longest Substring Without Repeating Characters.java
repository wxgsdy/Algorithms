class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        if(s.equals("")) return 0;
        if(s.length() == 1) return 1;
        
        char[] chars = s.toCharArray();
        int length = Integer.MIN_VALUE;            
        for(int i = 0; i < chars.length - 1; i++){
            Set<Character> set = new HashSet<>();
            set.add(chars[i]);
            int j = i + 1;
            while(j < chars.length && !set.contains(chars[j])){
                set.add(chars[j]);
                j++;
            }
            length = Math.max(length, set.size());        
            
        }
        
        return length;
        
    }
}