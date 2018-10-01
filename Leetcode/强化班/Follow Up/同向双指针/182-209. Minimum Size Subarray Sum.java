// Methed 1: using hashmap to record 
class Solution {
    public String minWindow(String source, String target) {
        
        if(source.equals("") || target.equals("")) return "";
        Map<Character, Integer> targetMap = getTargetMap(target);
        int targetUniqueChar = targetMap.size();
        
        int n = source.length();
        int minLen = n + 1;
        String minStr = "";
        Map<Character, Integer> map = new HashMap<>();
        int matchedChar = 0;
        int j = 0;
        
        for(int i = 0; i < source.length(); i++){
            
            while(j < n && matchedChar < targetUniqueChar){
                char curt = source.charAt(j);
                if(targetMap.containsKey(curt)){
                    if(map.containsKey(curt)) map.put(curt, map.get(curt) + 1);
                    else map.put(curt, 1);
                    
                    if(map.get(curt) == targetMap.get(curt)) matchedChar++;
                }
                j++;
            }
            
            if(matchedChar == targetUniqueChar) {
                if(j - i < minLen){
                    minLen = j - i;
                    minStr = source.substring(i, j);
                }
            }
            
            // remove i
            char remove = source.charAt(i);
            if(map.containsKey(remove)){
                if(map.get(remove) == targetMap.get(remove)){
                    matchedChar--;
                }
                
                map.put(remove, map.get(remove) - 1);
            }         
            
        }
        return minStr;  
        
    }
    
    
    private Map<Character, Integer> getTargetMap(String source){
        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char curt = source.charAt(i);
            if(result.containsKey(curt)) result.put(curt, result.get(curt) + 1);
            else result.put(curt, 1);
        }
        return result;
    }
}


// Method 2: using ASCII array
