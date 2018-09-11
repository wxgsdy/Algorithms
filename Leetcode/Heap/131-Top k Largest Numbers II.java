public class Solution {
    /*
    * @param k: An integer
    */
    
    private int maxSize;
    private Queue<Integer> pq;
    
    public Solution(int k) {
        // do intialization if necessary
        pq = new PriorityQueue<>();
        maxSize = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if(pq.size() < maxSize) pq.add(num);
        else{
            int curt = pq.peek();
            if(curt < num){
                pq.poll();
                pq.add(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> result = new ArrayList<Integer>(pq);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}