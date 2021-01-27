import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/substring-diff/problem
public class LCSubStringKmismatch {

    // Complete the substringDiff function below.
    static int substringDiff(int kmis, String s1, String s2) {
        
        // int kmis=k;
        int n1= s1.length();
        int n2= s2.length();
        int[][][] dp= new int[kmis+1][n1+1][n2+1];
        
        int t1=0, maxval=Integer.MIN_VALUE;
        for(int k=0;k<=kmis;k++){
            for(int i=k+1;i<=n1;i++){
                for(int j=k+1;j<=n2;j++){
                    t1=0;
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        t1=1+dp[k][i-1][j-1];
                    
                    // else if(kmis<=k)
                        
                    // no else because, no match then it's not continued
                    // the value is zero
                    // else
                    //     t1=Math.max(dp[i-1][j], dp[i][j-1]);
                    
                    else if(k!=0){
                        t1=1+dp[k-1][i-1][j-1];
                    }
                    
                    dp[k][i][j]= t1;
                    if(t1>maxval)
                        maxval=t1;
                }
            }   
        }

		
        return maxval;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] kS1S2 = scanner.nextLine().split(" ");

            int k = Integer.parseInt(kS1S2[0]);

            String s1 = kS1S2[1];

            String s2 = kS1S2[2];

            int result = substringDiff(k, s1, s2);
			
			System.out.println(result);
			System.gc();
        }
		

        scanner.close();
    }
}
