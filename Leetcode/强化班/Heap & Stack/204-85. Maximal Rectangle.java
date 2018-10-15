class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++){
            int[] curt = new int[n];
            for(int j = 0; j < n; j++){
                int temp = 0;
                int index = i;                
                while(index >= 0 && matrix[index][j] == '1'){
                    temp++;
                    index--;
                }
                curt[j] = temp;
            }
            result = Math.max(result, rowAsBottom(curt));
        }
        return result;
    }
    
    public int rowAsBottom(int[] heights){        
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