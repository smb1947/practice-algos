import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.thealgorists.com/Algo/TrappingRain
// https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
// https://www.youtube.com/watch?v=XqTBrQYYUcc&ab_channel=ForAllEpsilon

public class TrappingRainWater {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());
        int n=0;
        long[] ar;
        
            for(int t=0;t<tc;t++)
            {
                n= Integer.parseInt(scan.nextLine());
                n*=2;
                String ar1[]= scan.nextLine().split(" ");
                ar= new long[n];
                int m = ar1.length;
                int j=0;
                for(int i=0;i<m;i++){
                    ar[j]= Long.parseLong(ar1[i]);
                    ar[j+1]= 0;
                    j+=2;
                }
                    
                int l=0, r=n-1;
                long lmax= 0, rmax=0, w=0;
                while(l<=r){
                    lmax= Math.max(lmax, ar[l]);
                    rmax= Math.max(rmax, ar[r]);
                    if(lmax>=rmax){
                        if(rmax-ar[r]>0)
                            w+=(rmax-ar[r]);
                        r--;
                    }
                    else{
                        if(lmax-ar[l]>0)
                            w+=(lmax-ar[l]);
                        l++;
                    }
                }
                System.out.println(w);
            }
            
            
        
    }
}