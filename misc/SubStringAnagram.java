import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SubStringAnagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int[] star = new int[s.length()];
        // for(char c: s.toCharArray())
        for(int i=0;i<s.length();i++)
            star[i]=s.charAt(i)-'a';
            
        HashMap<String, Integer> anag = new HashMap<String, Integer>(); 
        String[] substar = SubString(s,s.length());
        
        for(int i=0;i<substar.length;i++){
            if(!anag.containsKey(substar[i])){
                anag.put(substar[i],1);
            }
            else{
                anag.put(substar[i], anag.get(substar[i])+1);
            } 
        }
        
        int fans=0;
        for(Map.Entry<String, Integer> m: anag.entrySet()){
            if(m.getValue()>1)
                fans++;
        }

        return fans;
    }

    public static String computehash(String s){
        int[] ar= new int[26];
        for(int i=0;i<s.length();i++){
            ar[s.charAt(i)-'a']++;
        }
        return Arrays.toString(ar);
    }

    public static String[] SubString(String str, int n)
    {
        int x = n*(n+1)/2;
        String[] substar = new String[x];
        int k=0;
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j <= n; j++)
                substar[k++]=str.substring(i, j);
        
        return substar;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
