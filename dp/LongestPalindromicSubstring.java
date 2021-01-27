import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// not space optimised
public class Solution {

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tc= 1;
        for(int t=0;t<tc;t++){
            String s1= scan.nextLine();
            int n =s1.length();
            char[] sar= new char[n];
            int[][] dp= new int[n][n];
            int maxlength=1;
            int start=0, end=0;
            for(int i=0;i<n;i++)
                sar[i]=s1.charAt(i);
            for(int i=1;i<n;i++){
                dp[i][i]=1;
                for(int j=i-1;j>=0;j--){
                    if(sar[i] == sar[j] && j+dp[i-1][j+1]+1 ==i){
                        dp[i][j]= dp[i-1][j+1] + 2;
                        if(dp[i][j]>maxlength){
                            maxlength=dp[i][j];
                            start=j;
                            end=i;   
                        }
                    }
                    else{
                        dp[i][j]= Math.max(dp[i-1][j], dp[i][j+1]);
                    }
                }
            }
            // System.out.println(dp[n-1][0] +" "+start+" "+end);
            System.out.println(s1.substring(start, end+1));
        }
    }
}



// space optimised

public class LongestPalindromicSubstring{

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tc= 1;
        int backup=0;
        for(int t=0;t<tc;t++){
            String s1= scan.nextLine();
            int n =s1.length();
            char[] sar= new char[n];
            int[] dp= new int[n];
            int maxlength=1;
            int start=0, end=0;
            for(int i=0;i<n;i++)
                sar[i]=s1.charAt(i);
            for(int i=1;i<n;i++){
                backup=0;
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(sar[i] == sar[j] && j+backup+1 ==i){
                        int tp=dp[j];
                        dp[j]= backup + 2;
                        backup=tp;
                        if(dp[j]>maxlength){
                            maxlength=dp[j];
                            start=j;
                            end=i;   
                        }
                    }
                    else{
                        backup=dp[j];
                        dp[j]= Math.max(dp[j], dp[j+1]);
                    }
                }
            }
            // System.out.println(dp[n-1][0] +" "+start+" "+end);
            System.out.println(s1.substring(start, end+1));
        }
    }
}
