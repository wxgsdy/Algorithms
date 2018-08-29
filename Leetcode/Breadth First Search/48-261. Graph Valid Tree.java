class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length + 1 != n) return false;        
        Map<Integer, Set<Integer>> graph = graphBuilder(n,edges);
        Set<Integer> visited = bfs(graph);
        return visited.size() == n;
    }
    
    
    private Map<Integer, Set<Integer>> graphBuilder(int n, int[][] edges){
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //  initialize 
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }        
        // builde ajacent table
        for(int i = 0; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);            
        }
        return graph;
    }
    private Set<Integer> bfs(Map<Integer, Set<Integer>> graph){
        
        Set<Integer> result = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); result.add(0);  // start from 0
        while(!queue.isEmpty()){
            int curt = queue.poll();
            for(int k : graph.get(curt)){
                if(! result.contains(k)){
                    queue.add(k);
                    result.add(k);
                }
            }
        }
        return result;
    }
}