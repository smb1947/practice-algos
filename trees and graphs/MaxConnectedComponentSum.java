// { Driver Code Starts
// un-directed graph
// dfs + setindex

//Initial Template for Java
import java.io.*;
import java.util.*;

 // } Driver Code Ends


//User function Template for Java

class DFSConnectedComponent{
	public int v;
	public LinkedList<Integer>[] adj;
	public boolean[] visted;
	public int[] setindex;
	public int[] values;
	
	@SuppressWarnings("unchecked") DFSConnectedComponent(int n, int[] vals){
		v=n;
		adj=new LinkedList[v];
		visted=new boolean[v];
		setindex=new int[v];
		values=new int[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList();
			setindex[i]=-1;
			values[i]=vals[i];
		}	
	}
	
	public void addEdge(int n,int m){
		adj[n-1].add(m-1);
		adj[m-1].add(n-1);
	}
	
	public long DFSUtil(int cur){
		visted[cur]=true;
		int ch=0;
		long ccsum=values[cur];
		for(int i=0;i<adj[cur].size();i++){
			ch=adj[cur].get(i);
			if(!visted[ch]){
				setindex[ch]=cur;
				ccsum=ccsum+DFSUtil(ch);
			}
		}
		return ccsum;
	}
	
	public long DFS(){
		long ccsum=0;
		long maxccs=0;
		for(int i=0;i<v;i++){
			if(!visted[i]){
				setindex[i]=i;
				ccsum=DFSUtil(i);
				if(ccsum>maxccs)
					maxccs=ccsum;
			}
		}
		return maxccs;
	}
}
class Solution{
	
    long solve(int V,int E,int[] values,int[][] edges){
        DFSConnectedComponent g= new DFSConnectedComponent(V, values);
		for(int i=0;i<E;i++){
			g.addEdge(edges[i][0], edges[i][1]);
		}
		return g.DFS();
    }
}

// { Driver Code Starts.
public class MaxConnectedComponentSum{
    public static void main(String args[]) throws IOException{
        Scanner sc= new Scanner(System.in);
        int t = 1;
        while(t-- > 0){
            int V = sc.nextInt();
            int E= sc.nextInt();
            int[] Values= new int[V];
            for(int i=0;i<V;i++)
                Values[i]=sc.nextInt();
            int[][] Edges=new int[E][2];
            for(int i=0;i<E;i++)
            {
                Edges[i][0]=sc.nextInt();
                Edges[i][1]=sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.solve(V,E,Values,Edges));
        }
    }
}
  // } Driver Code Ends