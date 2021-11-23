package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Arrays;
 
public class BestIndex {
	
	 StringBuilder sb = new StringBuilder();
	 private void solve() {
		int N=nextInt();
			int[] arr = nextArray(N);
			int splSum=arr[N-1];
			splSum=arr[N-2]>splSum?arr[N-2]:splSum;
			
			int[] twoArr=new int[3];
			twoArr[0]=0;
			twoArr[1]=arr[N-1];
			twoArr[2]=arr[N-2]+arr[N-1];

			int totalSum=0;
			for(int i=0;i<N;i++)
				totalSum+=arr[i];
		//	pw.print(totalSum+" ");
			int temp=N%3;
				splSum=(totalSum-twoArr[temp])>splSum?(totalSum-twoArr[1]):splSum;
			for(int i=1;i<N;i++){
				temp=(N-i-1)%3;
				totalSum-=arr[i-1];
			//	pw.print(totalSum+" ");
					splSum=(totalSum-twoArr[temp])>splSum?(totalSum-twoArr[1]):splSum;
			}
			
			sb.append(splSum+"\n");			

		pw.print(sb.toString());
}
 	
	public static void main(String[] args) throws Exception { new BestIndex().run(); }
	  
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
    static int Es=947;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}