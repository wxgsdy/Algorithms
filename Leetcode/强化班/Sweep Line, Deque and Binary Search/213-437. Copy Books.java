public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        
        if(pages == null || pages.length == 0) return 0;
        
        int max = Integer.MIN_VALUE, sum = 0;
        for(int page : pages){
            max = Math.max(max, page);
            sum += page;
        }
        int start = max, end = sum;
        
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(least_people(pages, mid) <= k) end = mid;
            else start = mid;
        }
        
        System.out.print(least_people(pages, 3));
        
        if(least_people(pages, start) <= k) return start;
        else return end;
    }
    
    
    private int least_people(int[] pages, int limit){
        int count = 0, sum = 0;
        for(int i = 0; i < pages.length; i++){
            
            if(sum + pages[i] > limit){
                count++;
                sum = 0;
            }
            sum += pages[i];
        }
        return count + 1;
    }
}