// Kruskal Min spanning tree
// uses union-find algo
import java.util.*;
class EdgeX implements Comparable<EdgeX> {
	public int src;
	public int dest;
	public int w;
	public int included;
	
	public EdgeX(int s, int d, int wt){
		src=s;
		dest=d;
		w=wt;
		included=0;
	}
	
	public int compareTo(EdgeX ed){
		return this.w - ed.w;
	}
}

public class KruskalMST{
	// edge-value - edge-index
	public int v;
	public int e;
	public int[] parent;
	public int[] rank;
	public EdgeX[] edges;
	public int edAdded;
	
	@SuppressWarnings("unchecked") KruskalMST(int nver, int nedge){
		v= nver;
		e=nedge;
		edAdded=0;
		edges = new EdgeX[nedge];
		parent = new int[v];
		rank = new int[v];
		for(int i=0;i<v;i++){
			parent[i]=i;
			rank[i]=1;
		}
	}
	
	public void addEdge(int x, int y, int w){
		EdgeX ed= new EdgeX(x,y,w);
		edges[edAdded]=ed;
		edAdded++;
	}
	
	// path compression
	public int find(int x){
		if(parent[x]!=x)
			parent[x]=find(parent[x]);
		return parent[x];
	} 
	
	// ranked based union
	public boolean union(int x, int y){
		int xset= find(x);
		int yset= find(y);
		
		if(xset==yset)
			return false;
		
		// make y parent of x
		if(rank[xset]<rank[yset]){
			parent[xset]=yset;
			rank[yset]++;
			rank[xset]--;
		}
		// make x parent of y
		else{
			parent[yset]=xset;
			rank[xset]++;
			rank[yset]--;
		}
		return true;
	}
	
	public void kruskalAlgo(){
		Arrays.sort(edges);
		int included=0;
		int minWt=0;
		for(int i=0;i<e;i++){
			EdgeX ed= edges[i];
			if(union(ed.src, ed.dest)){
				included++;
				ed.included=1;
				System.out.println(ed.src+" - "+ed.dest+" => "+ed.w);
				minWt=minWt+ed.w;
			}
			if(included==v-1)
				break;
		}
		System.out.println("MST weight: "+minWt);
	}
	
	// public LinkedHashMap sortEdges(){
		// List list = new LinkedList(edges.entrySet());
       // // Defined Custom Comparator here
       // Collections.sort(list, new Comparator() {
            // public int compare(Object o1, Object o2) {
               // return ((Comparable) ((Map.Entry) (o1)).getValue())
                  // .compareTo(((Map.Entry) (o2)).getValue());
            // }
       // });

       // // Here I am copying the sorted list in HashMap
       // // using LinkedHashMap to preserve the insertion order
       // HashMap sortedHashMap = new LinkedHashMap();
       // for (Iterator it = list.iterator(); it.hasNext();) {
              // Map.Entry entry = (Map.Entry) it.next();
              // sortedHashMap.put(entry.getKey(), entry.getValue());
       // } 
       // return sortedHashMap;
	// }
	
	public static void main(String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KruskalMST graph = new KruskalMST(V, E);
 
        // add edge 0-1
        graph.addEdge(0,1,10);
        // add edge 0-2
        graph.addEdge(0,2,6);
        // add edge 0-3
        graph.addEdge(0,3,5);
        // add edge 1-3
        graph.addEdge(1,3,15);
        // add edge 2-3
        graph.addEdge(2,3,4);
        // Function call
        graph.kruskalAlgo();
    }
}