// BFS
class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int m = image.length, n = image[0].length;
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        
        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(sr, sc));
        visited[sr][sc] = true;
        int cmp = image[sr][sc];
        image[sr][sc] = newColor;
        
        while(!queue.isEmpty()){            
            Coordinate curt = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = curt.x + deltaX[i];
                int newY = curt.y + deltaY[i];
                
                if(newX < 0 || newX >= image.length || newY < 0 || newY >= image[0].length ) continue;
                if(visited[newX][newY] == true) continue;
                if(image[newX][newY] == cmp){
                    queue.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                    image[newX][newY] = newColor;
                }                
            }
        }
        
        return image;        
    }
}


// DFS

class Solution {
    
    
    private int[] deltaX = new int[]{-1, 1, 0, 0};
    private int[] deltaY = new int[]{0, 0, -1, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int cmp = image[sr][sc];
        dfs(image, visited, sr, sc, newColor, cmp);
        return image;
    }
    
    private void dfs(int[][] image, boolean[][] visited, int x, int y, int newColor, int cmp){
        
        visited[x][y] = true;
        image[x][y] = newColor;
        
        for(int i = 0; i < 4; i++){
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];
            if(! inBound(image, newX, newY) ) continue;
            if(visited[newX][newY] == true) continue; 
            if(image[newX][newY] == cmp){
                dfs(image, visited, newX, newY, newColor, cmp);
            }
            
        }        
    }
    
    private boolean inBound(int[][] image, int x, int y){
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
    
    
}