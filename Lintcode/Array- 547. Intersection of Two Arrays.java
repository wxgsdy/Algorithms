// 1. Set
public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])) res.add(nums2[i]);
        }
        
        int[] result = new int[res.size()];
        int k = 0;
        for(int item : res){
            result[k++] = item;
        }
        
        return result;
    }
};
// 2. Sort & merge
public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                set.add(nums1[i]);
                i++;j++;
            }
        }
        
        int[] res = new int[set.size()] ;
        int k = 0;
        for(int item : set){
            res[k++] = item;
        }
        return res;
    
    }
};
// 3. Sort & binart search

Idea: use private boolean binarySearch(int[] nums, int target) to decide whether a number 
      exsists in the array. ---> rather stupid thought.