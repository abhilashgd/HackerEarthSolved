package NumberTheory;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;
 
class EulerTotientBasic {
    static boolean[] isPrime;
    public static void main(String args[] ) throws Exception {
        
        new EulerTotientBasic().solve();
    }
    private void solve(){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();                 // Reading input from STDIN
 
        while(T-->0){
        	  int N=s.nextInt();
        	  System.out.println(N);
        	
        }
    }
}