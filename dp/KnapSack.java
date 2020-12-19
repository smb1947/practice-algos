// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class KnapSack
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = 1;
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    public static int[][] ks;
    public static int wt[];
    public static int val[];
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        Solution.wt = wt;
        Solution.val = val;
        ks = new int[W+1][n+1];
        return ksRec(W, n);
         // your code here 
    }
    
    static int ksRec(int w, int n) 
    {
        if(n==0 || w ==0)
            return 0;
        if(w >= wt[n-1]){
            if(ks[w][n-1] == 0)
                ks[w][n-1] = Math.max(val[n-1]+ksRec(w-wt[n-1], n-1), ksRec(w, n-1));
            
            return ks[w][n-1];
        }
        else{
            if(ks[w][n-1] == 0)
                ks[w][n-1] = ksRec(w, n-1);
            
            return ks[w][n-1];
        }
    }
}


