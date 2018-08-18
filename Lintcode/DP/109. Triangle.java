// Traverse -> Time compexity not satisfied
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    private int best = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        traverse(0,0,triangle,0);
        return best;
    }
    
    
    private void traverse(int x, int y, int[][] triangle, int sum){
        
        if(x == triangle.length){
            if(best > sum){
                best = sum;
            }
            return;
        }
        traverse(x+1, y, triangle, sum + triangle[x][y]);
        traverse(x+1, y+1, triangle, sum + triangle[x][y]);
    }
}


// 2. Divide and Conquer

public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        return helper(0,0,triangle);
    }
    
    
    private int helper(int x, int y, int[][] triangle){
        // exit
        if(x == triangle.length) return 0;
        return triangle[x][y] + Math.min( helper(x+1, y, triangle),
                                          helper(x+1, y+1, triangle) );
    }
}


// 3. Divide and Conquer + Memory
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    private int[][] triangle;
    private int[][] memory;
    
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0) return -1;
        
        // initialize memory
        this.memory = new int[triangle.length][triangle.length];
        for(int i = 0; i < memory.length; i++){
            for(int j = 0; j < memory.length; j++){
                memory[i][j] = Integer.MAX_VALUE;
            }
        }
        
        this.triangle = triangle;
        return search(0,0);
        
        
    }
    
    private int search(int x, int y){
        
        // exit
        if(x == triangle.length) return 0;
        if(memory[x][y] != Integer.MAX_VALUE) return memory[x][y];
        // divide
        
        memory[x][y] = triangle[x][y] + Math.min( search(x+1, y),
                                          search(x+1, y+1));
        
        return memory[x][y];
        
        
    }
}


// 4. 多重循环 - bottom up

public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    // bottom up
    public int minimumTotal(int[][] triangle) {
        
        int n = triangle.length;
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0) return -1;
        
        // state matrix
        int[][] state = new int[n][n];
        for(int index = 0; index < n; index++){
            state[n-1][index] = triangle[n-1][index];
        }
        
        // bottom up
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                state[i][j] = triangle[i][j] + Math.min(state[i + 1][j], state[i + 1][j + 1]);
            }
        }
        
        return state[0][0];
    }
}

// 5. 多重循环 -- top down 
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