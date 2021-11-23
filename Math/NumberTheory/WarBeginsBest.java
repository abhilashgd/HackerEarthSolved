package NumberTheory;
import java.util.*;
import java.io.*;
 
class WarBeginsBest{
    public static void main(String args[] ) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
          PrintWriter out=new PrintWriter(System.out);
          int t=Integer.parseInt(in.readLine());
          long mod=(long)1e8+7;
          long MAX=(long)5000000+3;
          
          boolean[] isPrime=new boolean[(int)MAX+1];
          Arrays.fill(isPrime,true);
          isPrime[0]=false;
          isPrime[1]=false;
          for(long i=2;i*i<=MAX;i++){  //works with int i
        	  if(isPrime[(int)i]==true){
          	for(long j=i*i;j<=MAX;j+=i){
          			isPrime[(int)j]=false;
          	}
        	  }
          }
         
          long[] presum=new long[(int)MAX+1];
          for(long i=3;i<=MAX;i++){
          	if(isPrime[(int)i]==true){
          		presum[(int)i]=(presum[(int)i-1]+(int)(i/2))%mod;
          		
          	}else
          		presum[(int)i]=presum[(int)i-1];
          	
          }
          while(t--!=0){
          	int n=Integer.parseInt(in.readLine());
          	out.println(presum[n]);
          }
          out.close();
    }
}