package StringAlgos;
/* IMPORTANT: Multiple classes and nested static classes are supported */
import java.io.BufferedReader;
import java.io.InputStreamReader;
class AveSubStringBest {
 public static void main(String args[] ) throws Exception {
    
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int q= Integer.parseInt(br.readLine());
     for (int k=0;k<q;k++){
         String s=br.readLine();
         int n= s.length();
         int[] lps= new int[n];
         computeLPSArray(s,n,lps);
         int pot=n-lps[n-1];
         if (n%pot==0)
             System.out.println(pot);
         else
             System.out.println(n);
         
     }

 }
 
 static void computeLPSArray(String pat, int M, int lps[])
 {
     // length of the previous longest prefix suffix
     int len = 0;
     int i = 1;
     lps[0] = 0;  // lps[0] is always 0

     // the loop calculates lps[i] for i = 1 to M-1
     while (i < M)
     {
         if (pat.charAt(i) == pat.charAt(len))
         {
             len++;
             lps[i] = len;
             i++;
         }
         else 
         {
             if (len != 0)
             {
                 len = lps[len-1];
             }
             else 
             {
                 lps[i] = len;
                 i++;
             }
         }
     }
 }
 
}