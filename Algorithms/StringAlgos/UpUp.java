package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class UpUp {
	
	 private void solve() {
		
		 StringBuilder sb = new StringBuilder();
		 
		 String str = nextString();
		 String[] arr = new String[30000];
		 for(int i=0;i<30000;i++)
			 arr[i]="";
		 int len = str.length();
		 int index=0;
		 for(int i =0;i<len;i++)
		 {
			 if(str.charAt(i)!=' ')
				 arr[index]+=str.charAt(i);
			 else
				 index++;
		 }
		 
		 for(int i=0;i<index;i++){
			 	len=arr[i].length();
				 if(len==1 && arr[i]!="")
					 sb.append(Character.toUpperCase(arr[i].charAt(0))+" ");
				 else if(arr[i]!="")
				 sb.append(Character.toUpperCase(arr[i].charAt(0))+arr[i].substring(1, len)+" ");
				 else
					 sb.append(" ");
		 }
		 if(arr[index]!="")
			 sb.append(Character.toUpperCase(arr[index].charAt(0))+arr[index].substring(1, arr[index].length()));
		
		 pw.print(sb.toString());	 
	     pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new UpUp().run(); }
	  
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
 
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

