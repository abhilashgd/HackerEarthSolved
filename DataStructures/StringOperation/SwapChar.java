package StringOperation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class SwapChar {
	
	
	 private void solve() {
		 int N=nextInt();
		 sBuilder str = new sBuilder();
		 String toBeSwapped;
		 char[][] swapChars = new char[N][2];
		 for(int i=0;i<N;i++)
		 {
			 swapChars[i][0]=nextChar();
			 swapChars[i][1]=nextChar();
		 }
		 toBeSwapped=nextLine();
		 
		
		 for(int i=0;i<N;i++){
			 		char[] arr= toBeSwapped.toCharArray();
			 		toBeSwapped=toBeSwapped.toLowerCase();
			 		char rTemp=Character.toLowerCase(swapChars[i][0]);
					char lTemp=Character.toLowerCase(swapChars[i][1]);
					int x = toBeSwapped.indexOf(rTemp);
					int y = toBeSwapped.indexOf(lTemp);
					if(Character.isUpperCase(arr[x]))
							lTemp=Character.toUpperCase(lTemp);
					if(Character.isUpperCase(arr[y]))
							rTemp=Character.toUpperCase(rTemp);					
					arr[x]=lTemp;
					arr[y]=rTemp;
					 toBeSwapped = new String(arr);
			 }
			 
		
 
		 str.setOutput(toBeSwapped);
		 str.getOutput();
	}
	


class sBuilder{
	private StringBuilder sb =new StringBuilder();
	
	void setOutput(String val){
		sb.append(val+"\n");
	}
	void setOutput(int val){
		sb.append(val+"\n");
	}
	void getOutput(){
		pw.println(sb.toString());
	}
	
	
}

	  public static void main(String[] args) throws Exception { new SwapChar().run(); }
	  
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
    private boolean isSpaceString(int c){return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
    private char nextChar() { return (char)skip(); }
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
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

