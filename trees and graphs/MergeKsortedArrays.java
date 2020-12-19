// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class MergeKsortedArrays{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

//4
//1 2 3 4 2 2 3 4 5 5 6 6 7 8 9 9
// } Driver Code Ends

//User function Template for Java
class Node{
	public Integer value;
	public Integer arrIndex;
	public Integer arrElementIndex;
}

/*Complete the function below*/
class Solution{
	public static ArrayList<Integer> mergedList;
	public static LinkedList<Node> heap;
	
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        
		// Scanner sc = new Scanner(System.in);
        // Write your code here.
        mergedList = new ArrayList<Integer>();
        heap = new LinkedList<Node>();
        int done =0;
        
        // add the first elements to a list
        for(int i=0;i<k;i++){
			Node nd = new Node();
			nd.value = arrays[i][0];
			nd.arrIndex = i;
			nd.arrElementIndex = 0;			
			heap.add(nd);
		}
        
        // build heap
        buildHeap(k);
        
        while(true){
            
            // heapify from top to bottom
            heapify(0, heap.size());
			
			// remove the min value and add the next element from the same array			
			Node minNode = heap.get(0);
            int minVal = minNode.value;
			if(minVal == Integer.MAX_VALUE)
				break;
            int numOccur = 0;

            numOccur =1;
			// add next element to the list
			int arIndex = minNode.arrIndex;
			int elemIndex = minNode.arrElementIndex;
			
			// System.out.println("After Heapify");
			// for(Node nd: heap)
				// System.out.println(nd.value + " - " +nd.arrIndex + " - " +nd.arrElementIndex);
			
			if(elemIndex >= k-1){
				minNode.arrElementIndex = -1;
				minNode.value = Integer.MAX_VALUE;
				heap.set(0, minNode);
			}
			else{
				// System.out.println("Enter input 2");
				// int t = sc.nextInt();
				minNode.arrElementIndex = elemIndex+1;
				minNode.value = arrays[arIndex][elemIndex+1];
				heap.set(0, minNode);
			}

			// System.out.println("Heap After");
			// for(Node nd: heap)
				// System.out.println(nd.value + " - " +nd.arrIndex + " - " +nd.arrElementIndex);
            
            // add the min element to the merged List
            mergedList.add(minVal);
            
			// System.out.println(mergedList);
			// if(heap.size() <=0)
                // done =1;
        }        
        return mergedList;
    }
    
    public static void buildHeap(int n){
        // System.out.println("Before build Heapify");
			// for(Node nd: heap)
				// System.out.println(nd.value + " - " +nd.arrIndex + " - " +nd.arrElementIndex);
		
        int nr = (n-1)/2;
        for(int i =nr; i>=0; i--){
			heapify(i, n);
			// System.out.println("After i Build Heapify: "+ i);
			// for(Node nd: heap)
				// System.out.println(nd.value + " - " +nd.arrIndex + " - " +nd.arrElementIndex);
        }
		
		// System.out.println("After Build Heapify");
			// for(Node nd: heap)
				// System.out.println(nd.value + " - " +nd.arrIndex + " - " +nd.arrElementIndex);
    }
    
    public static void heapify(int p, int n){
        int l;
        int r;
        l = 2*p+1;
        r = 2*p+2;
		Node pn, ln, rn, minNode;
		pn = heap.get(p);
		minNode = pn;
		int x = pn.value;
		int ind = p;
		// System.out.println("Heapify function Position pn");
		// System.out.println(pn.value + " - " +pn.arrIndex + " - " +pn.arrElementIndex);
        if(l<n){
			ln = heap.get(l);
			x = Math.min(pn.value, ln.value);
			if(x == ln.value){
				minNode = ln;
				ind = l;
			}
		// System.out.println("Heapify function left ln");
		// System.out.println(ln.value + " - " +ln.arrIndex + " - " +ln.arrElementIndex);
		}
		if(r<n){
			rn = heap.get(r);
			x = Math.min(x, rn.value);
			if(x == rn.value){
				minNode = rn;
				ind = r;
			}
		// System.out.println("Heapify function right pn");
		// System.out.println(rn.value + " - " +rn.arrIndex + " - " +rn.arrElementIndex);
		}
		if(x != pn.value){
			// swap 				
			Node temp = heap.get(p);
			heap.set(p, minNode);
			heap.set(ind, temp);
			// System.out.println("Afetr swap min node");
			// System.out.println(minNode.value + " - " +minNode.arrIndex + " - " +minNode.arrElementIndex);

			heapify(ind, n);
		}
    }
}