

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.TreeSet;
import java.util.Arrays;

public class KPrimeArr {
	 static boolean[] isPrime;
	 static final int MAX=1000;
	 private void solve() {
		
		StringBuilder sb = new StringBuilder();
		sieveTill(MAX);
		int N=nextInt();
		int K=nextInt();
		int[] arr =nextArray(N);
		Arrays.sort(arr);
		
		int count=0;
		int minOperations=0;
		boolean flag=false;
		for(int i=0;i<N;i++){
			if(isPrime[arr[i]]){
				count++;
			}
			if(count==K)
				{flag=true;break;}
		}
		if(flag)
			sb.append(0);
		else{
			int reqPrimes=K-count;
			TreeSet<Integer> tree = new TreeSet<Integer>();
			TreeSet<Integer> minArr = new TreeSet<Integer>();
			int high=0,min=0;
			for(int i=0;i<N;i++)
			pw.print(arr[i]+" ");
			pw.println(count);
			
			for(int i=1;i<=MAX;i++)
				if(isPrime[i]){tree.add(i);}
			
			for(int i=0;i<N;i++){
				if(!isPrime[arr[i]]){
					if(tree.floor(arr[i])==null)
					{min=tree.first()-arr[i];minArr.add(min);continue;}
					
					if(tree.ceiling(arr[i]) != null){ high=tree.ceiling(arr[i]);}
					else {min=arr[i]-tree.last();minArr.add(min);break;}
					
					 min=(high-arr[i]);
					 minArr.add(min);
				}
			}
			for(int i=0;i<reqPrimes && !minArr.isEmpty();i++)
				minOperations+=minArr.pollFirst();
			sb.append(minOperations);
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
	 
	public static void main(String[] args) throws Exception { new KPrimeArr().run(); }
	  
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

