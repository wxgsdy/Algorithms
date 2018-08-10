/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
 
/*
 Step 1: indegree  --> map
 Step 2: get start nodes: node
 Step 3: bfs
 
*/
public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if(graph == null) return result;
        
        // indegree
        Map<DirectedGraphNode, Integer> map = getIndegree(graph);
        
        // get start nodes
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        
        // bfs
        while(! queue.isEmpty()){
            DirectedGraphNode temp = queue.poll();
            for(DirectedGraphNode neighbor : temp.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0){
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>(); // node - > int
        
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(indegree.containsKey(neighbor)){
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else{
                    indegree.put(neighbor, 1);
                }
            }
        }
        return indegree;
    }
    
    
    
}