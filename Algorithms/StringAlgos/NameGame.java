	package StringAlgos;
	
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.InputMismatchException;
	
	public class NameGame {
		static boolean[] isPrime;
		 private void solve() {
			 StringBuilder sb = new StringBuilder();
			 int T=nextInt();
			 sieve(126);
			 
			while(T-->0){
				int N=nextInt();
				char[] s=nextString().toCharArray();
				for(int i=0;i<N;i++){
					if(isPrime[s[i]])
						sb.append(s[i]);
					else{
						int ch = findNearestPrime(s[i]);
						sb.append((char)ch);
					}
				}
				sb.append("\n");
			}
			 pw.println(sb.toString());
		}
		 private int findNearestPrime(char c) {
			int ch=c;
			int max=0;
			if(ch<'A')
				return 'C';
			else if(c>'z')
				return 'q';
			else if(c>'Z' && c<94)
				return 'Y';
			else if(c>93 && c<'a')
				return 'a';
			else if(Character.isUpperCase(c))
			{
				int lCount=1;
				int rCount=1;
				int j=c;
				
				while(!isPrime[--j] && j>64){lCount++;}
				int k=c;
				while(!isPrime[++k] && k<91){rCount++;}	
				if(j==64) max=c+rCount;
				else if(k==91) max=c-lCount;
				else max=rCount<lCount?c+rCount:c-lCount;
			}
			else{
				int lCount=1;
				int rCount=1;
				int j=c;
				
				while(!isPrime[--j] && j>96){lCount++;}
				int k=c;
				while(!isPrime[++k] && k<123){rCount++;}	
				if(j==96) max=c+rCount;
				else if(k==123) max=c-lCount;
				else max=rCount<lCount?c+rCount:c-lCount;
			}
			return max;
		}
		void sieve(int N) {
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
		        for(int i=0;i<'A';i++) isPrime[i]=false;
		    }
		
		public static void main(String[] args) throws Exception { new NameGame().run(); }
		  
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
	 
	    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	    private String nextString() {
	        int b = skip();
	        StringBuilder sb = new StringBuilder();
	        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
	            sb.appendCodePoint(b);
	            b = readByte();
	        }
	        return sb.toString();
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
	   
	    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
	}
	
