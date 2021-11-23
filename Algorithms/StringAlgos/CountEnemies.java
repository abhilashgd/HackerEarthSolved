package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CountEnemies {
	
	 private void solve() {
		
		 StringBuilder sb = new StringBuilder();
		 int N=nextInt();
		 while(N-->0){
		 String temp = nextString();
		 String[] str = new String[100000];
		 for(int i=0;i<100000;i++)
			 str[i]="";
		 int index=0;
		 int len = temp.length();
		 for(int i =0;i<len;i++)
		 {
			 if(temp.charAt(i)!='*')
				 str[index]+=temp.charAt(i);
			 else
				 index++;
		 }
		 int size=index;
		 int count=0;
		 	for(int i=0;i<=size && str[i]!=null;i++){
		 		 len = str[i].length();
		 		if(len==1){
		 			if(str[i].charAt(0)=='O')
		 				count++;
		 		}
		 		else if(len==2)
		 		{
		 			if(str[i].charAt(0)=='O')
		 				if(str[i].charAt(1)=='O')
		 					count+=2;
		 		}
		 		else{
		 			if(str[i].contains("X"))
		 				count+=0;
		 			else
		 				count+=str[i].length();
		 		}
		 		
		 	}
		 	sb.append(count+"\n");	
	 		
		 }
		 pw.print(sb.toString());	 
	     pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new CountEnemies().run(); }
	  
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

