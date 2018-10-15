class Solution {
    
    public String decodeString(String s) {
        
        if(s == null || s.equals("")) return s;
        Stack<String> stack = new Stack<>();
        String res = "";
        
        for(int i = 0; i < s.length(); i++){
            
            char curt = s.charAt(i);            
            if(curt != ']') stack.push(s.substring(i, i+1));
            else{ 
                // base string 
                String str = "";
                while(!stack.peek().equals("[")){
                    str = stack.pop() + str;
                }
                
                // pop "["
                stack.pop();
                
                // times
                String times = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    times = stack.pop() + times;
                }
                
                int time = Integer.parseInt(times);
                if(time != 0){
                    String temp = "";
                    for(int j = 0; j < time; j++){
                        temp = temp + str;
                    }
                    stack.push(temp);
                }
            }
        }
        
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
        
    }
}