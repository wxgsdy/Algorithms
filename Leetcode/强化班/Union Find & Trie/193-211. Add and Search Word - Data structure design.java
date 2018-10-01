class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode(char c){
        this.val = c;
        children = new TrieNode[26];
    }
}

class WordDictionary {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curt.children[c - 'a'] == null) curt.children[c - 'a'] = new TrieNode(c);
            curt = curt.children[c - 'a'];            
        }
        curt.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null) return false;
        return search_helper(this.root, word, 0);
    }
    
    private boolean search_helper(TrieNode node, String word, int curtIndex){
        
        // exit       
        if(curtIndex >= word.length()) return node.isWord;
        
        // split
        char c = word.charAt(curtIndex);
        
        if(c != '.'){
            if(node.children[c - 'a'] == null) return false;
            else return search_helper(node.children[c - 'a'], word, curtIndex + 1);
        } else {
            for(TrieNode next : node.children){
                if(next == null) continue;
                if(search_helper(next, word, curtIndex + 1)) return true;
            }
        }        
        return false;       
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */