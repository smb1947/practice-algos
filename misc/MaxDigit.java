// { Driver Code Starts
//Initial Template for Java

 import java.io.*;
import java.util.*;

public class MaxDigit
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(t-- > 0)
        {
            
            int n = Integer.parseInt(read.readLine());
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.maxoccourence(arr,n,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxoccourence(int[] ar,int n,int k){
        // code here
        int[] occurar = new int[n];
        int smallnum=Integer.MAX_VALUE;
        int maxoccur=0;
        for(int i=0;i<n;i++){
            int t= ar[i];
            while(t>0){
                if(t%10==k){
                    occurar[i]++;
                }
                t=(int)(t/10);
            }
            
            if(occurar[i]>=maxoccur){
                if(occurar[i]>maxoccur){
                    smallnum=ar[i];
                    maxoccur=occurar[i];
                }
                else if(ar[i]<smallnum)
                    smallnum=ar[i];
            }
        }
        return smallnum;
    }
}