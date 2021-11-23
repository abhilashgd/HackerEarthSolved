package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Arrays;
 
public class AmanMrSharma {
		static final double pi =3.1425;
	 StringBuilder sb = new StringBuilder();
	 private void solve() {
		int T=nextInt();
		int count=0;
		while(T-->0){
			int r=nextInt();
			double h=nextInt()*100;
			double dist = 2*pi*r;
			if(h>dist)
				count++;
			
		}
		sb.append(count+"\n");
		pw.print(sb.toString());
}
 	
	public static void main(String[] args) throws Exception { new AmanMrSharma().run(); }
	  
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
    static int Es=947;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}