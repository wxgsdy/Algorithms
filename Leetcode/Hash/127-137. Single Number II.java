class Solution {
    
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>(); // number -> time
        for(int number : nums){
            // map only contains result at last
            if(map.containsKey(number)){
                if(map.get(number) == 2) map.remove(number);
                else if(map.get(number) == 1) map.put(number, 2);
            } else {
                map.put(number, 1);
            }
        }
        
        Iterator<Integer> iter = map.keySet().iterator();
        return iter.next();
        
    }
}