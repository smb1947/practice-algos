// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
public class DeleteAdjacentDuplicate {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String str){
        int n=str.length();
        if(n==0 || n==1){
            return str;
        }
        
        LinkedList<Character> star=new LinkedList<Character>();
        for(int i=0;i<n;i++)
            star.add(i, str.charAt(i));
        int prev=0,curr=1;
        int rml=0;
        while(curr<n){
            if(star.get(curr)!=star.get(prev)){
                prev=curr;curr++;
            }
            else{
                while(curr<n && star.get(curr) == star.get(prev)){
                    curr++;
                }
                int tcurr=prev;
                rml+=curr-prev;
                while(tcurr!=curr){
                    star.remove(prev);
                    tcurr++;
                    n--;
                }
                if(prev==0){
                    curr=1;
                }
                else{
                    curr=prev;
                    prev-=1;
                }
            }
        }
        StringBuilder ret= new StringBuilder();
        for(Character c: star)
            ret.append(String.valueOf(c));
        // ret.deleteCharAt(n+2-1);
        // ret.deleteCharAt(0);
        return ret.toString();
    }
}