public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // 
        
        
        if(strs == null || strs.length == 0 ) return new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            if(map.containsKey(sortString(strs[i]))){
                map.get(sortString(strs[i])).add(strs[i]);
            } else{
                map.put(sortString(strs[i]), new ArrayList<String>());
                map.get(sortString(strs[i])).add(strs[i]);
            }
        }
        
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                results.addAll(entry.getValue());
            }
        }
        return results;
        
        
    }
    
    private String sortString(String s){
        if(s == "") return "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}