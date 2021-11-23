package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class HackerBits {
	
	 private void solve() {
		 StringBuilder sb = new StringBuilder();
		 int N=nextInt();
		 int[] arr = new int[N];
		 for(int i=0;i<N;i++)
			 arr[i]=nextInt();
		 int maxc=0,cc=0,on=0,off=0;
		
		 for(int i=0;i<N;i++){
			 if(arr[i]==1)
				 	on++;
			else if(arr[i]==0)
			 {	off++;	
				int r=0; int l=0;
						for(int j=i-1;j>=0;j--)
							if(arr[j]==1)
								r++;
							else
							break;
						for(int k=i+1;k<N;k++)
							if(arr[k]==1)
								l++;
							else
							break;
				maxc=maxc<(r+l+1)?(r+l+1):maxc;		
			 }
		 }
		 if(off==N)
			 sb.append(ZERO);
		 else if(N==1 && on==1)
			 sb.append(ONE);
		 else if(on==N)
			 sb.append(N);
		 else if(maxc<=on)
			sb.append(maxc);
		 else
			 sb.append(maxc-1);
		 pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	
	public static void main(String[] args) throws Exception { new HackerBits().run(); }
	  
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
    private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
    }
	final static int ZERO=0;
	final static int ONE=1;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

