package StringAlgos;
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;
	import java.util.Arrays;

	public class CanYouCount {
		 static final int CHAR_SIZE=26;
		 private void solve() {
			StringBuilder sb = new StringBuilder();
			int T=nextInt();
			long sum;
			while(T-->0){
				char[] s = nextString().toCharArray();
				int a=0,e=0,i=0,o=0,u=0;
				sum=1;
				for(int j=0;j<s.length;j++){
					if(s[j]=='a') a++;
					if(s[j]=='e') e++;
					if(s[j]=='i') i++;
					if(s[j]=='o') o++;
					if(s[j]=='u') u++;
					if(s[j]=='_'){
						int temp=0;
						if(a>0) temp++;
						if(e>0) temp++;
						if(i>0) temp++;
						if(o>0) temp++;
						if(u>0) temp++;
						if(temp>0)
							sum*=temp;
					}
				}
				
				sb.append(sum+"\n");
			}
			pw.print(sb.toString());
	}
		 
		public static void main(String[] args) throws Exception { new CanYouCount().run(); }
		  
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

