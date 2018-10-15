// method : Trie + DFS
class TrieNode{
    public char val;
    public TrieNode[] children;
    public boolean isWord;
    public String word;
    public TrieNode(char c){
        this.val = c;
        this.children = new TrieNode[26];
        this.isWord = false;
        this.word = null;
    }
}
class Trie{
    
    TrieNode root;
    
    public Trie(){
        root = new TrieNode(' ');
    }
    
    public void add(String str){
        TrieNode curt = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(curt.children[c - 'a'] == null) curt.children[c - 'a'] = new TrieNode(c);
            curt = curt.children[c - 'a'];
        }
        curt.isWord = true;
        curt.word = str;
    }
}

class Solution {
    
    
    private List<String> results = new ArrayList<>();
    private Trie trie;
    private int[] dx = new int[]{0, 0, -1, 1};
    private int[] dy = new int[]{-1, 1, 0, 0};
    
    public List<String> findWords(char[][] board, String[] words) {        
        if(board == null || board.length == 0 || board[0].length == 0) return new ArrayList<String>();
        if(words == null || words.length == 0) return new ArrayList<String>();
        
        trie = new Trie();
        for(String str : words){
            trie.add(str);
        }            
                
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];                
                search(board, i, j, trie.root.children[c - 'a']);
            }
        }        
        
        Collections.sort(results);
        return results;
    }  
    
    private void search(char[][] board, 
                        int x, int y,
                        TrieNode node){
        // exit
        if(node == null) return;
        if(node.word != null){
            if(!results.contains(node.word)){
                results.add(node.word);
                // return;
            }
        } 
        
        // back tracking -> set to '#'        
        char temp = board[x][y];
        board[x][y] = '#';
        // split
        for(int j = 0; j < 4; j++){
            int newX = x + dx[j];
            int newY = y + dy[j];
            if(!inBound(newX, newY, board)) continue;
            if(board[newX][newY] == '#') continue;
            search(board, newX, newY, node.children[board[newX][newY] - 'a']);
        }
        board[x][y] = temp;
    }
    
    private boolean inBound(int x, int y, char[][] board){
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}