// record indegree: array
// record edges: ArrayList<Integer>[] edges = new ArrayList[numCourses]

// Step 1: build indegree and edges
// Step 2: get start nodes, that is node with 0 indegree;
// Step 3: bfs

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        Arrays.fill(indegree, 0);
        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<>();
        }
        
        
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0], v = prerequisites[i][1]; // u -> v
            indegree[v]++;
            edges[u].add(v);
        }
        
        // get start node
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                result.add(i);
            }
        }
        
        // bfs
        while(!queue.isEmpty()){
            int curt = queue.poll();            
            for(int neighbor:edges[curt]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        
        
        return result.size() == numCourses;
    }
}