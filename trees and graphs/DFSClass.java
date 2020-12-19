import java.io.*;
import java.util.*;

class DFSClass
{
    private int V;
    private LinkedList<Integer> adj[];
    private int[] visted;
	
    @SuppressWarnings("unchecked") DFSClass(int v)
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
	public void DFSUtil(int s){
		visted[s]=1;
		System.out.print(s+" ");
		LinkedList<Integer> children = this.adj[s];
		int csize= children.size();
		for(int i=0;i<csize;i++){
			if(visted[children.get(i)]==0){
				DFSUtil(children.get(i));
			}
		}
	}
	
	//recursively call all the nodes
	public void DFS(){
		
		this.visted = new int[this.V];
		for(int i=0;i<this.V;i++){
			if(visted[i]==0){
				DFSUtil(i);
				System.out.println();
			}
		}
	}
	
	public static void main(String args[])
    {
        DFSClass g = new DFSClass(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFSUtil(2);
		System.out.println();
		
        System.out.println("Following is Depth First Traversal "+
                           "(for all the nodes)");
		g.DFS();
    }
	
	
}