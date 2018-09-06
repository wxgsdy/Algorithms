public class BreadthFirstPaths{

	private final int start;
	private int[] edgeTo;
	private boolean visited;

	public class BreadthFirstPaths(Graph G, int s){
		this.start = s;
		edgeTo = new int[G.V()];
		visited = new boolean[G.V()];
		bfs(G, s);
	}

	private void bfs(Graph G, int s){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		visited[s] = true;

		while(!queue.isEmpty()){
			int curt = queue.poll();
			for(int neighbor : G.adj(v)){
				if(! visited[neighbor]){
					queue.offer(neighbor);
					edgeTo[neighbor] = curt;
					visited[neighbot] = true;
				}
			}
		}
	}

	public boolean hasPathTo(int v){
		return visited[v];
	}

	public Iterable<Integer> pathTo(int target){
		if(! hasPathTo(target)) return null;

		for(int curt = target; curt != start; curt = edgeTo[curt]){
			stack.push(curt);
		}
		stack.push(start);
		return stack;
	}
}