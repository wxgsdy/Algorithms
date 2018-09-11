/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
     
    private class Pair{
        Point point; 
        int dis;
        public Pair(Point p, int dis){
            this.point = p;
            this.dis = dis;
        }
        
    }
    // we need desending order 
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left, Pair right){
            if(left.dis == right.dis){
                if(left.point.x == right.point.x){
                    return right.point.y - left.point.y;
                } else {
                    return right.point.x - left.point.x;
                }
            } else {
                return right.dis - left.dis; 
            }
        }   
    }; 
    private int distance(Point a, Point b){
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // build the maxHeap
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, pairComparator);
        
        for(Point curtPoint : points){
            Pair curtPair = new Pair(curtPoint, distance(origin, curtPoint));
            if(pq.size() < k){
                pq.add(curtPair);
            } else {
                Pair tail = pq.peek(); // "max" one in the pq
                if(pairComparator.compare(curtPair, tail) > 0){
                    pq.poll();
                    pq.add(curtPair);
                }
            }
        }
        
        Point[] result = new Point[k];
        for(int i = 0; i < k; i++){
            result[k - i - 1] = pq.poll().point;
        }
        return result;
    }   
}