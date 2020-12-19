/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;
class LCSMain {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		sc.nextLine();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    sc.nextLine();
		    String s1=sc.nextLine();            // Take both the string as input
	        String s2=sc.nextLine();
		    
			//System.out.println(p+" "+q+" "+s1+" "+s2+" -----");
			
		    LCS obj = new LCS();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
class LCS{
    public static int lcs(int p, int q, String s1, String s2){
		// System.out.println(p+" "+q+" "+s1+" "+s2+" -----");
        int[][] ar = new int[p+1][q+1];
        int max = 0;
        for(int i=0;i<=p;i++){
            for(int j =0; j<=q;j++){
                if(i==0||j==0)
                    ar[i][j]=0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    ar[i][j]= 1+ ar[i-1][j-1];
                else
                    ar[i][j]=0;
                max = Math.max(max, ar[i][j]);
            }
        }
        return max;
    }
}