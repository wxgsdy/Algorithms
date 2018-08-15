public class Solution {
    /*
    * @param k: An integer
    */
    
    private Queue<Integer> pq;
    private int maxSize;
    
    public Solution(int k) {
        this.pq = new PriorityQueue<Integer>();
        this.maxSize = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        if(pq.size() < maxSize){
            pq.add(num);
        } else {
            if(num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        
        List<Integer> result = new ArrayList<>();
        for(Integer number : pq){
            result.add(number);
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}