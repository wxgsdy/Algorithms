// Method 1: using Hashmap

public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        
        // Map : number -> index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            
            if(map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]), i};
            }else{
                map.put(numbers[i], i);
            }
        }
        
        return new int[]{};
    }    
    
}


// Method 2: using 2 pointers, but in order to keep record of index, using Pair class
public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    class Pair{
        Integer value;
        Integer index;
        
        public Pair(Integer value, Integer index){
            this.value = value;
            thid.index = index;
        }
        
        Integer getValue(){
            return this.value;
        }
    } 
    
    class valueComparator implements Comparator<Pair>{
        
        public int compare(Pair o1, Pair o2){
            return o1.getValue().compareTo(o2.getValue());
        }
    } 
    
    public int[] twoSum(int[] numbers, int target) {
        
        Pair[] number = new Pair[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            number[i] = new Pair(numbers[i], i);
        }
        
        Arrays.sort(number, valueComparator);
        int left = 0, right = number.length - 1;
        while(left < right){
            if(number[left].getValue() + number[right].getValue() == target){
                int index1 = number[left].index;
                int index2 = number[right].index;
                return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
            }
            
            if(number[left].getValue() + number[right].getValue() < target){
                left++;
            }else{
                right--;
            }
        }
        
        return new int[]{};
    }
}