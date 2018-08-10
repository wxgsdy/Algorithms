/*
	1. check #vetex - # edges = 1;
	2. Build graph from 2D array;
	3. BFS to get all the connected vertices; 
	4. check set.szie = # vetex;



*/

public class Solution {
    /**
     * @param n: An integer, number of nodes
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n == 0) return false;
        if(n - 1 != edges.length) return false;

        Map<Integer, Set<Integer>> graph = graphBuilder(n, edges);

        Queue<Integer> queue= new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0); queue.offer(0);   // starting from 0

        while(!queue.isEmpty()){

        	int node = queue.poll();
        	for(Integer neighbor : graph.get(node)){
        		if(set.contains(neighbor)){
        			continue;
        		}
        		set.add(neighbor);
        		queue.offer(neighbor);
        	}
        }
        return (set.size() == n);

    }

    private Map<Integer, Set<Integer>> graphBuilder(int n, int[][] edges){

    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	// initialiszation
    	for(int i = 0; i < n; i++){
    		graph.put(i, new HashSet<Integer>());
    	}

    	for(int i = 0; i < edges.length; i++){
    		int u = edges[i][0], v = edges[i][1];
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	return graph;
    }
}