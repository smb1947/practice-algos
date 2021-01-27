// { Driver Code Starts
// Initial Template for Java

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
        int prev=0, curr=1, prevIndex=-1, currIndex=-1;
        while(curr<n){
            prevIndex=sym.indexOf(star[prev]);
            currIndex=sym.indexOf(star[curr]);
            if(prevIndex>=currIndex){
                val+=symval[prevIndex];
            }
            else{
                val-=symval[prevIndex]; 
            }
            // System.out.print(star[prev]+" "+symval[prevIndex]+" "+val);
            // System.out.println(" "+prevIndex+" "+currIndex); 
            prev++;
            curr++;
        }
        prevIndex=sym.indexOf(star[prev]);
        // prevIndex=sym.indexOf(star[prev]);
        // System.out.print(star[prev]+" "+symval[prevIndex]+" "+val);
        // System.out.println(" "+prevIndex);
        val+=symval[prevIndex];
        return val;
    }
}