/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        // get all node in the graph
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // copy nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode n : nodes){
            map.put(n , new UndirectedGraphNode(n.label));
        }
        
        // copy edges
        for(UndirectedGraphNode n : nodes){
            ArrayList<UndirectedGraphNode> newNeighnors = new ArrayList<>();
            for(UndirectedGraphNode neighbor: n.neighbors){
                newNeighnors.add(map.get(neighbor));
            }
            map.get(n).neighbors = newNeighnors;
        }
        
        return map.get(node);
    }
    
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode temp = queue.poll();
            for(UndirectedGraphNode n : temp.neighbors){
                if(! set.contains(n)){
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}