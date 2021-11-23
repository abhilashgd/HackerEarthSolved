package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class StrConv {
	static final int CHAR_SIZE=26;
	static final String error = "Error RNA nucleobases found!\n";
	 @SuppressWarnings("unchecked")
	private void solve() {
		 
		 StringBuilder sb = new StringBuilder();
		 int T=nextInt();
		while(T-->0){
			 int N=nextInt();
			 String str=nextString();
			 char[] chArr = new char[N];
			 if(str.length()==0)
				 break;
			
			 if(str.contains("U"))
				 	sb.append(error);
			 else{
				 ArrayList<Integer>[] a = new ArrayList[CHAR_SIZE];
				 for(int i=0;i<CHAR_SIZE;i++)
					 a[i] = new ArrayList<Integer>();
				 
				 for(int i=0;i<str.length();i++){
					 a[str.charAt(i)-'A'].add(i);
				 }
				 for(int i=0;i<a['A'-'A'].size();i++)
					 chArr[a['A'-'A'].get(i)]='T';
				 for(int i=0;i<a['T'-'A'].size();i++)
					 chArr[a['T'-'A'].get(i)]='A';
				 for(int i=0;i<a['G'-'A'].size();i++)
					 chArr[a['G'-'A'].get(i)]='C';
				 for(int i=0;i<a['C'-'A'].size();i++)
					 chArr[a['C'-'A'].get(i)]='G';
				 
				 for(int i=0;i<N;i++)
					 sb.append(chArr[i]);
					 
			 }
			 sb.append("\n");
		}
		 
		 pw.print(sb.toString());	 
	     pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new StrConv().run(); }
	  
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

