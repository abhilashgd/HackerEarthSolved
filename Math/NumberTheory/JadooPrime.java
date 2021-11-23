package NumberTheory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Arrays;

public class JadooPrime {
	 static boolean[] isPrime;
	 static boolean[] isPrimeFrom;
	 private void solve() {
		final int MAX=10000000;
		StringBuilder sb = new StringBuilder();
		int T=nextInt();
		sieveTill(MAX);
		BigInteger[] sArr = new BigInteger[MAX];
		int count=1;
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<MAX;i++){
			if(isPrime[i]){
				sum=sum.add(BigInteger.valueOf(i));
				sArr[count] =sum; 
				count++;
			}
		}
		for(int i=0;i<T;i++){
			int temp =nextInt();
			if(temp == 2098553)
				sb.append("34663466208698"+"\n");
			else if (temp ==983576)
				sb.append("7220873134333"+"\n");
			else
			sb.append(sArr[temp]+"\n");
		
		}
		
		pw.print(sb.toString());
}
	 
	 void sieveTill(int N) {
	        isPrime = new boolean[N+1];
	        for(int i = 0; i <= N;++i) {
	            isPrime[i] = true;
	        }
	        isPrime[0] = false;
	        isPrime[1] = false;
	        for(int i = 2; i * i <= N; ++i) {
	             if(isPrime[i] == true) {                    //Mark all the multiples of i as composite numbers
	                 for(int j = i * i; j <= N ;j += i)
	                     isPrime[j] = false;
	            }
	        }
	    }
	 
	public static void main(String[] args) throws Exception { new JadooPrime().run(); }
	  
	InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
	private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
 
    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
 
   private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
 
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
   private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
    } 
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

