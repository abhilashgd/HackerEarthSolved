package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class BitSwap {
	
	 private void solve() {
	
		 char[] A = nextString().toCharArray();
		 char[] B = nextString().toCharArray();
		 char[] C =A;
		 int aLen = A.length;
		 int bLen = B.length;
		 int count=0,sCount=0;
		 for(int i=0;i<aLen;i++)
			 for(int j=0;j<bLen;j++)
				 if(A[i]==B[j]){
					 count++;
					 A[i]='a';break;
				 }
		 if(count==aLen){
			 for(int i=0;i<aLen;i++){
				 if(C[i]!=B[i])
					 sCount++;
			 }
			 if(sCount%2==0)
				 pw.println(sCount/2-1);
			 else
				 pw.println(-1);
		 }
		 else
			 pw.println(-1);
			 
			 
		 pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new BitSwap().run(); }
	  
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
 
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

