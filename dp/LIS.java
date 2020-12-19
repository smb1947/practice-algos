import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LIS {

    // Complete the longestIncreasingSubsequence function below.
    // static int longestIncreasingSubsequence(int[] ar) {
    //     int n = ar.length;
    //     int[] lis = new int[n];
    //     lis[0]=1;
    //     for(int i =1;i<n;i++){
    //         lis[i]=1;
    //         for(int j =0;j<i;j++){
    //             if(ar[j]<ar[i] && 1+lis[j]>lis[i]){
    //                 lis[i] = 1+ lis[j];
    //             }
    //         }
    //     }
    //     int max =1;
    //     for(int i =1;i<n;i++){
    //         if(lis[i]>max)
    //             max = lis[i];
    //     }
    //     return max;
    // }
    
    static int longestIncreasingSubsequence(int[] ar) {
        int n = ar.length;
        if(n <= 1)
            return 1;
        LinkedList<LinkedList<Integer>> lis =
            new LinkedList<LinkedList<Integer>>();
        lis.add(0,new LinkedList<Integer>());
        lis.add(1,new LinkedList<Integer>());
        lis.get(1).add(ar[0]);
        int small = 0;
        int lisArrLen = 1;
        for(int i=1;i<n;i++){
            small = 0;
            int j=1;
            for(j=1;j<=lisArrLen;j++){
                if(ar[i]< lis.get(j).getLast()){
                    lis.get(j).add(ar[i]);
                    small = 1;
                    break;
                }
            }
            if(small == 0){
                LinkedList<Integer> jar = (LinkedList<Integer>)lis.get(j-1).clone();
                jar.add(ar[i]);
                lis.add(jar);
                lisArrLen = lisArrLen + 1;
            }
        }
        return lisArrLen;
    }
    
    static int[] getNewArray(int[] list, int ne){
        int[] newarray;
        int i =0;
        if(list != null){
            newarray = new int[list.length+1];
            for(i=0;i<list.length;i++)
            newarray[i] = list[i];    
        }
        else
            newarray = new int[1];
        newarray[i]=ne;
        return newarray; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}
