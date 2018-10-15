class Solution {
    
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int area = Integer.MIN_VALUE;
        for(int i = 0; i <= heights.length; i++){
            int curt = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty() && curt <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        return area;
    }
}