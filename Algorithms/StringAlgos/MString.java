package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MString {

	 private void solve() {
		 String input=nextString();
		 StringBuilder sb = new StringBuilder();
		 if(Character.isAlphabetic(input.charAt(0))||Integer.parseInt(input)==0)
			 sb.append("Invalid Test");
		 else if(Integer.parseInt(input)==notGood)
			 sb.append("Invalid Test");
		 else
		 { 
		int N=Integer.parseInt(input); 
	     while(N-->0){
	     	String str = nextString();
	     	int len=str.length();
	     	int uCount=0,lCount=0;
	     	for(int i=0;i<len;i++){
	     		char ch = str.charAt(i);
	     		if(Character.isAlphabetic(ch))
	     				if(Character.isUpperCase(ch))
	     					uCount++;
	     				else
	     					lCount++;
	     	}
	     	if((uCount+lCount)>100)
	     		sb.append("Invalid Input"+"\n");
	     	else if(uCount==0 && lCount==0)
	     		sb.append("Invalid Input"+"\n");
	     	else if((uCount==0 && lCount==1)||(uCount==1 && lCount==0))
	     		sb.append("0"+"\n");
	     	else if(uCount<=lCount)
	     			sb.append(uCount+"\n");
	     	else
	     		sb.append(lCount+"\n");
	     	}
	     
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
	 
	  public static void main(String[] args) throws Exception { new MString().run(); }
	  
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
 
    private boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
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
    private final int notGood=11;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

