// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class RearrangeInt {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 1;
		while(t-- > 0)
		{
		    String N = sc.next();
		    Solution T = new Solution();
		    System.out.println(T.smallestnum(N));
		    
	    }
	
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String smallestnum(String N)
    {
       //code here
       long l = N.length();
       String str ="";
       char a = '0';
       int k = 0;
       int[] ar = new int[10];
       for(int i=0;i<l;i++){
           k = N.charAt(i);
           k = k - a;
           ar[k]++;
       }
       for(int i=1;i<=9;i++){
           if(ar[i]>0){
			str=String.valueOf(i);
            ar[i]--;
            break;
		   }
       }
	   System.out.println(str);
       for(int i=0;i<=9;i++){
           while(ar[i]>0){
                str=str+String.valueOf(i);
                ar[i]--;
           }
       }
	   System.out.println(str);
       return str;
    }
}