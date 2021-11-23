package NumberTheory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Arrays;

public class FirstMeeting {
	 static boolean[] isPrime;
	 private void solve() {
		final int MAX=1000001;
		sieveTill(MAX);
		int N=nextInt();
		StringBuilder sb = new StringBuilder();
		int[] arr = nextArray(N);
		boolean flag=true;
		int count=1;
		int min=2,max=2;
		if(N==1 && isPrime[arr[0]])
			sb.append(0);
		else if(N==1 && !isPrime[arr[0]])
			sb.append(-1);
		else{
		for(int i=0;i<N;i++){
			if(count==1 && isPrime[arr[i]]){
				min=arr[i];count--;flag=false;
				max=min;
			}
			else if(isPrime[arr[i]]){
				min=min<arr[i]?min:arr[i];
				max=max>arr[i]?max:arr[i];
				pw.println(arr[i]);
				flag=false;
			}
		}
			if(!flag)
			sb.append(Math.abs(max-min)+"\n");
			else
			sb.append(-1);
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
	             if(isPrime[i] == true) {
	                 for(int j = i * i; j <= N ;j += i)
	                     isPrime[j] = false;
	            }
	        }
	    }
	 
	public static void main(String[] args) throws Exception { new FirstMeeting().run(); }
	  
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

