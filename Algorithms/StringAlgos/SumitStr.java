package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SumitStr {

	 private void solve() {
		 int N=nextInt();
		 StringBuilder sb = new StringBuilder();
	     while(N-->0){
	     	String str = nextString();
	     	int len=str.length();
	     	boolean flag=false;
	     	if(len==1)
	     		flag=true;
	     	else if(len==2)
	     		if(Math.abs(str.charAt(0)-str.charAt(1))==1)
	     			flag=true;
	     		else
	     			flag=false;
	     	else
	     	for(int i=1;i<len-1;i++)
	     		if(isDifference(str.charAt(i),str.charAt(i+1),str.charAt(i-1)) )
	     			flag=true;
	     		else
	     			{flag=false;break;}
	     	if(flag)
	     		sb.append("YES"+"\n");
	     	else
	     		sb.append("NO"+"\n");
	     }
	     pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	 public boolean isDifference(char curr,char next,char prev){
		if(curr=='a'||curr=='z')
			if((Math.abs(curr-next)==1||Math.abs(curr-next)==25) && (Math.abs(curr-prev)==1||Math.abs(curr-prev)==25) )
				return true;
			else
				return false;
		else if(Math.abs(curr-next)==1 && Math.abs(curr-prev)==1 )
			 return true;
		 
		 return false;
	 }
	 
	  public static void main(String[] args) throws Exception { new SumitStr().run(); }
	  
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

