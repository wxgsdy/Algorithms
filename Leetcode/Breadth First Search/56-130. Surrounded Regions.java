class Solution {
    
    private class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int[] deltaX = new int[]{0, 0, -1, 1};
    private int[] deltaY = new int[]{-1, 1, 0, 0};
    
    public void solve(char[][] board) {
        
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        int m = board.length; 
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && visited[i][j] == false){
                    bfs(board, visited, new Coordinate(i,j));
                } 
            }
        }
        
    }
    
    private void bfs(char[][] board, boolean[][] visited, Coordinate start){
        
        boolean metBound = false;
        Queue<Coordinate> queue = new LinkedList<>();
        List<Coordinate> memory = new ArrayList<>();
        
        queue.offer(start);
        memory.add(start);        
        visited[start.x][start.y] = true;
        board[start.x][start.y] = 'X';
        if(onBound(board, start)) metBound = true;
        
        
        while(!queue.isEmpty()){
            Coordinate curt = queue.poll();
            for(int index = 0; index < 4; index++){
                Coordinate newCoor = new Coordinate(curt.x + deltaX[index], curt.y + deltaY[index]);
                if(!inBound(board, newCoor)) continue;
                if(board[newCoor.x][newCoor.y] == 'O' && visited[newCoor.x][newCoor.y] == false){
                    visited[newCoor.x][newCoor.y] = true;
                    queue.offer(newCoor);
                    board[newCoor.x][newCoor.y] = 'X';
                    memory.add(newCoor);
                    if(onBound(board, newCoor)) metBound = true;
                }
            }            
        }
        
        if(metBound){
            for(Coordinate temp : memory){
                board[temp.x][temp.y] = 'O';
            }
        }
    }
    
    private boolean inBound(char[][] board, Coordinate coor){
        return coor.x >= 0 && coor.x < board.length && coor.y >= 0 && coor.y < board[0].length;
    }
    private boolean onBound(char[][] board, Coordinate coor){
        if(!inBound(board, coor)) return false;
        return coor.x == 0 || coor.x == board.length - 1 || coor.y == 0 || coor.y == board[0].length - 1;
    }
    
    
}

