/*
 * Not a Recommended Sorting Algorithm
 * Worst Case Time Complexity O(n) for logic without swapped flag
 * and Best Case Time Complexity of O(1)
 * 
 *Worst Case Time Complexity O(n2) for logic without swapped flag
 * Average Case Time Complexity is also O(n2)
 * 
 */

package Sort;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class BubbleSort {
	
	 private void solve() {
			
		pw.println("Enter Number of Array Elements");	
		 int N = nextInt();
		pw.println("Enter array Elements: ");
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=nextInt();
		}
		bubbleSort(A,N);
		pw.println("Sorted Array IS:");
		for(int i=0;i<N;i++){
			pw.print(A[i]+" ");;
		}
			
		}
	 
	 static void bubbleSort(int[] A,int N){
		 int pass,i,temp,swapped=1;
		 for( pass=N;pass>0 && (swapped==1);pass--){
			 swapped=0;
			 for(i=0;i<pass-1;i++){
				 if(A[i]>A[i+1]){
					 temp=A[i];
					 A[i]=A[i+1];
					 A[i+1]=temp;
					 swapped=1;
				 }
			 }
		 }
		 
		 
	 }
	 
	  public static void main(String[] args) throws Exception { new BubbleSort().run(); }
	  
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


