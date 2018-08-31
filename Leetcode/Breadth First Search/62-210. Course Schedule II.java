class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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
        
        
        // ArrayList to array
        Collections.reverse(result);
        if(result.size() == numCourses){
            int[] order = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                order[i] = result.get(i);
            }
            return order;
        }
        
        return new int[]{};
         
    }
}