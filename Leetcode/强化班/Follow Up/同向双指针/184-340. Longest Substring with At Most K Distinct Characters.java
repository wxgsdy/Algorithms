class Solution {
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if(k == 0 || s.equals("")) return 0;
        // if(s.length() <= k) return s.length();
        
        Map<Character, Integer> map = new HashMap<>();   // char -> count
        int n = s.length();
        int maxLen = Integer.MIN_VALUE, j = 0;
        for(int i = 0; i < n; i++){
            
            while(j < n && (map.size() < k ||(map.size() == k && map.containsKey(s.charAt(j))))){                
                char curt = s.charAt(j);
                if(map.containsKey(curt)) map.put(curt, map.get(curt) + 1);
                else map.put(curt, 1);               
                
                j++;
            }
            
            if(j - i > maxLen && map.size() == k){
                maxLen = j - i;
            }
            
            // remove i
            char remove = s.charAt(i);
            if(map.get(remove) == 1) map.remove(remove);
            else map.put(remove, map.get(remove) - 1);            
        }
        
        return maxLen == Integer.MIN_VALUE ? s.length() : maxLen;
        
    }
}