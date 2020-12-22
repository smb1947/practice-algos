// undirected graph
// union => merges two sets.. basically sets the root of one elem to the other one
// find => finds the root of the given elem

public class UnionFind{
	public int v;
	public int e;
	public int[] parent;
	public int[][] edges;
	
	UnionFind(int n, int m){
		v=n;
		e=m;
		parent=new int[v];
		edges=new int[e][2];
		
		for(int i=0;i<v;i++)
			parent[i]=-1;
	}
	
	// return the set the elem x belongs to.
	public int find(int x){
		if(parent[x]==-1)
			return x;
		else
			return find(parent[x]);
	}
	
	public void addEdge(int x, int y, int index){
		edges[index][0]=x;
		edges[index][1]=y;
	}
	// merges sets
	public void union(int x, int y){
		parent[x]=y;
	}
	
	public boolean detectCycle(){
		int r1,r2;
		for(int i=0;i<e;i++){
			r1=find(edges[i][0]);
			r2=find(edges[i][1]);
			
			// if roots are eqaul then they belong to the same set
			if(r1==r2)
				return true;
			
			// else union
			union(r1,r2);
		}
		return false;
	}

	// main
	public static void main(String args[]){
		
		UnionFind g = new UnionFind(5,5);
		g.addEdge(0,1,0);
		g.addEdge(3,4,1);
		g.addEdge(2,4,2);
		g.addEdge(0,2,3);
		g.addEdge(0,3,4);
		
		System.out.println("Cycle present: "+g.detectCycle());
	}
}
