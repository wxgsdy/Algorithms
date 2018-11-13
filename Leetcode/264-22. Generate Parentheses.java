class Solution {
    
    private List<String> res;
    
    public List<String> generateParenthesis(int n) {
        
        res = new ArrayList<String>();
        if(n == 0){
            res.add("");
            return res;
        }
        
        recursionHelper("(", 1, 0, n);
        return res;
        
    }
    
    private void recursionHelper(String curt, 
                                 int numLeft,
                                 int numRight,
                                 int n){
        
        // exit
        if(numRight > numLeft) return;
        
        if(curt.length() == 2 * n){
            if(numLeft == n && numRight == n){
                res.add(new String(curt));                
            }
            
            return;
        }
        
        // add left
        curt += "(";
        recursionHelper(curt, numLeft + 1, numRight, n);
        curt = curt.substring(0, curt.length() - 1);
        
        // add right
        curt += ")";
        recursionHelper(curt, numLeft, numRight + 1, n);
        curt = curt.substring(0, curt.length() - 1);
    }
}