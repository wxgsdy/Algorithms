class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> results = new ArrayList<>();
        if(s.length() < 10) return results;
        
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++){
            
            String temp = s.substring(i, i + 10);
            if(set.contains(temp)){
                res.add(temp);
            } else {
                set.add(temp);
            }
        }
        
        results.addAll(res);
        return results;
    }
}