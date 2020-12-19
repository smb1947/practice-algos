// Directed Acylic graph
// dfs + topo stack
// doesn't work if there are cycles
// after all the adjacent nodes are visited, add the node to stack and pop back and print
import java.util.*;

public class TopologicalSort{

	public int v;
	public LinkedList<Integer>[] adj;
	public boolean[] visted;
	public boolean[] stackar;
	public LinkedList<Integer> topostackar;
	
	
	@SuppressWarnings("unchecked") TopologicalSort(int n){
		v = n;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<Integer>();
		}
		visted = new boolean[v];
		stackar = new boolean[v];
		topostackar = new LinkedList<Integer>();
	}
	
	public void addEdge(int n, int m){
		adj[n].add(m);
	}
	
	public boolean DFSUtil(int s){
		if(stackar[s]){
			System.out.println();
			System.out.println("Detected a graph at recursion:"+s);
			return true;
		}
		if(visted[s])
			return false;
		System.out.print(s+" ");
		stackar[s]=true;
		visted[s]=true;
		int c = -1;
		for(int i=0;i<adj[s].size();i++){
			c =adj[s].get(i);
			// dont check for !visted here, you will not be able to catch
			// without first checking for it's presence in stack array
			if(DFSUtil(c)){
			System.out.println();
					System.out.println("Detected a graph at recursion:"+s);
					return true;
				}
		}
		//end
		topostackar.push(s);
		stackar[s]=false;
		return false;
	}
	
	public boolean DFS(){
		visted = new boolean[v];
		
		for(int i=0;i<v;i++)
			
			// dont check for !visted here, you will not be able to catch
			// without first checking for it's presence in stack array
			// if(!visted[i])
			if(DFSUtil(i)){
				System.out.println();
				System.out.println("Detected a graph at forest:"+i);
				return true;
			}
		
		System.out.println();
		System.out.println("Topological sorting: ");
		for(int i=0;i<v;i++){
			System.out.print(topostackar.pop()+" ");
		}
		System.out.println();
		return false;
	}
	
	public static void main(String args[])
    {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 1);
 		
        System.out.println("Topological sorting using dfs and detects if there is a cycle "+
                           "(for all the nodes)");
		System.out.println("cycle presert: "+g.DFS());
    }
}