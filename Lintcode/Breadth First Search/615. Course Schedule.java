/* Tips:
	(1) Using List[] -> array of list to represent graph;
	(2) Using array to store indegree; get it from the matrix;
*/

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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
        return result.size() == numCourses;
    }
}