class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    public List<String> word_list;
    public TrieNode(char c){
        this.val = c;
        children = new TrieNode[26];
        word_list = new ArrayList<String>();
    }
    
}
class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode(' ');
    }
    
    public void add(String word){
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curt.children[c - 'a'] == null) curt.children[c - 'a'] = new TrieNode(c);
            curt = curt.children[c - 'a'];
            curt.word_list.add(word);
        }
        curt.isWord = true;
    }
    private TrieNode find(String word){
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curt.children[c - 'a'] == null) return null;
            curt = curt.children[c- 'a'];            
        }
        return curt;
    }
    public List<String> get_words_with_prefix (String prefix){
        TrieNode node = find(prefix);
        if(node == null) return null;
        else return node.word_list;
    }
    public boolean contains(String word){
        TrieNode node = find(word);
        if(node == null) return false;
        return node.isWord;
    }
    
}


class Solution {
    
    private List<List<String>> results = new ArrayList<>();    
    public List<List<String>> wordSquares(String[] words) {
        
        if(words == null || words.length == 0) return results;
        
        Trie trie = new Trie();
        for(String word: words){
            trie.add(word);
        }
        
        
        for(String word : words){
            List<String> curt = new ArrayList<>();
            curt.add(word);
            search(trie, curt);           
        }   
        //System.out.print(trie.get_words_with_prefix("ar"));        
        
        return results;       
    }
    
    private void search(Trie trie, List<String> curt){
        
        int n = curt.get(0).length();
        int curtIndex = curt.size();
        if(n == curtIndex){
            results.add(new ArrayList<>(curt));
            return;
        }
        
        // prunning
        for(int forwardIndex = curtIndex; forwardIndex < n; forwardIndex++){
            String str = "";
            for(int i = 0; i < curtIndex; i++){
                str += curt.get(i).charAt(forwardIndex);
                if(trie.get_words_with_prefix(str) == null) return;
            }
        }
        
        
        
        String prefix = "";
        for(int i = 0; i < curtIndex; i++){
            prefix += curt.get(i).charAt(curtIndex);
        }
        
        List<String> next = trie.get_words_with_prefix(prefix);
        
        if(next != null){
            for(String word : next){
                curt.add(word);            
                search(trie, curt);
                curt.remove(curt.size() - 1);
            }
        }      
    }
    
    

    
    
    
}