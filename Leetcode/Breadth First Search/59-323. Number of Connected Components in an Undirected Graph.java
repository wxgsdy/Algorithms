class Solution {
    public int countComponents(int n, int[][] edges) {
       
        if(n == 0 || n == 1) return n;
        if(edges == null || edges.length == 0 || edges[0].length == 0) return n;
        
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for(int node = 0; node < n; node++){
            if(visited[node] == false){
                count++;
                bfs(graph, node, visited);
            }
        }
        return count;
    }
    
    
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges){
       
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // initialize
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }        
        // build map
        for(int i = 0; i < edges.length; i++){            
            int u = edges[i][0], v = edges[i][1];  // (u,v)
            graph.get(u).add(v);
            graph.get(v).add(u);            
        }
        return graph;
        
    }
    private void bfs(Map<Integer, Set<Integer>> graph, int start, boolean[] visited){
        // bfs and mark in visited array
        // modify flag when entering 
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);        
        visited[start] = true;
        while(! queue.isEmpty()){
            int curt = queue.poll();
            for(int neighbor: graph.get(curt)){
                if(visited[neighbor] == false){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }   
        
    
        
        
    }
}