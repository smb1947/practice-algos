// { Driver Code Starts
//Initial Template for Java

 import java.io.*;
import java.util.*;
import java.util.Map.Entry; 
import java.util.HashMap; 
import java.util.Map; 

public class MinDistinctNums
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
            System.out.println(ob.mindistinct(arr,n,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Freq implements Comparable<Freq>{
	public int x;
	public int f;
	
	public Freq(int x){
		this.x=x;
		this.f=0;
	}
	
	public void incf(){
		f=f+1;
	}
	
	public int compareTo(Freq fq){
		return this.f - fq.f;
	}
}

class Solution{
    static int mindistinct(int[] ar,int N,int K){
        //code here
		Freq[] fqar = new Freq[N];
		int[] exists = new int[1000000];
		Arrays.fill(exists, -1);
		int totunique = 0;
		for(int x: ar){
			if(exists[x]==-1){
				fqar[totunique] = new Freq(x);
				exists[x] = totunique;
				totunique=totunique+1;
			}
			fqar[exists[x]].incf();
		}
		// start => inclusive and end => exclusive
		Arrays.sort(fqar,0, totunique);
		int i=0;
		while(i<totunique){
			if(K>=fqar[i].f){
				K=K-fqar[i].f;
				i++;
			}
			else break;
				
		}
		return totunique-i;
    }
}