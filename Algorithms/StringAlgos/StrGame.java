package StringAlgos;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class StrGame {
	
	 private void solve() {
		
		 		int N=nextInt();
		 		String s = nextString();
		        String t = nextString();
		        int count=0;
		        for(int i=0;i<N;i++){
		        	if(s.charAt(i)==t.charAt(i))
		        		continue;
		        	else if(s.charAt(i)<t.charAt(i))
		        		if((t.charAt(i)-s.charAt(i))>13)
		        			count+=t.charAt(i)-s.charAt(i)-12;
		        		else
		        			count+=t.charAt(i)-s.charAt(i);
		        	if(s.charAt(i)>t.charAt(i)){
		        			int temp=13-('z'-s.charAt(i));
		        			int temp2=26-('z'-t.charAt(i));
		        			if((temp2+temp)>13)
		        					count+=13-(temp2+temp);
		        			else
		        				count+=temp2-temp;
		        				
		        	}
		        }
		 pw.println(count);
	     pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new StrGame().run(); }
	  
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
