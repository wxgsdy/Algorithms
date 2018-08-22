class Solution {
    public int mySqrt(int x) {
        
        if(x < 2) return x;
        double temp = Math.sqrt(x);
        // return (int)temp;
        int start = 0, end = x ;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid == temp) return mid;
            else if(mid > temp) end = mid;
            else start = mid;
        }
        
        if(start <= temp) return start;
        else return end;
        
        
    }
}