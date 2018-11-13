class Solution {
    
    List<List<String>> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        
        if(s.equals("") || s.length() == 0) return new ArrayList<String>();
        recursionHelper(s, new ArrayList<String>(), 0);
        
        List<String> results = new ArrayList<>();
        for(List<String> temp : res){
            String curt = temp.get(0);
            for(int i = 1; i < temp.size(); i++){
                curt += ".";
                curt += temp.get(i);
            }
            results.add(curt);
        }
        return results;          
    }
    
    private void recursionHelper(String s, 
                                 List<String> curt,
                                 int startIndex){       

        
        if(curt.size() == 4){
            if(startIndex >= s.length()){
                res.add(new ArrayList<String>(curt));
            }
            return;
        }
        
        for(int i = startIndex; i < Math.min(s.length(), startIndex + 4); i++){
            String str = s.substring(startIndex, i + 1);
            if(!isValid(str)) continue;
            
            curt.add(str);
            recursionHelper(s, curt, i + 1);
            curt.remove(curt.size() - 1);
        }
    }
    
    private boolean isValid(String s){
        // whether a String ip is valid
        if(s.length() == 0) return false;
        if(s.length() >= 4) return false;
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;

    }
    

}