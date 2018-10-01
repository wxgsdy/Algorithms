class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    
    public TrieNode(char c){
        this.val = c;
        this.children = new TrieNode[26]; // 26 lower-case cahracters
    }
}
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curt.children[c - 'a'] == null) curt.children[c - 'a'] = new TrieNode(c);
            curt = curt.children[c - 'a'];
        }
        curt.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curt.children[c - 'a'] == null) return false;
            curt = curt.children[c - 'a'];
        }
        return curt.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curt = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curt.children[c - 'a'] == null) return false;
            curt = curt.children[c - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */