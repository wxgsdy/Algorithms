class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] state = new int[n];
        int[] pre =   new int[n];
        Arrays.fill(state, 1);
        
        for(int i = 0; i < n; i++){
            pre[i] = i;
        }
        
        // build the state array;        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && state[j] + 1 > state[i]){
                    state[i] = state[j] + 1;
                    pre[i] = j;
                }
            }
        }        
        // find max of state
        int endIndex = 0;
        int max = state[0];
        for(int i = 1; i < n; i++){
            if(state[i] > max){
                max = state[i];
                endIndex = i;
            }
        }
        
        // trace back from endIndex         
        int index = endIndex;
        while(pre[index] != index){
            result.add(nums[index]);
            index = pre[index];
        }
        result.add(nums[index]);
        Collections.reverse(result);
        return result;
    }
}