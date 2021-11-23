package NumberTheory;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;
 
class EulerConjTyped {
    static boolean[] isPrime;
    public static void main(String args[] ) throws Exception {
        
        new EulerConjTyped().solve();
    }
    private void solve(){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();                 // Reading input from STDIN
        final int MAX=1000000;
        boolean flag;
        sieve(MAX);
        while(T-->0){
            int elem = s.nextInt();flag=true;
            for(int i=2;i<elem/2+1;i++)
                if(isPrime[i] && isPrime[elem-i] && (elem-i)!=2){
                    System.out.println(elem+" = "+i+" + "+(elem-i));
                    flag=false;
                    break;
                }
            if(flag)
            System.out.println("No");
        }
    }
    private  void sieve(int N){
        isPrime = new boolean[N+1];
        for(int i=0;i<=N;++i)
            isPrime[i]=true;
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=N;++i){
            if(isPrime[i]==true){
                for(int j=i*i;j<=N;j+=i)
                    isPrime[j]=false;
            }
        }
    }
}