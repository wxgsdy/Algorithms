class Solution {
    
    String[] codeBook = new String[]{null, null, "abc", "def", "ghi","jkl","mno","pqrs", "tuv","wxyz" };
    private List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.equals("") || digits.length() == 0) return res;
            
        String curt = "";
        recursionHelper(digits, 0, curt);
        return res;
    }
    
    
    private void recursionHelper(String digits, int digitIndex, String curt){
        
        if(curt.length() == digits.length()){
            res.add(new String(curt));
            return;
        }
        
        int index = digits.charAt(digitIndex) - '0';
        for(int i = 0; i < codeBook[index].length(); i++){
            curt = curt + codeBook[index].charAt(i);
            recursionHelper(digits, digitIndex + 1, curt);
            curt = curt.substring(0, curt.length() - 1);
        }
    }
    
}