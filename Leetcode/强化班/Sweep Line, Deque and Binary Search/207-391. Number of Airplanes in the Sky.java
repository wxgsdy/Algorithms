/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Pair{
    // flag: 1 represent start, -1 end
    int time, flag;
    public Pair(int time, int flag){
        this.time = time;
        this.flag = flag;
    }
}
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
     
     private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left, Pair right){
            if(left.time == right.time) return left.flag - right.flag;
            else return left.time - right.time;
        } 
        
        
    };
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        
        if(airplanes == null || airplanes.size() == 0) return 0;
        
        // build sweep arrayList
        List<Pair> list = new ArrayList<>();
        for(Interval inter : airplanes){
            list.add(new Pair(inter.start, 1));
            list.add(new Pair(inter.end, -1));
        }
        
        Collections.sort(list, pairComparator);
        
        int count = 0, result = Integer.MIN_VALUE;
        for(Pair temp : list){
            if(temp.flag == 1) count++;
            else count--;
            result = Math.max(count, result);
        }
        
        return result;
    }
}