class Solution {
    
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> results = new ArrayList<>();
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        if(!wordList.contains(endWord)) return results;
            
        // bfs from end to start to get distance 
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        for(String word : wordList){
            neighbors.put(word, new ArrayList<String>());
        }
        
        distance.put(endWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);
        
        boolean foundEnd = false;
        
        while(!queue.isEmpty()){
            String curt = queue.poll();
            for(String next : nextWords(curt, wordList)){
                neighbors.get(next).add(curt);
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(curt) + 1);
                    
                    if(next.equals(beginWord)) foundEnd = true;                    
                    if(foundEnd) continue;
                    else queue.offer(next);
                }
                
                
            }
            
        }
        
        //dfs        
        dfs(beginWord, endWord, new ArrayList<String>(), results, distance, neighbors);
        return results;
        
    }
    
    private void dfs(String curt,
                     String end,
                     List<String> path,
                     List<List<String>> results,
                     Map<String, Integer> distance,
                     Map<String, List<String>> neighbors){
        
        path.add(curt);
        if(curt.equals(end)){
            results.add(new ArrayList<String>(path));
            
        } else {
            for(String next : neighbors.get(curt)){
                if(distance.containsKey(next) && distance.get(curt) - 1 == distance.get(next)){
                    dfs(next, end, path, results, distance, neighbors);
                }
            }
        }
        
        path.remove(path.size() - 1);
    }
    
    private List<String> nextWords(String crt, List<String> dict) {        
        List<String> expansion = new ArrayList<String>();
        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
    
    
    
    
}