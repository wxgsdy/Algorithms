class Solution {
    
    public boolean isOneEditDistance(String s, String t) {
        
        int i = 0;
        while(i < Math.min(s.length(), t.length()) && s.charAt(i) == t.charAt(i)){
            i++;
        }
        
        
        if(i < s.length() && i < t.length()){
            // index still in the middle
            if(s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
            else if(s.length() > t.length()) return s.substring(i + 1).equals(t.substring(i));
            else return s.substring(i).equals(t.substring(i + 1));
        }
        
        else return Math.abs(s.length() - t.length()) == 1;
        
        
            
            
      
            
        
    }
}