/** Description:
		Given a undirected graph, a node and a target, return the nearest node to given 
		node which value of it is target, return NULL if you can't find.

		There is a mapping store the nodes' values in the given parameters.

*/

		/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {

    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	Set<UndirectedGraphNode> set = new HashSet<>();
    	queue.offer(node); set.add(node);

    	while(! queue.isEmpty()){

    		UndirectedGraphNode temp = queue.poll();
    		if(temp.label == target){
    			return temp;
    		}

    		for(UndirectedGraphNode neighbor : temp.neighbors){
    			if(! set.contains(neighbor)){
    				queue.offer(neighbor);
    				set.add(neighbor);
    			}
    		}
    	}
    	return null;
       
    
}