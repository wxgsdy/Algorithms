class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> results = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                // nums1[i] = nums2[j]
                results.add(nums1[i]);
                i++; j++;
            }
        }
        
        // List to array
        int[] res = new int[results.size()];
        for(int k = 0; k < results.size(); k++){
            res[k] = results.get(k);
        }
        
        return res;
    }
}