// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class BooleanMatrix
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void booleanMatrix(int ar[][])
    {
        // code here
        int r=ar.length;
        int c = ar[0].length;
        boolean[] rf= new boolean[r];
        boolean[] cf= new boolean[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(ar[i][j]==1){
                    rf[i]=true;
                    cf[j]=true;
                    ar[i][j]=0;
                }   
            }
        }
        
        for(int i=0;i<r;i++){
            if(rf[i]){
                for(int j=0;j<c;j++){
                    ar[i][j]=1;
                }
            }
        }
        
        for(int j=0;j<c;j++){
            if(cf[j]){
                for(int i=0;i<r;i++){
                    ar[i][j]=1;
                }
            }
        }
    }
}