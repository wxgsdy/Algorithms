
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        Set<Integer> results = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                results.add(nums2[i]);
            }
        }
        
        // set to array
        int[] res = new int[results.size()];
        int count = 0;
        for(int i : results){
            res[count++] = i;
        }
        
        return res;
    }
}