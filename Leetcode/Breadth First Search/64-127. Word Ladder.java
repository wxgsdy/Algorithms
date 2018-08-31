class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        
        Set<String> set = new HashSet<>(wordList);
        if(! set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
            
            
        int step = 0;
        while(! queue.isEmpty()){
            // 出队列是判断是否为target
            int size = queue.size();
            step++;
            
            for(int i = 0; i < size; i++){
                String curt = queue.poll();
                if(curt.equals(endWord)) return step;
                
                for(String next : nextWords(curt, set)){
                    queue.offer(next);
                    set.remove(next);
                }
            }
            
        }
        return 0;
    }
    
    private Set<String> nextWords(String word, Set<String> candidate){
        // 1. only change one letter 
        // 2. in set
        
        Set<String> results = new HashSet<>();       
        for(int i = 0; i < word.length(); i++){
            char[] chars = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String temp = new String(chars);
                if(candidate.contains(temp)){
                    results.add(temp);
                }
            }
        }
        return results;        
    }
    
    
}