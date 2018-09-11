class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> results = new ArrayList<>();
        if(strs == null || strs.length == 0) return results;
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        // build map
        for(String str : strs){
            String temp = sortString(str);
            if(map.containsKey(temp)) map.get(temp).add(str);
            else{
                map.put(temp, new ArrayList<>());
                map.get(temp).add(str);
            }
        }
        
        // from Map to result
        for(String sorted : map.keySet()){
            results.add(new ArrayList<String>(map.get(sorted)));
        }
        return results;
    }
    
    
    private String sortString(String s){
        if(s.equals("")) return "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}