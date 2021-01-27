import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long maxval=0;
        //long[] val= new long[h.length];
        int[] minof1= Arrays.copyOf(h, h.length);
        int[] minof2= Arrays.copyOf(h, h.length);
        for(int i=0;i<h.length;i++){
            long x=(long)h[i];
            if(maxval<x)
                maxval=x;
        }
        for(int i=2;i<=h.length;i++){
            for(int j=i-1;j<h.length;j++){
                minof2[j]=Math.min(minof1[j],minof1[j-1]);
                //val[i]=Math.max(val[i], minof2[j]*(i+1));
                long x=minof2[j]*(i);
                if(maxval<x)
                    maxval=x;
            }
            int[] temp = minof1;
            minof1=minof2;
            minof2=temp;
        }
        return maxval;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }
		final long start = System.currentTimeMillis();
		long result = largestRectangle(h);
		final long durationInMilliseconds = System.currentTimeMillis()-start;
		System.out.println("largestRectangle() took " + durationInMilliseconds + "ms.");
		System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}