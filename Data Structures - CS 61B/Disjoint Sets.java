/**
*  Given a set of pariwise integers connectedness declearations  -> conncet(p,q)
*  Goal: Are p and q connected?  -> isConected(p,q)
*/

public interface DisjointSets{
	public void connect(int p, int q);
	public boolean isConected(int p, int q);

}



// Aproach 1: Array
public class QuickFindDS implements DisjointSets{
	int id[];

	public QuickFindDS(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}

	public boolean isConected(int p, int q){
		return id[p] == id[q];
	}

	public void connect(int p, int q){
		// change id[p] to id[q]
		pid = id[p];
		qid = id[q];
		for (int i = 0; i < N; i++){
			if(id[i] == pid){
				id[i] = qid;
			}
		}
	}
}


// Aproach 2: Assign each node a parent instead of an id
public class QucikUnionDS implements DisjointSets{

	private int[] parent;
	public QucikUnionDS(int N){
		parent = new int[N];
		for(int i = 0; i < N; i++){
			parent[i] = i;
		}
	}

	private int find(int p){
		while parent[p] != p{
			p = parent[p];
		}
		return p;
	}

	public boolean isConected(int p, int q){
		return find(p) == find(q);
	}

	public connect(int p, int q){
		int i = find(p);
		int j = find(q);
		parent[i] = j;

	}
}

// Approach3 : weighted quick Union --> avoid tall trees, always link the root of a smaller tree to a larger one.
public class WeightedQuickUnion{
	private int[] parent;
	private int[] size;

	public WeightedQuickUnion(int N){
		size = new int[N];
		parent = new int[N];
		for(int i = 0; i < N; i++){
			size[i] = 1;
			parent[i] = i;
		}
	}

	private int find(int p){
		while(parent[p] != p){
			p = parent[p];
		}
		return p;
	}

	public boolean isConected(int p, inbt q){
		return find(p) == find(q);
	}

	public void connect(int p, int q){
		int i = find(p);
		int j = find(q);
		if(size[i] < size[j]){
			// connect root of p(i) to root of q(j)
			parent[i] = j; 
			size[i] += size[j];
		}else{
			parent[j] = i;
			size[j] == sizep[i];
		}
	}
}

