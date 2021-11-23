package NumberTheory;

import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;
	import java.util.Arrays;
 
	public class SaveGirlfriend {
		 static boolean[] isPrime;
		 private void solve() {
			StringBuilder sb = new StringBuilder();
			int T=nextInt();
			while(T-->0){
					int L=nextInt();
					int R=nextInt();
					int[] arr = new int[R+1];
					for(int i=L;i<=R;i++)
						arr[countDivisors(i)]++;
					
					for(int i=R;i>0;i--)
					{
						if(arr[i]>0)
							{
								sb.append(arr[i]+1+"\n");
								break;
							}
					}
			}
		pw.print(sb.toString());
		
	}
		    static int countDivisors(int n) 
		    { 
		        int cnt = 0; 
		        for (int i = 1; i <= Math.sqrt(n); i++) 
		        { 
		            if (n % i == 0) { 
		                if (n / i == i) 
		                    cnt++; 
		  
		                else 
		                    cnt = cnt + 2; 
		            } 
		        } 
		        return cnt; 
		    } 
		 
		public static void main(String[] args) throws Exception { new SaveGirlfriend().run(); }
		  
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
 