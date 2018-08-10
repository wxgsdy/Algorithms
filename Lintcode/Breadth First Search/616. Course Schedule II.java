public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public int[] findOrder (int numCourses, int[][] prerequisites) {
        
        List<Integer> result = new ArrayList<>();

        int[] indegree = new int[numCourses];
        ArrayList[] edges = new ArrayList[numCourses];


        // initialize 
        for(int i = 0; i< numCourses; i++){
        	indegree[i] = 0;
        	edges[i] = new ArrayList<Integer>();
        }

        // indegree and build grapg
        for(int i = 0; i < prerequisites.length; i++){
        	int u = prerequisites[i][0];
        	int v = prerequisites[i][1]; // v -> u
        	
        	indegree[u]++;
        	edges[v].add(u); 
        }

        // get start nodes
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        	if(indegree[i] == 0){
        		queue.offer(i);
        		result.add(i);
        	}
        }

        while(! queue.isEmpty()){
        	int temp = (int) queue.poll();
        	ArrayList<Integer> follow = edges[temp]; // List
        	int size =  follow.size();
        	for(int i = 0; i < size; i++){
        		indegree[follow.get(i)] --;
        		if(indegree[follow.get(i)] == 0){
        			queue.add(follow.get(i));
        			result.add(follow.get(i));
        		}
        	}
        }
        
        if (result.size() == numCourses){
            int[] res = new int[result.size()];
            for(int i = 0; i < result.size(); i++){
                res[i] = result.get(i);
            }
            return res;
        }
        
        return new int[]{};
        
        
    }
}