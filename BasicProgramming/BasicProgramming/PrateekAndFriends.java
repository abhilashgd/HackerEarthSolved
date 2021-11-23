package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class PrateekAndFriends {
	 static long sum=0;
	 private void solve() {
		 StringBuilder sb = new StringBuilder();
		 int T=nextInt();
		while(T-->0){
			int N=nextInt();
			int cost=nextInt();
			long[] arr =nextArray(N);
			boolean flag=false;
			for(int i=0;i<N;i++){
				long sum=0;int j=i;
				while(sum<=cost && j<N){
					sum+=arr[j];
					if(sum==cost)
					{
						flag=true;
						break;
					}
					j++;
				}
			}
			
			if(flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		 pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	
	private boolean isPalindrome(int i) {
		int sum=0,rem=0;int num=i;
		while(i>0){
			rem=i%10;
			sum=(sum*10)+rem;
			i=i/10;
		}
		return (num==sum);
	}

	public static void main(String[] args) throws Exception { new PrateekAndFriends().run(); }
	  
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
    private long[] nextArray(int n) {
        long[] a = new long[n];
        for(int i = 0;i < n;i++){a[i] = nextLong();sum+=a[i];}
        return a;
    }
    private long nextLong() {
        long num = 0;
        int b;
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

