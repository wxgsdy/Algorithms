// Method 1: Traverse, but TLE
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     
    private int min = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        traverse(0, 0, triangle[0][0], triangle);
        return min;
    }
    
    private void traverse(int x, int y, int curtSum, int[][] triangle){
        
        if(x == triangle.length - 1){
            if(min > curtSum) min = curtSum;
            return;
        }
        
        traverse(x+1, y, curtSum + triangle[x+1][y], triangle);
        traverse(x+1, y+1, curtSum + triangle[x+1][y+1], triangle);
    }
}

// Method 2: DIvide and Conquer, TLE also
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        return helper(0,0, triangle);
    }
    
    private int helper(int x, int y, int[][] triangle){
        // 从当前(x, y) 开始到最后的最小和;
        
        // exit 
        if(x == triangle.length) return 0;
        // divide and conquer
        return triangle[x][y] + Math.min(helper(x+1, y, triangle), 
                                         helper(x+1, y+1, triangle));
    }
}

// Method 3: add memory to solve TLE
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    
    private int[][] memory;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        memory = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < triangle.length; i++){
            Arrays.fill(memory[i], Integer.MAX_VALUE);
        }
        
        return helper(0, 0, triangle);
    }
    
    private int helper(int x, int y, int[][] triangle){
        // 从当前(x, y) 开始到最后的最小和;
        
        // exit 
        if(x == triangle.length) return 0;
        if(memory[x][y] != Integer.MAX_VALUE) return memory[x][y];
        
        // divide and conquer
        int res = triangle[x][y] + Math.min(helper(x+1, y, triangle), 
                                         helper(x+1, y+1, triangle));
        memory[x][y] = res;
        return res;
    }
}

// Methos 4: bottom up
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialization
        for(int i = 0; i < n; i++){
            f[n-1][i] = triangle[n-1][i];
        }
        
        // build state matrix
        for(int i = n - 2; i >=0 ; i--){
            for(int j = 0; j <= i; j++){
                f[i][j] = triangle[i][j] + Math.min(f[i+1][j], f[i+1][j+1]);
            }
        }
        return f[0][0];
    }
}

// Method 5: top down 
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0) return -1;
        int n = triangle.length;
        int[][]state = new int[n][n];
        
        // initialize state matrix
        state[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            state[i][0] = triangle[i][0] + state[i - 1][0];
            state[i][i] = triangle[i][i] + state[i - 1][i - 1];
        }
        
        // top down
        for(int i = 2; i < n; i++){
            for(int j = 1; j < i; j++){
                state[i][j] = triangle[i][j] + Math.min(state[i - 1][j], state[i - 1][j - 1]);
            }
        }
        
       int result = state[n - 1][0];
       for(int i = 1; i < n; i++){
           result = Math.min(state[n - 1][i], result);
       }
       return result;    
        
    }
}