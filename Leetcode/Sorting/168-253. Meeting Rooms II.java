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
        
    
    private class Pair{
        int time;
        int flag; // 1, -1
        public Pair(int time, int flag){
            this.time = time;
            this.flag = flag;
        }
    }    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){        
        public int compare(Pair left, Pair right){
            if(left.time == right.time) return left.flag - right.flag;
            else return left.time - right.time; // ascending order
        }  
    } ;
    
    
    public int minMeetingRooms(Interval[] intervals) {
        
        // build list of interval
        List<Pair> points = new ArrayList<>();        
        for(Interval curt : intervals){
            points.add(new Pair(curt.start, 1));
            points.add(new Pair(curt.end, -1));
        }
        
        // sort
        Collections.sort(points, pairComparator);
        
        // saomiaoxina
        int result = 0;
        int cache = 0;
        for(int i = 0; i < points.size(); i++){
            cache += points.get(i).flag;
            result = Math.max(result, cache);            
        }
        
        return result;
        
    }
}