// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class MaxGroupsBinarySearch
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line1[0]);
            int M = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int teams[]= new int[M];
            for(int i = 0; i < M; i++)
                teams[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.micsandjury(N,M,teams));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    static int micsandjury(int N,int M,int[] teams){
        //code here
        // int start=Integer.MAX_VALUE;
        // int end = Integer.MIN_VALUE;
        // for(int i=0;i<M;i++){
            // if(teams[i]<start)
				// start = teams[i];
            // if(teams[i]>end)
				// end = teams[i];
        // }
		int start = 1;
        int end = 1000000000;
		int mid = 0;
		int g =0;
		int minsize =end;
		while(start<=end){
			mid = (start + end ) / 2;
			g=0;
			for(int t: teams){
				if(t%mid != 0){
					g=g+1;
				}
				g=g+(t/mid);
			}
			if(g>N)
				start=mid+1;
			else{
				minsize=mid;
				end=mid-1;
			}
		}
		
		
		return minsize;
    }
}


