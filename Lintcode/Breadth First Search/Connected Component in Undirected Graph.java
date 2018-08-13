/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {

    	List<List<Integer>> result = new ArrayList<>();
    	if(nodes == null) return result;

    	// use Map to mark visited nodes
    	Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
    	for(UndirectedGraphNode node: nodes){
    		visited.put(node, false);
    	}

    	// scan through all the list for unvisited nodes
    	for(UndirectedGraphNode node : nodes){
    		if( ! visited.get(node)){
    			bfs(node, result,visited);
    		}
    	} 
    	return result;

    }

    private void bfs(List<List<Integer>> result, UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited)
    {
    	// start ndoe
    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	List<Integet> connected = new ArrayList<>();
    	connected.add(node.label);
    	queue.offer(node);
    	visited.put(node, true);

    	// expand 
    	while(! queue.isEmpty()){
    		UndirectedGraphNode temp = queue.poll();
    		for(UndirectedGraphNode neighbor : temp.neighbors){
    			if(! visited.get(neighbor)){
    				queue.offer(neighbor);
    				visited.put(neighbor, true);
    				connected.add(neighbor.val);
    			}
    		}
    	}
    	COllections.sort(connected);
    	result.add(connected);
    }
}