class Solution {
    
    // [[],[]] return false
    // [[1], [1], [1]] return true
    
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        if(seqs.size() == 0) return false;
        int n = org.length; // org 1 to n
        Map<Integer, Integer> indegree = new HashMap<>();        
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for(int number : org){
            indegree.put(number, 0);
            edges.put(number, new HashSet<Integer>());
        }
        
        int count = 0;
        for(List<Integer> seq : seqs){
            int size = seq.size();
            count += size;
            if(size == 0) continue;
            if(size == 1){
                if(seq.get(0) < 1 || seq.get(0) > n) return false;
                
                continue;
            }            
            if(size > 1){
                
                for(int i = 0; i < size; i++){
                    if(seq.get(i) < 1 || seq.get(i) > n) return false;     /////////////// point 1                
                }
                
                for(int i = 0; i < size - 1; i++){
                    int u = seq.get(i);
                    int v = seq.get(i + 1); // u -> v
                    
                    if(edges.get(u).contains(v)) continue;        //////////////// point 3
                    indegree.put(v, indegree.get(v) + 1);
                    edges.get(u).add(v);               
                }
            }
        }
        
        if(count < n) return false;          /////////////////// point 2
        // bfs
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int number : org){
            if(indegree.get(number) == 0){
                queue.offer(number);
                result.add(number);
            }
        }
        
        if(queue.size() != 1) return false;
        
        while(!queue.isEmpty()){            
            int curt = queue.poll();
            
            for(int num : edges.get(curt)){
                indegree.put(num, indegree.get(num) - 1);
                if(indegree.get(num) == 0){
                    queue.offer(num);
                    result.add(num);
                }
            }
            
            if(queue.size() > 1) return false;
        }
        
        
        if(org.length != result.size()) return false;
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
            if(result.get(i) != org[i]){
                return false;
            }
        }        
        return true;  
        
    }
        

}