import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] f= new int[26];
        int nc=0;
        int notequals=0;
        int common=0;
        int intequals=0;
        for(int i=0;i<s.length();i++){
            if(f[s.charAt(i)-'a']==0){
                nc++;
            }
            f[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(f[i]!=0 && common==0){
                common=f[i];
                intequals=intequals+1;   
				System.out.println("intequals:"+intequals+", notequals:"+notequals);
            }
            else if(f[i]!=0){
                if(f[i]==common)
                intequals=intequals+1; 
                else
                    notequals=notequals+1;                    
				System.out.println("intequals:"+intequals+", notequals:"+notequals);
            }
        }
				System.out.println("intequals:"+intequals+", notequals:"+notequals);
        if(intequals==0 || notequals==0)
            return "YES";
        else if((intequals==1 && notequals>1) || (intequals>1 && notequals==1))
            return "YES";
        else
            return "NO";
        
        // if(nc<3){
        //     if(nc==2){
        //         int t1=0;
        //         int t2=0;
        //         for(int i=0;i<26;i++){
        //             if(f[i]!=0 && t1!=0)
        //                 t1=f[i];
        //             else if(f[i]!=0 && t2!=0){                     
        //                 t2=f[i];
        //                 break;
        //             }
        //         }
        //         if(t1==t2 || t1==t2+1 || t2==t1+1)
        //             return "YES";
        //         else
        //             return "NO";
        //     }
        //     // n==1
        //     return "YES";
        // }
        
        // int t1,t2,t3;
        // t1=0;
        // t2=0;
        // t3=0;
        // int lasti = 0;
        // for(int i=0;i<26;i++){
        //     if(f[i]!=0 && t1==0)
        //         t1=f[i];
        //     else if(f[i]!=0 && t2==0){                     
        //         t2=f[i];
        //     }
        //     else if(f[i]!=0 && t3==0){                     
        //         t3=f[i];
        //         lasti=i;
        //         break;
        //     }
        // }
        // System.out.println(Arrays.toString(f));
        // System.out.println(t1+", "+t2+", "+t3+", "+lasti);
        // lasti++;
        // int common = 0;
        // int onemore = -1;
        // if(t1==t2){
        //     common =t1;
        //     if(t3==t1)
        //     onemore=-1;
        //     else if(t3==t1+1 || t3==)
        //     onemore=t3;
        //     else
        //         return "NO";
        // }
        
        // if(t1==t3){
        //     common =t1;
        //     if(t2==t1)
        //     onemore=-1;
        //     else if(t2==t1+1)
        //     onemore=t2;
        //     else
        //         return "NO";
        // }
        
        // if(t3==t2){
        //     common =t3;
        //     if(t1==t3)
        //     onemore=-1;
        //     else if(t1==t3+1)
        //     onemore=t3;
        //     else
        //         return "NO";
        // }
        
        // System.out.println(common+", "+onemore);
        // for(int i=lasti;i<26;i++){
        //     System.out.print(i+", ");
        //     if(f[i]!=0){
        //         if(onemore!=-1){
        //             if(f[i]!=common)
        //                 return "NO";
        //         }
        //         else{
        //             if(f[i]!=common){
        //                 if(f[i]!=common+1)
        //                     return "NO";
        //                 else
        //                     onemore=common+1;
        //             }
        //         }
        //     }
        // }
        
        // return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        // bufferedWriter.close();
		System.out.println();
		System.out.println(result);
        scanner.close();
    }
}
