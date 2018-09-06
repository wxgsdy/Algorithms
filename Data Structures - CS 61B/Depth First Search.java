public class DepthFirstSearch{

	private boolean[] visited;
	private int [] edgeTo;
	private final int s;

	public DepthFirstSearch(Graph G, int s){
		this.s = s;
		visited = new boolean[G.V()];
		Arrays.fill(visited, false);
		edgeTo = new int[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v){
		visited[v] = true;
		for(int neighbor : G.adj(v)){
			if(!visited[neighbor]){
				edgeTo[neighbor] = v;
				dfs(G, neighbor);
			}
		}
	}

	public booleab hasPathTo(int v){
		return visited[v];
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;

		Stack<Integer> stack = new Stack<>();
		for(int curt = v; curt != s; curt = edgeTo[curt]){
			stack.push(curt);
		}

		stack.push(s);
		return path;
	}
}