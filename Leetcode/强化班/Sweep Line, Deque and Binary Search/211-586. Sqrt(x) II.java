public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        double start = 0, end = Math.max(x, 1.0);
        double eps = 1e-12;
        while(start + eps < end){
            double mid = (start + end) / 2;
            if(mid * mid < x) start = mid;
            else end = mid;
        }
        return start;
    }
}