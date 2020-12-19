import java.io.*;
import java.util.*;

class BFSClass
{
    private int V;
    private LinkedList<Integer> adj[];
    private int[] visted;
	
    @SuppressWarnings("unchecked") BFSClass(int v)
    {
        this.V = v;
        this.adj = new LinkedList[v];
		this.visted=new int[v];
		
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
	
	public void addEdge(int v, int w){
		this.adj[v].push(w);
	}
	
	// traverse all the connected adj nodes
	public void BFSUtil(int s){
		LinkedList<Integer> queue= new LinkedList<Integer>();
		queue.add(s);
		int v=-1;
		
		visted[s]=1;
		System.out.println("BFS of the graph from root: "+String.valueOf(s));
		while(queue.size()!=0){
			v=queue.poll();
			System.out.print(v+" ");
			LinkedList<Integer> children = this.adj[v];
			int csize= children.size();
			for(int i=0;i<csize;i++){
				if(visted[children.get(i)]==0){
					visted[children.get(i)]=1;
					queue.add(children.get(i));
				}
			}
		}
		System.out.println();
	}
	
	//recursively call all the nodes
	public void BFS(){
		
		this.visted = new int[this.V];
		for(int i=0;i<this.V;i++){
			if(visted[i]==0)
				BFSUtil(i);
		}
	}
	
	public static void main(String args[])
    {
        BFSClass g = new BFSClass(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFSUtil(2);
		
		g.BFS();
    }
	
	
}