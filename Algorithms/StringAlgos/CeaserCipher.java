package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CeaserCipher {
	
	 private void solve() {
		 int Q=nextInt();
		while(Q-->0){
		 char[] A = nextString().toCharArray();
		 char[] B = nextString().toCharArray();
		 int aLen = A.length;
		 int diff=B[0]-A[0];
		 int cdiff=0;
		 if(diff<0)
			 cdiff=26+diff;
		 else
			 cdiff=diff;
		 for(int i=1;i<aLen;i++){
			 int temp = B[i]-A[i];
			 if(temp<0)
				 {
				 temp = 26+temp;
				 if(temp==cdiff)
					 continue;
				 else{
					 cdiff=-1;break;
				 }
			 }
			 else  if(temp==cdiff)
				 continue;
			 else{
				 cdiff=-1;break;
			 }
			 
		 }
				
		 pw.println(cdiff);			
		}		 
		 pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new CeaserCipher().run(); }
	  
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

