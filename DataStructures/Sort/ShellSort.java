/*
 * Better than Selection and bubble sort
 * Easy to implement
 * Adaptive
 * Stable
 * Efficient
 * 
 * worst case Time Complexity is O(n2)
 * Best Case Time Complexity is O(n2)
 * 
 */

package Sort;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ShellSort {
	
	 private void solve() {
			
		pw.println("Enter Number of Array Elements");	
		 int N = nextInt();
		pw.println("Enter array Elements: ");
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=nextInt();
		}
		shellSort(A,N);
		pw.println("Sorted Array IS:");
		for(int i=0;i<N;i++){
			pw.print(A[i]+" ");;
		}
			
		}
	 
	 static void shellSort(int[] A,int N){
		// Start with a big gap, then reduce the gap 
		    for (int gap = N/2; gap > 0; gap /= 2) 
		    { 
		        // Do a gapped insertion sort for this gap size. 
		        // The first gap elements a[0..gap-1] are already in gapped order 
		        // keep adding one more element until the entire array is 
		        // gap sorted  
		        for (int i = gap; i < N; i += 1) 
		        { 
		            // add a[i] to the elements that have been gap sorted 
		            // save a[i] in temp and make a hole at position i 
		            int temp = A[i]; 
		  
		            // shift earlier gap-sorted elements up until the correct  
		            // location for a[i] is found 
		            int j;             
		            for (j = i; j >= gap && A[j - gap] > temp; j -= gap) 
		                A[j] = A[j - gap]; 
		              
		            //  put temp (the original a[i]) in its correct location 
		            A[j] = temp; 
		        } 
		    } 
	 }
		 
	
	 
	  public static void main(String[] args) throws Exception { new ShellSort().run(); }
	  
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

