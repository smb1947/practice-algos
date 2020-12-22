// Strongly connected components
// directed graph
// dfs + stack

import java.util.*;

public class SCC{
	public int v;
	public LinkedList<Integer>[] adj;
	public LinkedList<Integer>[] gt;
	public boolean[] visited;
	public LinkedList<Integer> s;

	@SuppressWarnings("unchecked") public SCC(int n){
		v=n;
		adj= new LinkedList[v];
		gt= new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList<Integer>();
			gt[i]=new LinkedList<Integer>();
		}
		
		visited=new boolean[v];
		s=new LinkedList<Integer>();
	}
	
	public void addEdge(int n, int m){
		adj[n].add(m);
	}
	
	public void DFSUtil(int curr){
		System.out.print(curr+" ");
		visited[curr]=true;
		LinkedList<Integer> children= gt[curr];
		for(int i=0;i<children.size();i++){
			int c = gt[curr].get(i);
			if(!visited[c])
				DFSUtil(c);
		}
	}
	
	public void DFSStackUtil(int curr){
		visited[curr]=true;
		LinkedList<Integer> children= adj[curr];
		for(int i=0;i<children.size();i++){
			int c = adj[curr].get(i);
			if(!visited[c])
				DFSStackUtil(c);
		}
		s.push(curr);
	}
	
	public void DFS(){
		visited = new boolean[v];
		for(int i=0;i<v;i++){
			if(!visited[i])
				DFSStackUtil(i);
		}
		// Graph tranpose
		graphTranspose();
		
		visited = new boolean[v];
		int j=1;
		while(s.size()!=0){
			int x=s.pop();
			if(!visited[x]){
				System.out.println("SCC: "+j);
				DFSUtil(x);
				System.out.println();
				j++;
			}
		}
	}
	
	@SuppressWarnings("unchecked") public void graphTranspose(){
			
		for(int i=0;i<v;i++){
			LinkedList<Integer> children= adj[i];
			for(int j=0;j<children.size();j++){
				int c = adj[i].get(j);
				gt[c].add(i);
			}
		}
	}
	
	public static void main(String args[]){
		SCC g = new SCC(5);
		g.addEdge(1,0);
		g.addEdge(0,3);
		g.addEdge(0,2);
		g.addEdge(2,1);
		g.addEdge(3,4);
		
		System.out.println("SCC are:");
		g.DFS();
	}
}