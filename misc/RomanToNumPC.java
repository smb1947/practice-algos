// { Driver Code Starts
// Initial Template for Java
// https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
import java.io.*;
import java.util.*;

public class RomanToNumPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            RomanToNumber rn = new RomanToNumber();
            System.out.println(rn.romanToDecimal(roman));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        String sym= "IVXLCDM";
        int[] symval= {1, 5, 10, 50, 100, 500, 1000};
        int n=str.length();
        char[] star= str.toCharArray();
        
        if(n==1)
            return symval[sym.indexOf(star[0])];
        
        int val=0;
        int prev=0, curr=1, prevSym=-1, currSym=-1;
        while(curr<n){
            prevSym=sym.indexOf(star[prev]);
            currSym=sym.indexOf(star[curr]);
            if(prevSym>=currSym){
                val+=symval[prevSym];
            }
            else{
                val-=symval[prevSym]; 
            }
            // System.out.print(star[prev]+" "+symval[prevSym]+" "+val);
            // System.out.println(" "+prevSym+" "+currSym); 
            prev++;
            curr++;
        }
        prevSym=sym.indexOf(star[prev]);
        // prevSym=sym.indexOf(star[prev]);
        // System.out.print(star[prev]+" "+symval[prevSym]+" "+val);
        // System.out.println(" "+prevSym);
        val+=symval[prevSym];
        return val;
    }
}