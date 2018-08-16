/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
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
        Point p;
        int dis;
        public Pair(Point p, int dis){
            this.p = p;
            this.dis = dis;
        }
    }
    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        // need a maxHeap
        public int compare(Pair left, Pair right){
            
            if(left.dis == right.dis){
                if(left.p.x != right.p.x) return right.p.x - left.p.x;
                else return right.p.y - left.p.y;
            }
            return right.dis - left.dis;
        }
    };
    
    
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Queue<Pair> maxHeap = new PriorityQueue<>(k, pairComparator);
        
        for(Point item : points){
            Pair temp = new Pair(item, distance(item, origin));
            if(maxHeap.size() < k){
                maxHeap.add(temp);
            }
            else if(maxHeap.peek().dis > temp.dis){
                maxHeap.poll();
                maxHeap.add(temp);
            }
        }
        
        
        int len = maxHeap.size();
        Point[] result = new Point[len];
        int index = len - 1;
        while(! maxHeap.isEmpty()){
            result[index] = maxHeap.poll().p;
            index--;
        }
        
        return result;
    }
    
    
    private int distance(Point a, Point b){
        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
    }
}