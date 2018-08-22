class Solution {
    public int search(ArrayReader reader, int target) {
        
        // find a upper bound 
        int index = 1;
        while(reader.get(index - 1) < target){
            index = index * 2;
        }
        
        // binary search
        int start = 0, end = index - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target) start = mid;
            else end = mid;
        }
        
        if(reader.get(start) == target) return start;
        if(reader.get(end) == target) return end;
        return -1;
    }
}