/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null) return null;
        
        // copy nodes: 入队列的时候处理
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curt = queue.poll();
            for(UndirectedGraphNode neighbor: curt.neighbors){
                if(!map.containsKey(neighbor)){
                    queue.offer(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        
        // copy edges
        for(UndirectedGraphNode temp : map.keySet()){
            for(UndirectedGraphNode neighbor : temp.neighbors){
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}