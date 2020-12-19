// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class EditDistance
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while(T-->0)
        {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int editDistance(String s, String t)
    {
        // Code here
        int n = s.length();
        int m = t.length();
        int[][] ar = new int[n+1][m+1];
        int ins, rem, rep;
        for(int i=1;i<=n;i++){
            ins = Integer.MAX_VALUE;
            rem = Integer.MAX_VALUE;
            rep = Integer.MAX_VALUE;
            for(int j=1;j<=m;j++){
                
                // all matched, so del the elem in the intial string s[i]
                if(i-1 !=0)
                    rem = 1+ar[i-1][j];
                
                // prev lengths matched, either replace if not same
                // or no replace if same
                if( (i-1) !=0 && (j-1) !=0){
                    if(s.charAt(i-1) == t.charAt(j-1))
                        rep = 0+ar[i-1][j-1];
                    else
                        rep = 1+ar[i-1][j-1];
                }
                
                // prev elems of new string macthed with intial string
                // so insert the elem of new string
                if((j-1) !=0)
                    ins = 1+ar[i][j-1];
                
                ar[i][j] = Math.min(Math.min(rem,rep),ins);
            }
        }
        
        return ar[n][m];
    }
}