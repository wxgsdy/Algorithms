/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    private Comparator<Interval> intervalComparator = new Comparator<Interval>(){
        public int compare(Interval left, Interval right){
            return left.start - right.start;
        }  
    };    
    
    public List<Interval> merge (List<Interval> intervals) {
        
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, intervalComparator);
        
        List<Interval> result = new ArrayList<>();
        int size = intervals.size();
        int i = 0;
        while(i < size){
            Interval curt = intervals.get(i);
            int j = i + 1;            
            while(j < size && curt.end >= intervals.get(j).start){
                curt.end = Math.max(intervals.get(j).end, curt.end);
                j = j + 1;               
            }            
            result.add(curt);
            i = j;
        }
        
        return result;      
    }
}