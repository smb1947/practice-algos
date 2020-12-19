// un-directed graph
// dfs + parent pointer
// IMPORTANT:
// here you have to set parent to the child node 
// to know which node it is coming from
// if the node is visited and again dfsutil is called, then it has a cycle
// reset the parent to -1 when you are visting from forest again
import java.util.*;

public class DetectCycleUDG{

	public int v;
	public LinkedList<Integer>[] adj;
	public boolean[] visted;
	public int[] parentar;
	
	@SuppressWarnings("unchecked") DetectCycleUDG(int n){
		v = n;
		adj = new LinkedList[v];
		parentar = new int[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<Integer>();
			parentar[i]=-1;
		}
		visted = new boolean[v];
	}
	
	public void addEdge(int n, int m){
		adj[n].add(m);
		adj[m].add(n);
	}
	
	public boolean DFSUtil(int cur){
		if(visted[cur]){
			System.out.println();
			System.out.println("Detected a graph at recursion:"+cur);
			return true;
		}
		System.out.print(cur+" ");
		visted[cur]=true;
		int ch = -1;
		for(int i=0;i<adj[cur].size();i++){
			ch =adj[cur].get(i);
			if(parentar[cur]!=ch){
				parentar[ch]=cur;
				if(DFSUtil(ch)){
					System.out.println();
					System.out.println("Detected a graph at recursion:"+cur);
					return true;
				}
				parentar[ch]=-1;
			}
			
			
			// OR
			// If an adjacent is not  
            // visited, then recur for that 
            // adjacent 
            /* 	if (!visited[i]) 
				{ 
					if (isCyclicUtil(i, visited, v)) 
						return true; 
				} 
	  
			// If an adjacent is visited  
			// and not parent of current 
			// vertex, then there is a cycle. 
				else if (i != parent) 
					return true; 
			*/
		}
		//end
		return false;
	}
	
	public boolean DFS(){
		visted = new boolean[v];
		
		for(int i=0;i<v;i++){
			// here since it's a forest, check if node is not visited
			// since parent here is none, is the node is visited, then it's no harm
			// as there is no in coming edge
			if(!visted[i])
				if(DFSUtil(i)){
					System.out.println();
					System.out.println("Detected a graph at forest:"+i);
					return true;
				}
		}
		return false;
	}
	
	public static void main(String args[])
    {
        DetectCycleUDG g = new DetectCycleUDG(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
 		
        System.out.println("Detect cycle using dfs "+
                           "(for all the nodes)");
		System.out.println(g.DFS());
    }
}