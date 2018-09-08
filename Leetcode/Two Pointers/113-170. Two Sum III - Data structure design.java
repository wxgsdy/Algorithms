class TwoSum {

    /** Initialize your data structure here. */
    private List<Integer> nums;
    private Map<Integer,Integer> map;
        
    public TwoSum() {
        
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        
        nums.add(number);
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            
        }        
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
        
        for(int i = 0; i < nums.size(); i++){
            int num1 = nums.get(i), num2 = value - num1;
            
            if(num1 == num2){
                
                if(map.get(num1) > 1) return true;
                
            } else {
                
                if(map.containsKey(num2)) return true;
            }    
            
         
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */