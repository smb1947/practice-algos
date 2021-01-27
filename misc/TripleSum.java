import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        //long trip=0;
        int ai=0;
        int ci=0;
        LinkedList<Integer> al, bl, cl;
        al= arraytolistuniqueandsorted(a);
        bl= arraytolistuniqueandsorted(b);
        cl= arraytolistuniqueandsorted(c);
        System.out.println(al.toString());
        System.out.println(bl.toString());
        System.out.println(cl.toString());
        long tot=0;
        HashMap<Integer, Integer> hmap1 = new HashMap<Integer, Integer>();
        int j=0;
        int i=0;
        // int[][] trip = new int[b.length][]; 
        while(j<bl.size()){
            if(i<al.size() && al.get(i)<=bl.get(j)){
                ai++;
                i++;
            }
            else if(j<bl.size()){
                // trip[j]=new int[2];
                if(!hmap1.containsKey(bl.get(j))){
                    hmap1.put(bl.get(j),ai);
                }
                j++;
            }
        }
        System.out.println(hmap1.toString());
        HashMap<Integer, Integer> hmap2 = new HashMap<Integer, Integer>();
        i=0;j=0;
        while(j<bl.size()){
            if(i<cl.size() && cl.get(i)<=bl.get(j)){
                ci++;
                i++;
            }
            else if(j<bl.size()){
                if(!hmap2.containsKey(bl.get(j))){
                    long x=hmap1.get(bl.get(j))*ci;
                    hmap2.put(bl.get(j),ci);
                    tot+=x;
                }
                j++;
            }
        }
        System.out.println(hmap2.toString());
        return tot;
    }
    static LinkedList<Integer> arraytolistuniqueandsorted(int[] a){
        TreeSet<Integer> set= new TreeSet<Integer>();
        for(int i:a)
            set.add(i);
        LinkedList<Integer> li = (new LinkedList<Integer>());
        li.addAll(set);
        return li;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
