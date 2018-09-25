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
    
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals.length < 2) return true;
        Arrays.sort(intervals, intervalComparator);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i-1].end > intervals[i].start) return false;
        }
        return true;
        
    }
}