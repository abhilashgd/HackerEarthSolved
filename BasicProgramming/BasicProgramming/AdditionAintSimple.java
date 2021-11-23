package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
public class AdditionAintSimple {
	StringBuilder sb = new StringBuilder();
	private void solve() {
		int T=nextInt();
		while(T-->0)
		{
			String input = nextString();
			int len =input.length();
			int[] arr = new int[len];
			
			for(int i=0;i<len;i++)
				arr[i]=input.charAt(i)-96;
			for(int i=0,j=len-1;i<=len/2;i++,j--){
				arr[i]+=arr[j];
				if(arr[i]>26)
					arr[i]=arr[i]%26;
			}
			for(int i=0;i<=len/2;i++)
				sb.append((char)(arr[i]+96));
			if(len%2==0)
			for(int i=len/2;i>=0;i--)
				sb.append((char)(arr[i]+96));
			else
				for(int i=len/2-1;i>=0;i--)
					sb.append((char)(arr[i]+96));
					
			sb.append("\n");	
		}
		pw.print(sb.toString());
	}

public static void main(String[] args) throws Exception { 
	new Thread(null, new Runnable() {
		public void run() {
			try {
				new AdditionAintSimple().run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}, "1", 1 << 10).start();
	
 }
	
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