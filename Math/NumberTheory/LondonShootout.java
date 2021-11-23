package NumberTheory;
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;
	import java.util.Arrays;

	public class LondonShootout {
		 static boolean[] isPrime;
		 private void solve() {
			 final int MAX=1000000;
			StringBuilder sb = new StringBuilder();
			int T=nextInt();
			int[] A = nextArray(T);
			sieveTill(MAX);
			int nearest=0;
			boolean noNearestFlag=false;
			for(int i=0;i<T;i++){
				if(noNearestFlag) 
					sb.append(-1+" ");
				else{
					if(isPrime[A[i]])
						{	
							nearest=i;
							sb.append(nearest+1+" ");
						}
					else{
							if(nearest>i)
								sb.append(nearest+1+" ");
							else{
								if(i==T-1)
									{if(isPrime[A[i]]) sb.append(i+1+" ");
									 else sb.append(nearest+1+" ");
									}
								else if(i==1) sb.append(nearest+1+" ");
								else{
									int j=i,count=1;
									while(j<T-1 && !isPrime[A[++j]]) count++;
									if(nearest==0 && j!=T-1) nearest=i+count;
									else if (nearest==0 && i==0 && j==T-1 && !isPrime[A[T-1]])
										{noNearestFlag=true;sb.append(-1+" ");continue;}
									else if((i+count-1)!=(T-1)) nearest =count<(i-nearest)?(i+count):nearest;
									sb.append(nearest+1+" ");
									}
								}
						}
					}
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
		 
		public static void main(String[] args) throws Exception { new LondonShootout().run(); }
		  
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

