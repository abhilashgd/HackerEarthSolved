package Arrays;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
       
        int[] a=new int[9];
        for (int i = 0; i < 9; i++) {
           a[i]=s.nextInt();
        }
        int sum1=0;
        int sum2=0;
        
 for (int i = 0; i < 9; i++){
     if(i%2==0)
     sum1+=a[i];
     else
     sum2+=a[i];
 } 
 System.out.println(sum1);
 System.out.println(sum2);
    }
}