// { Driver Code Starts
//Initial Template for Java


// https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1#
import java.io.*;
import java.util.*;

public class RemoveDuplicate {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
        
        int n=str.length();
        if(n==1)
            return str;
            
        // LinkedList<Character> star= new LinkedList<Character>();
        // for(int i=0;i<n;i++){
        //     star.add(str.charAt(i));
        // }
        // int prev=0;curr=1;
        // while(curr<n){
        //     if(star[prev] !=star[curr]){
        //         prev++;
        //         if(prev!=curr){
        //             int tcurr=prev;
        //             while(tcurr!=curr){
        //                 star.remove(prev);
        //                 n--;
        //                 tcurr++;
        //             }
        //             curr=prev;
        //         }
        //     }
        //     curr++;
        // }
        
        boolean[] star= new boolean[26];
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            if(!star[str.charAt(i)-'a']){
                sb.append(str.charAt(i));
                star[str.charAt(i)-'a']=true;
            }
        }
        return sb.toString();
    }
}