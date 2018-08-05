// 1. Merge

public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        
        Set<Integer> set = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;j++;
            }
            else j++;
        }
        
        // set to array
        int[] res = new int[set.size()];
        i = 0;
        for(int num : set){
            res[i++] = num;
        }
        return res;
         
    }
};


// 2. HashSet
public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])) res.add(nums2[i]);
        }
        
        int[] ress = new int[res.size()];
        int i =0;
        for(int num: res)
            ress[i++] = num;
        return ress;
    }
};