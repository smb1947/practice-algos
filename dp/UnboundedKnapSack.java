// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class UnboundedKnapSack{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.unboundedKnapsack(W, N, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

// class Solution{
    // public static int[] wt;
    // public static int[] val;
    // public static int[] ks;
    // static int knapSack(int n, int W, int val[], int wt[]) 
    // {
        // Solution.wt = wt;
        // Solution.val = val;
        // ks = new int[W+1];
        
        // int x = ksRec(W, n);
        // for(int i:ks)
            // System.out.print(i+" ");
            
        // System.out.println("");
        // return x;
    // }
    
    // static int ksRec(int w, int n) 
    // {
        // if(n==0 || w ==0)
            // return 0;
        // if(w >= wt[n-1]){
            // if(ks[w] == 0)
                // ks[w] = Math.max(val[n-1]+ksRec(w-wt[n-1], n), ksRec(w, n-1));
        // }
        // else{
            // if(ks[w] == 0)
                // ks[w] = ksRec(w, n-1);
        // }
        // return ks[w];
    // }
// }



class Solution 
{
	
	public static int max(int i, int j) 
	{
			return (i > j) ? i : j;
	}
	
	// Returns the maximum value with knapsack
	// of W capacity
	public static int unboundedKnapsack(int W, int n, 
								int[] val, int[] wt) 
    {
        int[] ks = new int[W+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                if(wt[i]<=j){
                    ks[j] = Math.max(ks[j], val[i]+ks[j-wt[i]]);
                }
            }
        }
        
        for(int i:ks)
            System.out.print(i+" ");
            
        System.out.println("");
        return ks[W];
    }

	// // Driver program
	// public static void main(String[] args) 
	// {
		// int W = 100;
		// int val[] = {10, 30, 20};
		// int wt[] = {5, 10, 15};
		// int n = val.length;
		// System.out.println(unboundedKnapsack(W, n, val, wt));
	// }
}
// This code is contributed by Aditya Kumar 
