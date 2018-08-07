public class TwoSum {
    /*
     * @param number: An integer
     * @return: nothing
     */
     
    private Map<Integer, Integer> map;
    private List<Integer> nums;
    
    public TwoSum(){
        map = new HashMap<>();
        nums = new ArrayList<>();
    }
        
    
    public void add(int number) {
        
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            nums.add(number);
        }
        
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        
        for(int i = 0; i < nums.size(); i++){
            int num1 = nums.get(i), num2 = value - num1;
            if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
        }
        return false;
    }
}