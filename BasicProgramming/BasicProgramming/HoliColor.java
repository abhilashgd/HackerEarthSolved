package BasicProgramming;
/*
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Arrays;
 
public class HoliColor {
	
	 StringBuilder sb = new StringBuilder();
	 private void solve() {
		int T=nextInt();
		while(T-->0){
			int N=nextInt();
			int Q=nextInt();
			char[] arr = nextString().toCharArray();
			
			while(Q-->0){
				int L=nextInt()-1;
				int R=nextInt()-1;
				int count=0;
				if(L<R){
						int clockCount=clockWise(L,R,arr);
						int anticlockCount= antiClockWise(L,0,arr)+antiClockWise(arr.length-1,R,arr);
					}
				else{
						count=antiClockWise(R,L,arr);
					}
					
				sb.append(count+"\n");
			}
		}
		pw.print(sb.toString());
}
	 int clockWise(int L,int R, char[] arr){
		 int count=0;
		 char tempChar=arr[L];
			for(int i=L+1;i<=R;i++){
				if(tempChar!=arr[i]){
					count++;
					tempChar=arr[i];
				}
			}
		 return count;
	 }
	 
	 int antiClockWise(int R,int L, char[] arr){
		 int count=0;
		 char tempChar=arr[R];
			for(int i=R-1;i>=L;i--){
				if(tempChar!=arr[i]){
					count++;
					tempChar=arr[i];
				}
			}
			return count;
	 }
	 
	 
 	
	public static void main(String[] args) throws Exception { new HoliColor().run(); }
	  
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
*/