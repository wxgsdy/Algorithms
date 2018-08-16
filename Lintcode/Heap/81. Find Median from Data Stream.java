public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    
    private PriorityQueue<Integer> maxH, minH;
    private int numOfElements = 0;
    
    
    public int[] medianII(int[] nums) {
        // write your code here
        int cnt = nums.length;
        maxH = new PriorityQueue<Integer>(cnt, Collections.reverseOrder());
        minH = new PriorityQueue<Integer>(cnt);
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }
    
    public void addNumber(int num) {
        minH.offer(num);
        int n = minH.poll();
        maxH.offer(n);
        int len1 = maxH.size();
        int len2 = minH.size();
        if (len1 > len2) {
            n = maxH.poll();
            minH.offer(n);
        }
    }
    
    public int getMedian() {
        int len1 = maxH.size();
        int len2 = minH.size();
        if (len1 == len2) {
            return maxH.peek();
        }
        else {
            return len1 > len2 ? maxH.peek() : minH.peek();
        }
    }
    
    
}