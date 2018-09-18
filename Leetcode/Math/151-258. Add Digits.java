class Solution {
    
    public int addDigits(int num) {
        
        int result = operate(num);
        while(result / 10 != 0){
            result = operate(result);
        }
        return result;
        
    }
    
    
    private int operate(int num){
        
        List<Integer> temp = new ArrayList<>();
        while(num != 0){
            temp.add(num % 10);
            num = num / 10;
        }
        
        int sum = 0;
        for(int element : temp){
            sum = sum + element;
        }
        
        return sum;
    }
}