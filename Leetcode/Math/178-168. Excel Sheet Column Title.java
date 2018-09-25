class Solution {
    public String convertToTitle(int n) {
        
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int curt = (n - 1) % 26;
            char c = (char)('A' + curt);            
            sb.insert(0, c);
            n = (n - 1) / 26;
        }
        //System.out.print((char)('A' + 1));
        return sb.toString();
    }
}

class Solution {
    public String convertToTitle(int n) {        
        // exit
        if(n == 0) return "";
        return convertToTitle((n - 1) / 26) + (char)('A' + (n-1) % 26);
        
    }
}