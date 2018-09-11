class Solution {
    
    public int singleNumber(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int number : nums){
            if(set.contains(number)) set.remove(number);
            else set.add(number);
        }
        
        Iterator<Integer> iter = set.iterator();
        return iter.next();
    }
}